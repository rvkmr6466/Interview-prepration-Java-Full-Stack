package Freecharge;

import java.util.Arrays;
import java.util.HashMap;

public class FreechargeDemoOptimized {
//    Input: words = ["aba","bcb","ece","aa","e"], // n
//    queries = [[0,2],[1,4],[1,1]] // y
//    Output: [2,3,0]

    // first and last should be vowel
    public static void main(String[] args){
        String[] words = {"aba","bcb","ece","aa","e"};
        int[][] queries = {{0,2},{1,4},{1,1}};
        int[] output = vowelStrings(words, queries);

        System.out.println(Arrays.toString(output));
    }

    public static int[] vowelStrings(String[] words, int[][] queries) {
        String vowels = "aeiou";
        int len = words.length;
        int[] prefix = new int[len];

        // TODO: Complete it
//        if() {
//
//        }

        return new int[]{0};
    }
}

// object abstract class > // true
// constructor object

// pre sum problem
//



