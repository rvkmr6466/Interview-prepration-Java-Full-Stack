package nyalaZone;

import java.util.Arrays;
import java.util.List;

public class NyalaZoneDemoOptimize {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1abc2", "pqr3st7u8vwx", "a1b2c3d4e5f", "treb7uchet");
        int totalCount = 0;

        for (String str: list) {
            totalCount+=findTotalFromNumber(str);
        }

        System.out.println("totalCount:: " + totalCount);
    }

    public static int findTotalFromNumber(String str) {
        String s = "";
        for(char ch: str.toCharArray()) {
            if(Character.isDigit(ch)) {
                s+=ch;
            }
        }
        String s1 = String.valueOf(s.charAt(s.length() - 1));
        if(s.length() < 2) {
            String ss = s.charAt(0) + s1;
            return Integer.parseInt(ss);
        } else if (s.length() == 2){
            return Integer.parseInt(s);
        } else {
            String ss = s.charAt(0) + s1;
            return Integer.parseInt(ss);
        }
    }
}
