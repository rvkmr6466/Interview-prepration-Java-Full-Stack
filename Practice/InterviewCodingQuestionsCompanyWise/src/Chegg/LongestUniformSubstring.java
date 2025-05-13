package Chegg;

public class LongestUniformSubstring {
    public static void main(String[] args) {
        String s = "aaabbbbbccda";
        int left = 0, count=1, maxLen = 0, maxStart = 0;

        for (int right=1;right<s.length(); right++) {
            if(s.charAt(right-1)==s.charAt(right)) { //
                count++; //2
            } else { //a==b
                if(count>maxLen) {
                    maxLen = count;
                    maxStart = left;
                    count=1;
                    left = right;
                }
            }
        }
        if (count> maxLen) {
            maxLen = count;
            maxStart = left;
        }
        System.out.println(maxStart + "::" + maxLen); // 3::5
        System.out.println("Substring:: "+s.substring(maxStart, maxStart+maxLen)); // bbbbb
    }
}
