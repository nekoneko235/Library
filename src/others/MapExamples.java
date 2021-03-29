package lib.others;

import java.util.*;

public class MapExamples {

    public static void main(String[] args) {
        System.out.println("\nSorting using Java8 streams\n");

        sortByValueJava8Stream();
    }

    private static void sortByValueJava8Stream()
    {
        Map<String, Integer> unSortedMap = getUnSortedMap();

        System.out.println("Unsorted Map : " + unSortedMap);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Sorted Map   : " + sortedMap);

        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
    }

    private static void sortByKeyJava8Stream()
    {
        Map<String, Integer> unSortedMap = getUnSortedMap();

        System.out.println("Unsorted Map : " + unSortedMap);

        LinkedHashMap<String, Integer> sortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey())
                .forEachOrdered(x -> sortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Sorted Map   : " + sortedMap);

        LinkedHashMap<String, Integer> reverseSortedMap = new LinkedHashMap<>();
        unSortedMap.entrySet().stream().sorted(Map.Entry.comparingByKey(Comparator.reverseOrder()))
                .forEachOrdered(x -> reverseSortedMap.put(x.getKey(), x.getValue()));

        System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
    }

    private static void sortByKeyUsingTreeMap()
    {
        Map<String, Integer> unSortedMap = getUnSortedMap();

        System.out.println("Unsorted Map : " + unSortedMap);

        Map<String, Integer> sortedMap = new TreeMap<String, Integer>(unSortedMap);

        System.out.println("Sorted Map   : " + sortedMap);

        Map<String, Integer> reverseSortedMap = new TreeMap<String, Integer>(Collections.reverseOrder());
        reverseSortedMap.putAll(unSortedMap);

        System.out.println("Reverse Sorted Map   : " + reverseSortedMap);
    }

    private static Map<String, Integer> getUnSortedMap()
    {
        Map<String, Integer> unsortMap = new HashMap<>();
        unsortMap.put("alex", 1);
        unsortMap.put("david", 2);
        unsortMap.put("elle", 3);
        unsortMap.put("charles", 4);
        unsortMap.put("brian", 5);
        return unsortMap;
    }

}
