package galaxE.TipleTon;

class MyTripleTon {
    // Array to hold the three instances
    private static final MyTripleTon[] instances = new MyTripleTon[3];
    private static int count = 0;

    // Private constructor to prevent direct instantiation
    private MyTripleTon() {
        System.out.println("TripleTon Instance Created");
    }

    // Static factory method to get instances
    public static synchronized MyTripleTon getInstance() {
        int index = count % 3;
        if (instances[index] == null) {
            instances[index] = new MyTripleTon();
        }
        count++;
        return instances[index];
    }

    // To identify the instance
    public void printInstance() {
        System.out.println("Instance: " + this.hashCode());
    }
}
