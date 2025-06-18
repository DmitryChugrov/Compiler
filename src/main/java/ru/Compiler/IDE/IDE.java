package ru.Compiler.IDE;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import ru.Compiler.Semantic.ErrorListener;
import ru.Compiler.Semantic.SemanticAnalyzer;
import ru.Compiler.ThreeAddressBytecode;
import ru.Compiler.gen.TokensLexer;
import ru.Compiler.gen.TokensParser;

import javax.swing.*;
import javax.swing.text.*;
import java.awt.*;
import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.util.List;

public class IDE extends JFrame {

    private JTextArea codeArea;
    private JTextPane outputArea;
    private Style errorStyle;
    private Style normalStyle;
    private String classN;

    public IDE() {
        setTitle("IDE");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Верхняя панель с кнопками
        JToolBar toolBar = new JToolBar();
        JButton saveButton = new JButton("Сохранить");
        JButton openButton = new JButton("Открыть");
        JButton compileButton = new JButton("Скомпилировать");

        toolBar.add(saveButton);
        toolBar.add(openButton);
        toolBar.add(compileButton);
        add(toolBar, BorderLayout.NORTH);

        // Область для кода
        codeArea = new JTextArea();
        JScrollPane codeScroll = new JScrollPane(codeArea);

        // Область для вывода (теперь JTextPane)
        outputArea = new JTextPane();
        outputArea.setEditable(false);
        JScrollPane outputScroll = new JScrollPane(outputArea);

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, codeScroll, outputScroll);
        splitPane.setResizeWeight(0.75); // 75% на код, 25% на вывод
        splitPane.setDividerLocation(450); // можно настраивать
        add(splitPane, BorderLayout.CENTER);

        // Стили для вывода
        StyledDocument doc = outputArea.getStyledDocument();
        errorStyle = doc.addStyle("Error", null);
        StyleConstants.setForeground(errorStyle, Color.RED);

        normalStyle = doc.addStyle("Normal", null);
        StyleConstants.setForeground(normalStyle, Color.BLACK);

        saveButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            chooser.setDialogTitle("Сохранить файл");
            chooser.setSelectedFile(new File(classN+".oxs"));

            int result = chooser.showSaveDialog(this);
            if (result == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                if (!file.getName().toLowerCase().endsWith(".oxs")) {
                    file = new File(file.getAbsolutePath() + ".oxs");
                }

                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    codeArea.write(writer);
//                    setOutput("Файл сохранён: " + file.getName(), false);
                } catch (IOException ex) {
                    setOutput("Ошибка при сохранении файла: " + ex.getMessage(), true);
                }
            }
        });

        openButton.addActionListener(e -> {
            JFileChooser chooser = new JFileChooser();
            if (chooser.showOpenDialog(this) == JFileChooser.APPROVE_OPTION) {
                File file = chooser.getSelectedFile();
                try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                    codeArea.read(reader, null);
//                    setOutput("Файл открыт: " + file.getName(), false);
                } catch (IOException ex) {
                    setOutput("Ошибка при открытии файла: " + ex.getMessage(), true);
                }
            }
        });

        compileButton.addActionListener(e -> {
            String input = codeArea.getText();
            clearOutput();

            try {
                TokensLexer lexer = new TokensLexer(CharStreams.fromString(input));
                ErrorListener errorListener = new ErrorListener();
                lexer.removeErrorListeners();
                lexer.addErrorListener(errorListener);

                TokensParser parser = new TokensParser(new CommonTokenStream(lexer));
                parser.removeErrorListeners();
                parser.addErrorListener(errorListener);
                ParseTree tree = parser.program();

                List<String> syntaxErrors = errorListener.getErrors();
                if (!syntaxErrors.isEmpty()) {
                    for (String err : syntaxErrors) {
                        setOutput(err, true);
                    }
                    return;
                }

                SemanticAnalyzer analyzer = new SemanticAnalyzer();
                analyzer.visit(tree);

                List<String> semanticErrors = analyzer.getSemanticErrors();
                if (!semanticErrors.isEmpty()) {
                    for (String err : semanticErrors) {
                        setOutput(err, true);
                    }
                    return;
                }

                List<String> threeAddressCode = analyzer.getCodeGenerator().getCode();

                List<String> optimized = analyzer.getOptimizedCode();
                String optimizedCode = String.join("\n", optimized);
                ThreeAddressBytecode threeAddressBytecode = new ThreeAddressBytecode();
                threeAddressBytecode.compile(optimizedCode);

                List<String> mgs = threeAddressBytecode.getInfo();
                if (!mgs.isEmpty()) {
//                    setOutput("Compilation error", true);
//                    for (String mess : mgs) {
//                        setOutput(mess, true);
//                    }
//                    return;
                }

                try {
                    String namespace = analyzer.getNamespaceName();
                    String className = analyzer.getClassName();
                    classN = className;
                    runGeneratedClass(namespace, className);
                } catch (Exception ex) {
                    StringWriter sw = new StringWriter();
                    ex.printStackTrace(new PrintWriter(sw));
                    setOutput("Error when starting the class:\n" + sw, true);
                }

            } catch (Exception ex) {
                StringWriter sw = new StringWriter();
                System.out.println(sw);
                ex.printStackTrace(new PrintWriter(sw));
                setOutput("Compilation error", true);
            }
        });
    }

    private void clearOutput() {
        outputArea.setText("");
    }

    private void setOutput(String message, boolean isError) {
        SwingUtilities.invokeLater(() -> {
            StyledDocument doc = outputArea.getStyledDocument();
            Style style = isError ? errorStyle : normalStyle;
            try {
                doc.insertString(doc.getLength(), message + "\n", style);
            } catch (BadLocationException e) {
                e.printStackTrace();
            }
        });
    }

    private void runGeneratedClass(String namespace, String className) throws Exception {
        File classesRoot = new File(".");
        URLClassLoader classLoader = new URLClassLoader(new URL[]{classesRoot.toURI().toURL()});

        String fullClassName = namespace + "." + className;

        Class<?> clazz = Class.forName(fullClassName, true, classLoader);
        Method mainMethod = clazz.getMethod("main", String[].class);

        PrintStream originalOut = System.out;
        PrintStream originalErr = System.err;

        OutputStream outputStream = new OutputStream() {
            private final StringBuilder sb = new StringBuilder();
            @Override
            public void write(int b) {
                char c = (char) b;
                sb.append(c);
                if (c == '\n') {
                    String text = sb.toString();
                    setOutput(text, false);
                    sb.setLength(0);
                }
            }
        };
        PrintStream ps = new PrintStream(outputStream, true);

        System.setOut(ps);
        System.setErr(ps);

        Thread thread = new Thread(() -> {
            try {
                mainMethod.invoke(null, (Object) new String[0]);
            } catch (InvocationTargetException e) {
                Throwable cause = e.getCause();
                StringWriter sw = new StringWriter();
                cause.printStackTrace(new PrintWriter(sw));
                setOutput("Error when executing main:\n" + sw, true);
            } catch (Exception e) {
                StringWriter sw = new StringWriter();
                e.printStackTrace(new PrintWriter(sw));
                setOutput("Error when executing main:\n" + sw, true);
            } finally {
                System.setOut(originalOut);
                System.setErr(originalErr);
            }
        });

        thread.start();
        thread.join();
        classLoader.close();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new IDE().setVisible(true));
    }
}
