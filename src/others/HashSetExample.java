package others;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class HashSetExample {

    public static void main(String[] args) {

        intersectionArrays();
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

    static void unionSet() {
        Integer[] firstArray = {5, 4, 3, 2, 1};
        Integer[] secondArray = {1, 3, 5, 7, 9};

        // Push first array in a HashSet instance
        HashSet<Integer> set = new HashSet<>();

        // Use addAll() method to add the elements of the second array into set
        set.addAll(Arrays.asList(firstArray));
        set.addAll(Arrays.asList(secondArray));

        System.out.println(set);

        // convert to array
        Integer[] union = {};
        union = set.toArray(union);

        System.out.println(Arrays.toString(union));
    }

    static void intersectionArrays() {
        Integer[] firstArray = {5, 4, 3, 2, 1};
        Integer[] secondArray = {1, 3, 5, 7, 9};

        // Push first array in a HashSet instance
        HashSet<Integer> set = new HashSet<>();

        set.addAll(Arrays.asList(firstArray));

        // Use retainAll() method to retain only elements which are present int second array
        set.retainAll(Arrays.asList(secondArray));

        System.out.println(set);

        Integer[] intersection = {};
        intersection = set.toArray(intersection);

        System.out.println(Arrays.toString(intersection));
    }
}

