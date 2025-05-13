package Coforge;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CoforgeDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12,56,77,10,43);
        String str = "Rerrtgg";
        lowestFreqChars(str);
        startWith1(list);
        startWith1UsingStream(list);

    }
    public static void startWith1(List<Integer> list){
        List<Integer> result = new ArrayList<>();
        for(Integer n: list) {
            boolean res = divide(n);
            if(res) {
                result.add(n);
            }
        }
        System.out.println("no with 1 digit:: "+ result.toString());
    }

    /**
     * TODO:
     * We need to find the min occuring first and on the basis of that we need to find the
     * least occuring character(s)
     */
    public static void lowestFreqChars(String str){
        Map<Character, Long> map = str.chars().mapToObj(c->(char) c).collect(Collectors.groupingBy(
                Function.identity(),
                Collectors.counting()
        ));
        List<Character> ls = map.entrySet().stream().map(x-> {
            if(x.getValue()<2) {
                return x.getKey();
            }
            return null;
        }).filter(n-> n!=null).collect(Collectors.toList());

        System.out.println("list of chars:: "+ls.toString());

    }

    public static boolean divide(int n) {
        if(n==1) {
            return true;
        } else if(n>=10)  {
                n/=10; // 112/10 -> 11
                return divide(n);
        } else {
            return false;
        }
    }

    public static void startWith1UsingStream(List<Integer> list) {
        List<Integer> ls = list.stream().filter(n->String.valueOf(n).startsWith("1")).collect(Collectors.toList());
        System.out.println("Numbers starts with 1:: " + ls.toString());
    }


}
