package iris;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class demo {
    public static void main(String[] args) {
        String str = "shashank";
        HashMap<Character, Integer> map = str.chars().mapToObj(c-> (char) c).collect(Collectors.toMap(
                Function.identity(),
                LinkedHashMap::new,
                Collectors.counting()
        ))
                .forEach((key,value)-> System.out.println("key: " + key + " value: " + value));
    }
}
