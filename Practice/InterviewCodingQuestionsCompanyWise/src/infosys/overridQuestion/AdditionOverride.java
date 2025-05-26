package infosys.overridQuestion;

class AdditionOverride {
    public static void main(String[] args) {
        Example ex = new Example();
        int result1 = ex.add(5);
        int result2 = ex.add(5);
        System.out.println(result1);
        System.out.println(result2);

//        Error: java: method add(int) is already defined in class infosys.overridQuestion.Example
    }
}
