import java.util.Map;
import java.util.stream.Collectors;

public class MapDouble {
    public static Map<String, Integer> doubleMapValues(Map<String, Integer> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue() * 2
                ));
    }

    public static void main(String[] args) {
        Map<String, Integer> originalMap = Map.of("a", 1, "b", 2, "c", 3);
        Map<String, Integer> doubledMap = doubleMapValues(originalMap);
        System.out.println("Original Map: " + originalMap);
        System.out.println("Doubled Map: " + doubledMap);
    }
}
