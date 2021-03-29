package others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class HashSetExample {

    public static void main(String[] args) {

        convertHashSetToArrayList();
    }

    static void hashMethods() {
        // HashSet add, remove, iterator example
        // 1. Create HashSet
        HashSet<String> hashSet = new HashSet<>();

        // 2. add elements to HashSet
        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("D");
        hashSet.add("E");

        System.out.println(hashSet);

        // 3. check if element exists
        boolean found = hashSet.contains("A");
        System.out.println(found);

        // 4. remove an element
        hashSet.remove("D");

        // 5. iterate over values
        for (String value : hashSet) {
            System.out.println("Value: " + value);
        }
    }

    static void convertHashSeToArray() {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("D");
        hashSet.add("E");

        String[] values = new String[hashSet.size()];

        hashSet.toArray(values);

        System.out.println(Arrays.toString(values));
    }

    static void convertHashSetToArrayList() {
        HashSet<String> hashSet = new HashSet<>();

        hashSet.add("A");
        hashSet.add("B");
        hashSet.add("C");
        hashSet.add("D");
        hashSet.add("E");

        List<String> valuesList = hashSet.stream().collect(Collectors.toList());

        System.out.println(valuesList);
    }
}
