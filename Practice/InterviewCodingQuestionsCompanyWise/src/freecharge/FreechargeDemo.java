package freecharge;

import java.util.Arrays;

public class FreechargeDemo {
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
        int[] output = new int[queries.length];
        for (int j=0; j<queries.length; j++) {
            int start = queries[j][0]; // 0
            int end = queries[j][1]; // 2
            int count = 0;
//
            for(int i=start; i<=end; i++) { // 0->2
//                String word = words[i]; // "aba"
                char startChar = words[i].charAt(0);
                char endChar = words[i].charAt(words[i].length()-1);
                if(vowels.indexOf(startChar) !=-1 && vowels.indexOf(endChar) !=-1) {
                    count++;
                }
            }
            output[j]=count;
        }
        return output;
    }
}

// object abstract class > // false
// constructor object

// pre sum problem
//



