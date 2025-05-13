package coforge;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LeastOccurringCharactersFromAString {
    public static void main(String[] args) {
        String input = "character";
        List<Character> leastOccurringChars = findLeastOccurringChars(input);
        System.out.println("Least occurring characters: " + leastOccurringChars);
    }
    public static List<Character> findLeastOccurringChars(String input) {
        Map<Character, Long> frequencyMap = input.chars()
                .mapToObj(c -> (char) c) // Convert int to Character
                .collect(Collectors.groupingBy(c -> c, Collectors.counting())); // Group by character and count

        long minCount = frequencyMap.values().stream()
                .min(Long::compareTo)
                .orElse(0L); // Default to 0 if the string is empty

        return frequencyMap.entrySet().stream()
                .filter(entry -> entry.getValue() == minCount)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
