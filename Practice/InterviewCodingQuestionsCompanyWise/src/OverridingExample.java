class Parent {
    public void print() {
        System.out.println("Parent");
    }
}

public class OverridingExample extends Parent {
//    @Override
    public void print() {
        System.out.println("OverridingExample");
    }


    /*
    In Overriding,
     */
    public static void main(String[] args) {
        Parent p = new OverridingExample();
        p.print();

        OverridingExample o = new OverridingExample();
        o.print();

        Parent p1 = new Parent();
        p1.print();

//        OverridingExample o1 = (OverridingExample) new Parent();
//        o1.print();
    }
}
