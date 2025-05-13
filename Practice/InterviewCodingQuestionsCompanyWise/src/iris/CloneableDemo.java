package iris;

/**
 * Since `Cloneable` is an interface, it cannot have a default implementation in the traditional sense.
 * However, the `Object` class provides a `clone()` method that serves as the default implementation when
 * a class implements `Cloneable`. This default implementation performs a shallow copy, meaning it creates
 * a new object and copies the values of the original object's fields into it. If the fields are primitive
 * types or immutable objects, this is sufficient. However, if the fields are references to mutable objects,
 * both the original and the cloned object will share references to the same underlying objects.
 */
public class CloneableDemo implements Cloneable {
    private int id;
    private String name;
    private MutableObject mutableObject;

    // Constructor, getters, setters

    @Override
    public CloneableDemo clone() {
        try {
            CloneableDemo cloned = (CloneableDemo) super.clone();
            cloned.mutableObject = new MutableObject(this.mutableObject.getData()); // Deep copy
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(); // Should not happen as we implement Cloneable
        }
    }
}

class MutableObject {
    private String data;

    public MutableObject(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}