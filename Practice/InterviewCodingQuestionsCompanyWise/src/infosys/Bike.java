package infosys;

public class Bike {
    int speedlimit = 90;
    void run(){
        System.out.println("running");
    }
}
class Splendor extends Bike {
    int speedlimit = 150;
    void run(){
        System.out.println("running safely with 60km");
    }

    public static void main(String[] args) {
        Bike b = new Splendor();
        b.run();
        System.out.println(b.speedlimit);
    }
}