package cloudAngel;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxOccurringCharacter {
    public static void main(String[] args) {
//        List<?> list = new ArrayList();
//        List<Object> list1 = new ArrayList();
//        List list2 = new ArrayList();
//        list.add(1);
//        list.add("A");
//        list.add(1.1);
//        list.add('B');
//        list.add(null);
//
//        System.out.println(list);

        String str = "string is immutable";
        Map<Character, Long> map = str.chars()
                .mapToObj(c-> (char) c)
                .collect(Collectors.groupingBy(
                        Function.identity(),
                        Collectors.counting()
                ));
        Character chr = map.entrySet().stream().max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
        System.out.println(map); // { =2, a=1, b=1, r=1, s=2, t=2, e=1, u=1, g=1, i=3, l=1, m=2, n=1}
        System.out.println(chr); // i
    }
}












