package globalLogic;

public class reverseStringWithSamePosition {
    public static void main(String[] args) {
        String s = "My name is Ravi Kumar";
        String rev = "";
        StringBuilder result = new StringBuilder();

        // output:: "yM eman si ivaR ramuK"
        for(int i=s.length()-1; i>=0; i--) {// rev -> ramuLK ivaR si.....
            rev+=s.charAt(i);
        }

        String[] strArr = rev.split(" ");

        for(int i=strArr.length-1; i>=0; i--) {
            result.append(strArr[i]).append(" ");
        }

        System.out.println("||"+result.toString().trim()+"||");

    }
}
