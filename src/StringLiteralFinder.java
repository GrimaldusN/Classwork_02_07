import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Найдите все строковые литералы в коде Java,
 * заключенные в двойные кавычки, исключая символы экранирования.
 */
public class StringLiteralFinder {
    public static List<String> findStringLiterals(String input) {
        List<String> literals = new ArrayList<>();

        // Регулярное выражение для поиска строковых литералов в коде Java
        String regex = "\"(?:\\\\\"|[^\"])*\"";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(input);

        while (matcher.find()) {
            // Используем unescapeJava() для преобразования экранированных символов
            literals.add(matcher.group());
        }

        return literals;
    }

    public static void main(String[] args) {
        String code = "String message = \"Hello, world!\";\n" +
                      "String path = \"C:\\\\Program Files\\\\Java\";";
        List<String> stringLiterals = findStringLiterals(code);
        for (String literal : stringLiterals) {
            System.out.println(literal);
        }
    }
}
