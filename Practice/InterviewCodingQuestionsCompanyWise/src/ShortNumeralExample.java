import java.util.HashMap;

public class ShortNumeralExample {

    public static void main(String[] args) {
        System.out.println(createShortNumeral("LLLXXXVVVV").equals("CC"));
        System.out.println(createShortNumeral("VVVIIIII").equals("XX"));
        System.out.println(createShortNumeral("II").equals("V"));

    }

    public static String createShortNumeral(String str) {
        HashMap<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int result = 0;

        if (str.length() < 2) {
            return str;
        }

        // Summing value of all characters
        for (int i = str.length() - 1; i >= 0; i--) {
            result += map.get(str.charAt(i));
        }

        String res = "";
        int div = 0;

        // Fix order of conversion: M -> D -> C -> L -> X -> V -> I
        if (result >= 1000) {
            div = result / 1000;
            for (int i = 0; i < div; i++) {
                res += 'M';
            }
            result = result % 1000;
        }

        if (result >= 500) {
            div = result / 500;
            for (int i = 0; i < div; i++) {
                res += 'D';
            }
            result = result % 500;
        }

        if (result >= 100) {
            div = result / 100;
            for (int i = 0; i < div; i++) {
                res += 'C';
            }
            result = result % 100;
        }

        if (result >= 50) {
            div = result / 50;
            for (int i = 0; i < div; i++) {
                res += 'L';
            }
            result = result % 50;
        }

        if (result >= 10) {
            div = result / 10;
            for (int i = 0; i < div; i++) {
                res += 'X';
            }
            result = result % 10;
        }

        if (result >= 5) {
            div = result / 5;
            for (int i = 0; i < div; i++) {
                res += 'V';
            }
            result = result % 5;
        }

        if (result >= 1) {
            div = result / 1;
            for (int i = 0; i < div; i++) {
                res += 'I';
            }
        }

        System.out.println("str:: " + str + " && res: " + res);
        return res;
    }

}
