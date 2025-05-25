package globalLogic;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CharsCounting {
    public static void main(String[] args) {

        String str = "javaprogramming";

        Map<Character, Long> map = str.chars().mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()));

                System.out.println(map);

        map.entrySet().stream()
                .filter(n->n.getValue()>1)
                .forEach(System.out::println);

    }
}
