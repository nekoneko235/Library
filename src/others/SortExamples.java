package others;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortExamples {

    public static void main(String[] args) {

        System.out.println("Sorting using TreeMap");
        sortMapByKeyUsingTreeMap();
    }

    static void sortArray() {
        // Unsorted array
        Integer[] numbers = new Integer[] { 15, 11, 9, 55, 47, 18, 520, 1123, 366, 420 };

        // Sort the array
        // Arrays.sort(numbers);

        // Sort the array in reverse order
        // Arrays.sort(numbers, Collections.reverseOrder());

        // Sort the array range
        Arrays.sort(numbers, 2, 6);

        // Print array to confirm
        System.out.println(Arrays.toString(numbers));
    }

    static void sortList() {
        // Unsorted list
        Integer[] numbers = new Integer[] { 15, 11, 9, 55, 47, 18, 520, 1123, 366, 420 };
        List<Integer> numberList = Arrays.asList(numbers);

        // Sort the list
        Collections.sort(numberList);

        // Sort the list
        // Collections.sort(numberList, Collections.reverseOrder());

        // Print list to confirm
        System.out.println(numberList);

    }

    static void sortSet() {
        // Unsorted set
        HashSet<Integer> numbersSet = new LinkedHashSet<>(
                Arrays.asList(15, 11, 9, 55, 47, 18, 1123, 520, 366, 420)
        );

        // set -> list
        List<Integer> numbersList = new ArrayList<>(numbersSet);

        // Sort the list
        Collections.sort(numbersList);

        // list -> set
        numbersSet = new LinkedHashSet<>(numbersList);

        // Print set to confirm
        System.out.println(numbersSet);
    }

    static void sortMap() {
        // Sort map by key
        HashMap<Integer, String> map = new HashMap<>();

        map.put(50, "Alex");
        map.put(20, "Charles");
        map.put(60, "Brian");
        map.put(70, "Edwin");
        map.put(120, "George");
        map.put(10, "David");

        TreeMap<Integer, String> treemap = new TreeMap<>(map);
        System.out.println(treemap);

        // Sort map by value
        HashMap<Integer, String> unSortedMap = new HashMap<>();

        unSortedMap.put(50, "Alex");
        unSortedMap.put(20, "Charles");
        unSortedMap.put(60, "Brian");
        unSortedMap.put(70, "Edwin");
        unSortedMap.put(120, "George");
        unSortedMap.put(10, "David");

        //LinkedHashMap preserve the ordering of elements in which they are inserted
        LinkedHashMap<Integer, String> sortedMap = new LinkedHashMap<>();

        unSortedMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println(sortedMap);
    }

    static class tmpSorter implements Comparator<Pair> {
        @Override
        public int compare(Pair o1, Pair o2) {
            return o1.getSecond().compareTo(o2.getSecond());
        }
    }

    static void sortCustomObjects() {

        ArrayList<Pair> list = new ArrayList<>();
        list.add(new Pair(12, "caltech"));
        list.add(new Pair(12, "elte"));
        list.add(new Pair(11, "bme"));
        list.add(new Pair(9, "oxford"));
        list.add(new Pair(9, "kyoto uni"));

        // Collections.sort(list, new tmpSorter());

        // Sort with Java 8 Lambda
        // sorting list of pair by first elem descending and then sort again by second elem descending
         Comparator<Pair> tmpSorter = (a, b) -> {
             int tmp = b.getFirst().compareTo(a.getFirst());
             if (tmp == 0) {
                 tmp = b.getSecond().compareTo(a.getSecond());
             }
             return tmp;
         };
         Collections.sort(list, tmpSorter);

         System.out.println(list);
    }

    static void sortStringCharacters() {
        // Sort string with stream API
        String str = "adcbgekhs";
        String sortedChars = Stream.of(str.split(""))
                .sorted()
                .collect(Collectors.joining());
        System.out.println(sortedChars);

        // Arrays.sort()
        String str2 = "adcbgekhs";

        // convert string to char array
        char[] chars = str2.toCharArray();

        // sort char array
        Arrays.sort(chars);

        // convert char array to string
        String sortedString2 = String.valueOf(chars);

        System.out.println(sortedString2);
    }

    static void sortArrayList() {
        // List.sort() method
        // Unsorted list
        List<String> names = Arrays.asList("Alex", "Charles", "Brian", "David");

        // 1. Natural order
        names.sort(Comparator.comparing(String::toString));

        System.out.println(names);

        // 2. Reverse order
        names.sort(Comparator.comparing(String::toString).reversed());

        System.out.println(names);

        // Collections.sort() method
        // Unsorted list
        List<String> names2 = Arrays.asList("Alex", "Charles", "Brian", "David");

        // 1. Natural order
        Collections.sort(names2);

        System.out.println(names2);

        // 2. Reverse order
        Collections.sort(names2, Collections.reverseOrder());

        System.out.println();

        // sort arraylist of strings with Java 8 stream
        //Unsorted list
        List<String> names3 = Arrays.asList("Alex", "Charles", "Brian", "David");

        //1. Natural order
        List<String> sortedNames = names3
                .stream()
                .sorted(Comparator.comparing(String::toString))
                .collect(Collectors.toList());

        System.out.println(sortedNames);

        //2. Reverse order
        List<String> reverseSortedNames = names3
                .stream()
                .sorted(Comparator.comparing(String::toString).reversed())
                .collect(Collectors.toList());

        System.out.println(reverseSortedNames);
    }

    static void sortMapByValues() {
        Map<String, Integer> unSortedMap = getUnSortedMap();

        System.out.println("Unsorted Map: " + unSortedMap);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Sorted Map : " + sortedMap);

        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Reverse Sorted Map : " + reverseSortedMap);
    }

    static Map<String, Integer> getUnSortedMap() {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("alex", 1);
        unsortMap.put("davig", 2);
        unsortMap.put("elle", 3);
        unsortMap.put("charles", 4);
        unsortMap.put("brian", 5);
        return unsortMap;
    }

    static void sortMapByKeyUsingTreeMap() {
        Map<String, Integer> unsortedMap = getUnSortedMap();

        System.out.println("Unsorted Map : " + unsortedMap);

        Map<String, Integer> sortedMap = new TreeMap<>(unsortedMap);

        System.out.println("Sorted Map : " + sortedMap);

        Map<String, Integer> reverseSortedMap = new TreeMap<>(Collections.reverseOrder());
        reverseSortedMap.putAll(unsortedMap);

        System.out.println("Reverse Sorted Map : " + reverseSortedMap);
    }
}
