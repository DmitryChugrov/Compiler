package ru.Compiler.IDE;

import javax.swing.*;
import javax.swing.event.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.*;
import java.awt.*;
import java.io.*;

public class IDE extends JFrame {
    private JTree fileTree;
    private JTextArea codeEditor;
    private JTextArea outputConsole;
    private File currentFile;
    private File projectDirectory;

    public IDE() {
        setTitle("IDE");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Файловая структура слева
        fileTree = new JTree();
        JScrollPane fileScrollPane = new JScrollPane(fileTree);

        // Кодовый редактор в центре
        codeEditor = new JTextArea();
        JScrollPane editorScrollPane = new JScrollPane(codeEditor);

        // Консоль вывода снизу
        outputConsole = new JTextArea();
        outputConsole.setEditable(false);
        JScrollPane consoleScrollPane = new JScrollPane(outputConsole);

        // Разделение панелей
        JSplitPane splitPane1 = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, fileScrollPane, editorScrollPane);
        JSplitPane splitPane2 = new JSplitPane(JSplitPane.VERTICAL_SPLIT, splitPane1, consoleScrollPane);
        add(splitPane2, BorderLayout.CENTER);

        // Верхняя панель с кнопками
        JToolBar toolBar = new JToolBar();
        JButton projectButton = new JButton("Файл");
        JButton saveButton = new JButton("Сохранить");
        JButton compileButton = new JButton("Компиляция");
        JButton stopButton = new JButton("Стоп");
        JButton newProjectButton = new JButton("Создать проект");
        JButton openProjectButton = new JButton("Открыть проект");

        toolBar.add(newProjectButton);
        toolBar.add(openProjectButton);
        toolBar.add(projectButton);
        toolBar.add(saveButton);
        toolBar.add(compileButton);
        toolBar.add(stopButton);
        add(toolBar, BorderLayout.NORTH);

        // Действия для кнопок
        projectButton.addActionListener(e -> showFileMenu());
        saveButton.addActionListener(e -> saveFile());
        newProjectButton.addActionListener(e -> createNewProject());
        openProjectButton.addActionListener(e -> openProject());

        // Обработчик закрытия
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent windowEvent) {
                saveFile();
            }
        });

        // Слушатель выбора в JTree для открытия файла
        fileTree.addTreeSelectionListener(new TreeSelectionListener() {
            public void valueChanged(TreeSelectionEvent e) {
                DefaultMutableTreeNode selectedNode = (DefaultMutableTreeNode) fileTree.getLastSelectedPathComponent();
                if (selectedNode != null) {
                    File selectedFile = new File(projectDirectory, selectedNode.toString());
                    if (selectedFile.isFile()) {
                        openFile(selectedFile);
                    }
                }
            }
        });
    }

    private void showFileMenu() {
        JPopupMenu fileMenu = new JPopupMenu();
        JMenuItem openFile = new JMenuItem("Импорт");
        JMenuItem newFile = new JMenuItem("Создать");
        fileMenu.add(openFile);
        fileMenu.add(newFile);
        openFile.addActionListener(e -> openFileDialog());
        newFile.addActionListener(e -> createNewFile());
        fileMenu.show(this, 100, 40);
    }

    private void createNewProject() {
        JFileChooser dirChooser = new JFileChooser();
        dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = dirChooser.showSaveDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            projectDirectory = dirChooser.getSelectedFile();
            updateFileTree();
        }
    }

    private void openProject() {
        JFileChooser dirChooser = new JFileChooser();
        dirChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        int returnValue = dirChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            projectDirectory = dirChooser.getSelectedFile();
            updateFileTree();
        }
    }

    private void updateFileTree() {
        fileTree.setModel(new FileSystemModel(projectDirectory));
    }

    private void openFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            codeEditor.read(reader, null);
            currentFile = file;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openFileDialog() {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileFilter(new FileNameExtensionFilter("Code Files", "txt", "java", "pas"));
        int returnValue = fileChooser.showOpenDialog(this);
        if (returnValue == JFileChooser.APPROVE_OPTION) {
            currentFile = fileChooser.getSelectedFile();
            openFile(currentFile);
        }
    }

    private void createNewFile() {
        if (projectDirectory != null) {
            currentFile = new File(projectDirectory, "newFile.txt");
            try {
                if (currentFile.createNewFile()) {
                    codeEditor.setText("");
                    updateFileTree();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            JOptionPane.showMessageDialog(this, "Сначала создайте или откройте проект!", "Ошибка", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveFile() {
        if (currentFile == null) {
            JFileChooser fileChooser = new JFileChooser();
            int returnValue = fileChooser.showSaveDialog(this);
            if (returnValue == JFileChooser.APPROVE_OPTION) {
                currentFile = fileChooser.getSelectedFile();
            } else {
                return;
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(currentFile))) {
            codeEditor.write(writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new IDE().setVisible(true));
    }
}
