import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.junit.jupiter.api.Test;
import ru.Compiler.Semantic.SemanticAnalyzer;
import ru.Compiler.gen.TokensLexer;
import ru.Compiler.gen.TokensParser;

import java.util.List;

public class SemanticTest {
    @Test
    void test(){
        String input = "namespace ConsoleApplication;\n" +
                "interface\n" +
                "Program = class\n" +
                "public\n" +
                "class method main();\n" +
                "end;\n" +
                "implementation\n" +
                "class method Program.main();\n" +
                "begin\n" +
                "int r = 5+5+5+5+5;\n" +
                "print(r);\n" +
                "end;\n" +
                "end.";
        TokensLexer lexer = new TokensLexer(CharStreams.fromString(input));
        TokensParser parser = new TokensParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.program();

        SemanticAnalyzer analyzer = new SemanticAnalyzer();
        analyzer.visit(tree);

        List<String> threeAddressCode = analyzer.getCodeGenerator().getCode();

        for (String instruction : threeAddressCode) {
            System.out.println(instruction);
        }
        System.out.println("--------------------------------------");

        List<String> optimized = analyzer.getOptimizedCode();
        if (optimized != null) {
            for (String instruction : optimized) {
                System.out.println(instruction);
            }
        }
    }
// циклы не оптимизируем


}