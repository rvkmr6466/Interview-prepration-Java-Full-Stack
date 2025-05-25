package brillio;

public class MySingleton {
    private static MySingleton instance;

    private MySingleton(){}

    public static MySingleton getInstance() {
        if (null == instance) { // ? constant will fist -> null == instance
            instance = new MySingleton(); // ?
        }
        return instance;
    }

    //

    public static String studentName() {
        StudentModel std = null;
        return std.firstName == null ? "null" : "no null";
    }

    public static void main(String[] args){
        MySingleton instance = getInstance();
        MySingleton instance1 = getInstance();

        System.out.println(instance.hashCode());
        System.out.println(instance1.hashCode());

        String std = studentName();
        System.out.println(std);

        // reflection API
        // breaking methods for singleton
        // What do we achieve with serializable?
        // bucket size
        // improving hashmap
        //
    }
}

// abhijit daga
