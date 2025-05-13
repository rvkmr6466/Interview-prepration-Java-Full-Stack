import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PercentageCalculator {

    // Method to parse and calculate the result from the expression string
    public static double calculate(String str) {
        str = str.trim();

        // Base case: if the string is just a number (e.g., "10" or "1.5%")
        if (str.matches("[\\d.]+%?")) {
            if (str.endsWith("%")) {
                // percentage value: remove % and parse
                String numberPart = str.substring(0, str.length() - 1);
                return Double.parseDouble(numberPart) / 100.0;
            } else {
                return Double.parseDouble(str);
            }
        }

        // Pattern to match increase/decrease with parameters, e.g., increase(10, 1.5%)
        Pattern pattern = Pattern.compile("(increase|decrease)\\s*\\((.+),\\s*(.+)\\)");
        Matcher matcher = pattern.matcher(str);

        if (matcher.matches()) {
            String operation = matcher.group(1);
            String valueStr = matcher.group(2);
            String percentStr = matcher.group(3);

            double value = calculate(valueStr);      // Recursive call to handle nested expressions
            double percentRaw = calculate(percentStr);

            double percentValue;
            if (percentStr.trim().endsWith("%")) {
                percentValue = percentRaw * value; // percentRaw is fraction (e.g., 0.015)
            } else {
                percentValue = percentRaw;
            }

            if (operation.equalsIgnoreCase("increase")) {
                return value + percentValue;
            } else { // decrease
                return value - percentValue;
            }
        } else {
            throw new IllegalArgumentException("Invalid expression: " + str);
        }
    }

    public static void main(String[] args) {
        String str1 = "increase (10, 1.5%)";
        String str2 = "increase (10, increase (10, 1.5%))";
        String str3 = "decrease (10, 2.5%)";

        System.out.println(str1 + " => " + calculate(str1)); // 10 + 0.015 * 10 = 10.15
        System.out.println(str2 + " => " + calculate(str2)); // 10 + (10 + 0.015*10)*0.015
        System.out.println(str3 + " => " + calculate(str3)); // 10 - 0.025 * 10 = 9.75
    }
}