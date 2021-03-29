package others;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class HashMapMethods {

    public static void main(String[] args) {

        iterateHashMap();
    }

    static void addKeyValue() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        System.out.println(map);
    }

    static void getValueByKey() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        String value = map.get(2);

        System.out.println("The value is : " + value);
    }

    static void removePairByKey() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        System.out.println(map);

        map.remove(3);

        System.out.println(map);
    }

    static void iterateHashMap() {
        HashMap<Integer, String> map = new HashMap<>();

        map.put(1, "A");
        map.put(2, "B");
        map.put(3, "C");

        System.out.println(map);

        for (Integer key : map.keySet()) {
            String value = map.get(key);

            System.out.println("The Key is : " + key + ", and value is : " + value);
        }

        System.out.println(map);

        for (Map.Entry<Integer, String> entry : map.entrySet()) {
            System.out.println("The Key is : " + entry.getKey() + ", and value is : " + entry.getValue());
        }
    }

    /* List of methods in HashMap class and their short description.

    void clear() : removes all the key-value pairs from the HashMap.

    Collection values() : returns a collection of all values in the map.

    Object clone() : returns a shallow copy of the specified HashMap.

    Object get(Object key) : returns the value for the specified key in the HashMap.

    Object put(Key k, Value v) : Inserts key-value pair into the HashMap.

    Set keySet() : returns the Set of the all keys stored in the HashMap.

    Value remove(Object key) : removes the key-value pair for the specified key.

    boolean containsKey(Object key) : returns true or false based on whether the specified key is found in the map or not.

    boolean containsValue(Object Value) : Similar to containsKey() method, it looks for the specified value instead of key.

    boolean isEmpty() : checks whether the map is empty.

    int size() : returns the size of the map which is equal to the number of key-value pairs stored in the HashMap.

    void putAll(Map m) : copies all the elements of a map to the another specified map.
     */

}
