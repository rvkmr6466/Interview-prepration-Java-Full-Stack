package NyalaZone;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NyalaZoneDemo {
    public static void main(String[] args) {
        List<String> list = Arrays.asList("1abc2", "pqr3st7u8vwx", "a1b2c3d4e5f", "treb7uchet");
        int count = 0;
        String num = "1234567890";
        List<List<Character>> temp = new ArrayList<>();

        for(String str: list) {
            List<Character> temp1 = new ArrayList<>();
            for(int i =0; i<str.length(); i++) {
                if(num.indexOf(str.charAt(i)) != -1) {
                    temp1.add(str.charAt(i));
                }
            }
            temp.add(temp1);
        }

        List<String> l1 = new ArrayList<>();
        for(List<Character> s: temp) {
            String c1 = "";
            for(char c11: s) {
                c1+=c11;
            }
            l1.add(c1);
        }

        for(int i =0; i < l1.size(); i++) {
            String s = l1.get(i);
            if(s.length() < 2) {
                int num11 = Integer.parseInt(String.valueOf(s.charAt(0)))*10 + Integer.parseInt(String.valueOf(s.charAt(0)));
                 count += num11;
            } else {
                 int str = Integer.parseInt(String.valueOf(s.charAt(0)))*10 + Integer.parseInt(String.valueOf(s.charAt(s.length()-1)));
                 count += str;
            }
        }
        System.out.println("count:: " + count);
    }
}
