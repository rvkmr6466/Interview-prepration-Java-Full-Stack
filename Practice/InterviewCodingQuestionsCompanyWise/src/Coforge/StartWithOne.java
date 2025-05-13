package Coforge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StartWithOne {
    public static void startWith1() {
        List<Integer> list = Arrays.asList(12, 56, 77, 1, 10, 100);
        List<Integer> result = new ArrayList<>();
        for (Integer n : list) {
            boolean res = startsWithOne(n);
            if (res) {
                result.add(n);
            }
        }
        System.out.println("result: " + result.toString());
    }

    public static boolean startsWithOne(int n) {
        // Convert the number to a string and check the first character
        return String.valueOf(n).startsWith("1");
    }

    public static void main(String[] args) {
        startWith1();
    }
}

