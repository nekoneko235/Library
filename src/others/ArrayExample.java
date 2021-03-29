package lib.others;

import java.util.*;

public class ArrayExample {

    public static void main(String[] args) {

        arrayToList();
    }

    static void printArray() {

        // Print array elements
        // An array of String objects
        String[] array = new String[] { "First", "Second", "Third", "Fourth" };

        // Print the array
        System.out.println(Arrays.toString(array));

        // Print nested arrays
        String[] arr1 = new String[] { "Fifth", "Sixth" };
        String[] arr2 = new String[] { "Seventh", "eight" };

        // An array of array containing String objects
        String[][] arrayOfArray = new String[][] { arr1, arr2 };

        // Print the nested array
        System.out.println(Arrays.deepToString(arrayOfArray));
    }

    static void copyArray() {
        String[] names = { "Alex", "Brian", "Charles", "David" };

        // Use arr.clone() method - Recommended
        String[] cloneOfNames = names.clone();

        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(cloneOfNames));

        // Use Arrays.copyOf() method - Most readable
        String[] copyOfNames = Arrays.copyOf(names, names.length);

        System.out.println(Arrays.toString(names));
        System.out.println(Arrays.toString(cloneOfNames));

    }

    static void copyArrayRange() {
        String[] names = { "Alex", "Brian", "Charles", "David" };

        // Subarray from index '0' (inclusive) to index '2' (exclusive)
        String[] partialNames = Arrays.copyOfRange(names, 0, 2);
        // [Alex, Brian]

        // Subarray to list
        List<String> namesList = Arrays.asList(Arrays.copyOfRange(names, 2, names.length));

        System.out.println(Arrays.toString(partialNames));
    }

    static void stringToStringArray() {
        String names = "alex,brian,charles,david";
        String[] namesArray = null;

        // Split string with comma
        namesArray = names.split(",");

        // Verify array content
        System.out.println(Arrays.toString(namesArray));

        String combinedNames1 = String.join("", namesArray);
        String combinedNames2 = String.join(" ", namesArray);
        String combinednames3 = String.join("-", namesArray);

        // Verify string
        System.out.println(combinedNames1);
        System.out.println(combinedNames2);
        System.out.println(combinednames3);

    }

    static void unionArrays() {
        Integer[] firstArray = {0, 2, 4, 6, 8};
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
        Integer[] firstArray = {0,1,2,3,4,5,6,7,8,9};
        Integer[] secondArray = {1,3,5,7,9};

        // Push first array in a HashSet instance
        HashSet<Integer> set = new HashSet<>();

        set.addAll(Arrays.asList(firstArray));

        // Use retainAll() method to retain only elements which are present in second array
        set.retainAll(Arrays.asList(secondArray));

        System.out.println(set);

        // convert to array
        Integer[] intersection = {};
        intersection = set.toArray(intersection);

        System.out.println(Arrays.toString(intersection));

    }

    static void removeDuplicates() {

        // Array with duplicate elements
        Integer[] numbers = new Integer[] {1,2,3,4,5,1,3,5};

        // This array has duplicate elements
        System.out.println(Arrays.toString(numbers));

        // Create set from array elements
        LinkedHashSet<Integer> linkedHashSet = new LinkedHashSet<>(Arrays.asList(numbers));

        // Get back the array without duplicates
        Integer[] numbersWithoutDuplicates = linkedHashSet.toArray(new Integer[] {});

        // Verify the array content
        System.out.println(Arrays.toString(numbersWithoutDuplicates));

    }

    static void containsElement() {
        String[] fruits = new String[] { "banana", "lemon", "apple", "orange" };

        if (Arrays.asList(fruits).contains("apple")) {
            System.out.println(Arrays.asList(fruits).indexOf("apple")) ;
        }

        if (Arrays.asList(fruits).contains("lion")) {
            System.out.println(Arrays.asList(fruits).indexOf("lion")) ;
        }
    }

    static void arrayToList() {
        // convert array to list - Immutable arraylist
        String[] namesArray = new String[] {"alex", "brian", "charles", "david" };

        List<String> namesList = Collections.unmodifiableList(Arrays.asList(namesArray));

        System.out.println(namesList);

        // convert array to list - Mutable arraylist
        List<String> namesList2 = Arrays.asList(namesArray);

        System.out.println(namesList2);
    }
}






















