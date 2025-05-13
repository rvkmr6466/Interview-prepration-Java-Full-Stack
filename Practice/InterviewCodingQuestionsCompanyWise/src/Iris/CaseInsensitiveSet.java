package Iris;

import java.util.HashSet;
import java.util.Set;

public class CaseInsensitiveSet {
    public static void main(String[] args) {
        Set<Character> characterSet = new HashSet<>();

        // Add characters to the set
        addCharacter(characterSet, 'a');
        addCharacter(characterSet, 'A');
        addCharacter(characterSet, 'b'); // Adding another character for demonstration

        // Print the set
        System.out.println("Set contents: " + characterSet);
        System.out.println("Set size: " + characterSet.size());
    }

    public static void addCharacter(Set<Character> set, char c) {
        // Convert character to lowercase before adding to the set
        set.add(Character.toLowerCase(c));
    }
}
