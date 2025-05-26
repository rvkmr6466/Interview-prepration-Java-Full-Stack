package infosys.privateOverride;

class Parent {
    private String method1() {
        return "Hello";
    }
}

public class Child extends Parent{
    public static void main(String[] args){
        Parent p = new Parent();
//        p.method1();  // ERROR: java: method1() has private access in infosys.privateOverride.Parent
    };
}
