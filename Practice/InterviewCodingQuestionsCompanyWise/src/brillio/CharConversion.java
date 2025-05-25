package brillio;

import java.util.List;
import java.util.stream.Collectors;

public class CharConversion {
    public static void main(String[] args) {
        String str1 = "Hello, World!";
        String str = "fun times!";
        String vowels="aeiouAEIOU";
        StringBuilder res = new StringBuilder();
        System.out.println("methodUsingTraditional:: " + methodUsingTraditional(str, vowels, res));
        System.out.println("methodUsingStreamAPI:: " + methodUsingStreamAPI(str, vowels));
        System.out.println("methodUsingStreamAPI:: " + usingStreamForEach(str, vowels));
    }

    public static String methodUsingTraditional(String str, String vowels, StringBuilder res){
        for(char ch: str.toCharArray()) {
            char ch1 = (char) (ch+1);
            if(Character.isLetter(ch)) {
                if(vowels.indexOf(ch1) != -1) {
                    res.append(Character.toUpperCase(ch1));
                } else res.append(ch1);
            } else {
                res.append(ch);
            }

        }
        return res.toString();
    }

    private static String methodUsingStreamAPI(String str, String vowels) {
        String res = "";
        List<Character> list = str.chars().mapToObj(c -> (char) c).map(ch -> {
            char ch1 = (char) (ch.charValue() + 1);
            if (Character.isLetter(ch)) {
                return ch1;
            }
            if (vowels.indexOf(ch1) != -1) {
                Character.toUpperCase(ch1);
            }
            return ch;
        }).collect(Collectors.toList());
        return list.stream().map(String::valueOf).collect(Collectors.joining());
    }

    private static String usingStreamForEach(String str, String vowels) {
        StringBuilder res = new StringBuilder();

        str.chars().forEach(c -> {
            char ch = (char) c;
            if (Character.isLetter(ch)) {
                char next = (char) (ch + 1);
                if (vowels.indexOf(next) != -1) {
                    res.append(Character.toUpperCase(next));
                } else {
                    res.append(next);
                }
            } else {
                res.append(ch);
            }
        });

        System.out.println(res.toString());
        return res.toString();
    }
}
