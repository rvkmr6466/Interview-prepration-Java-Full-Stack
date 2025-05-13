package GalaxE.TipleTon;

public class Tripleton {
    public static void main(String[] args) {
        MyTripleTon t1 = MyTripleTon.getInstance();
        MyTripleTon t2 = MyTripleTon.getInstance();
        MyTripleTon t3 = MyTripleTon.getInstance();
        MyTripleTon t4 = MyTripleTon.getInstance();

        t1.printInstance();
        t2.printInstance();
        t3.printInstance();
        t4.printInstance();

        // Verifying instance uniqueness
        System.out.println(t1 == t4); // true, as it cycles back
    }
}