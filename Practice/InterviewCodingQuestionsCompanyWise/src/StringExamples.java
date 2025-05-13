import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class StringExamples {
/*
input: "aaabbbbccda" the longest uniform substring is "bbbb" (which starts at index 3 and is 4 characters long).

ex1 : s = "abc"
output = [0, 1]

ex2 s = "aabbbc"
         012
output = [2, 3]


ex3 s = "aabbbaaaa"
output = [5, 4]

ex3 s: "aaabbcccdeeeeee"
Output: [9, 6]
 */
    public static void main(String[] args) {
        String input = "aabbbaaaa";
        StringExamples s = new StringExamples();
        System.out.println(Arrays.toString(s.findLongestUniformSubstring(input)));
    }

    public int[] findLongestUniformSubstring(String input){
        int start = 0, end = 0, count = 0, maxLen=1, maxStart=0;

        if(input.length() < 2) { // means one only
            return new int[] {0,1};
        }
        
        while(end < input.length()-1){ //0<=2
            if (input.charAt(end) == input.charAt(end+1)) { // a==b
                count++; //2
            } else {
                if(count>maxLen) {
                    maxLen = count;
                    maxStart = start;
                }
                count=1;
                start = end + 1;
            }
            end++; // start = 0 && end = 2
        }
        if(count>maxLen) {
            maxLen=count;
            maxStart=start;
        }
        return new int[]{maxStart, maxLen};
    }
}
