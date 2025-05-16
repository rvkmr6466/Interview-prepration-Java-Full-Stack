// Create a Hashtable and perform the same operations as above.

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

class HashMapDemo {

    public static void main(String[] args) {

    }
    
    // Print all key-value pairs using the entrySet() method.
    public static void printKeyValuePairsUsingEntrySet() {
        Map<String, String> country = new HashMap<>();
        
        country.put("India", "New Delhi");
        country.put("US", "Washington DC");
        country.put("UK", "London");
        country.put("India", "New Delhi");
        country.put("Canada", "Ottawa");

        // Set<String> keys = country.keySet();
        // Map.Entry<String, Integer> entry : myMap.entrySet()
        
        for (Map.Entry<String, String> entry : country.entrySet()) {
            System.out.println(entry.getKey() + ":\t\t" + entry.getValue());
        }
    }
    
    // Print all values of a HashMap.
    public static void printAllValuesOfAHashMap() {
        Map<String, String> country = new HashMap<>();

        country.put("India", "New Delhi");
        country.put("US", "Washington DC");
        country.put("UK", "London");
        country.put("India", "New Delhi");
        country.put("Canada", "Ottawa");

        Set<String> keys = country.keySet();

        for (String key: keys) {
            System.out.println(country.get(key));
        }
    }
   
    // Print all keys of a HashMap.
    public static void printAllKeys(String[] args) {
        Map<String, String> country = new HashMap<>();

        country.put("India", "New Delhi");
        country.put("US", "Washington DC");
        country.put("UK", "London");
        country.put("India", "New Delhi");
        country.put("Canada", "Ottawa");

        Set<String> keys = country.keySet();

        for (String key: keys) {
            System.out.println(key);
        }
    }
    
    // Remove a key-value pair from a HashMap.
    public static void removeFromHashMap(String[] args) {
        Map<String, String> country = new HashMap<>();

        country.put("India", "New Delhi");
        country.put("US", "Washington DC");
        country.put("UK", "London");
        country.put("India", "New Delhi");
        country.put("Canada", "Ottawa");

        country.remove("US");

        System.out.println(country);
    }
  
    // Check if a specific key exists in a HashMap.
    // Check if a specific value exists in a HashMap.
    public static void specificKeyAndValueFromHashMap() {
        Map<String, String> country = new HashMap<>();

        country.put("India", "New Delhi");
        country.put("US", "Washington DC");
        country.put("UK", "London");
        country.put("India", "New Delhi");
        country.put("Canada", "Ottawa");

        if(country.get("UK")==null) {
            System.out.println("UK doesn't exist!");
        } else {
            System.out.println(country.get("UK"));
        }
        System.out.println(country.containsValue("Ottawa"));
    }

    // Insert five key-value pairs into a HashMap and print the map.
    public static void insertKeyValueAsCountryAndTheirCapital() {
        Map<String, String> country = new HashMap<>();

        country.put("India", "New Delhi");
        country.put("US", "Washington DC");
        country.put("UK", "London");
        country.put("India", "New Delhi");
        country.put("Canada", "Ottawa");

        System.out.println(country);
    }
    
    // Retrieve the value associated with a given key in a HashMap.
    public static void retrieveTheValueFromAMap() {
        Map<String, String> country = new HashMap<>();

        country.put("India", "New Delhi");
        country.put("Nepal", "Kathmandu");
        country.put("US", "Washington DC");

        System.out.println(country.get("US"));
    }

}
