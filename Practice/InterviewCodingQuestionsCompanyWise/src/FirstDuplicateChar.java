import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstDuplicateChar {
    public static void main(String[] args) {
// Find the first non-repeated character in a String using Stream API.
// Example:
        String input= "swiss";
// Output: "w"

        Set<Character> set = new HashSet<>();
        Optional<Character> map = input.chars().mapToObj(c-> (char) c).collect(Collectors.groupingBy(
                Function.identity(),
                HashMap::new,
                Collectors.counting())).entrySet().stream().max(Map.Entry.comparingByValue()).map(x->x.getKey());
        System.out.println(map);
    }
}
