import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharacterFrequencyStream {
    public static void main(String[] args) {
//        Given a list of strings, find the most frequent character (case-insensitive) across all strings, but ignore spaces and digits.
//        Example:
//        Input: ["Java", "Streams 123", "are powerful!"]
//        Output: "a"

        List<String> list = Arrays.asList("Java", "Streams 123", "are powerful!");
        HashMap<Character, Integer> map = new HashMap<>();
        /*
        for (String str: list) {
            characterFrequency(str, map);
        }
        char mostFrequentChar = '\0'; // Initialize with a null character
        int maxCount = 0;

        for(Map.Entry<Character, Integer> entry: map.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                mostFrequentChar = entry.getKey();
            }
        }

        System.out.println("mostFrequentChar:: " + mostFrequentChar
        );
         */

        char ch = list.stream()
                .flatMap(s -> s.toLowerCase().chars() // Convert to lowercase and get IntStream of characters
                        .filter(Character::isLetter) // Filter out non-letter characters
                        .mapToObj(c -> (char) c)) // Convert IntStream to Stream<Character>
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting())) // Group and count characters
                .entrySet().stream()
                .max(Map.Entry.comparingByValue()) // Find entry with maximum value (count)
                .map(Map.Entry::getKey) // Extract the character (key)
                .orElse(null); // Return null if no characters found

        System.out.println(ch);

    }
    public static void characterFrequency(String s, HashMap<Character, Integer> map) {
        for (char c: s.toCharArray()) {
            map.put(c, map.getOrDefault(c,0)+1);
        }
    }
}
