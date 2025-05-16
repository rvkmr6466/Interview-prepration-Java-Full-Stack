package ltiMindtree;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public class secondUniqueFromString {
    // second unique character
    public static void main(String[] args) {
        String str = "programming";
        Map<Character, Long> map = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()
        ));
        System.out.println(map); // Output: a
        Character ch = str.chars().mapToObj(c->(char)c).collect(Collectors.groupingBy(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()
        )).entrySet().stream().filter(n->n.getValue()==1).map(Map.Entry::getKey).skip(1).findFirst().orElse(null);
        System.out.println(ch); // Output: a
    }
}
