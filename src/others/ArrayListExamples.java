package lib.others;

import java.util.*;
import java.util.stream.Collectors;

public class ArrayListExamples {

    public static void main(String[] args) {

        convertArrayList();
    }

    static void initializeArrayList() {
        ArrayList<String> names1 = new ArrayList<>(Arrays.asList("alex", "brian", "charles"));
        System.out.println(names1);

        ArrayList<String> names = new ArrayList<>();

        //1. Add elements one by one
        names.add("alex");
        names.add("brian");
        names.add("charles");

        System.out.println(names);

        HashMap<String, Integer> details = new HashMap<>();

        details.put("keanu", 23);
        details.put("max", 24);
        details.put("john", 53);

        //2. Add elements from other collection
        names.addAll(details.keySet());

        System.out.println(names);
    }

    static void iterateArrayList() {
        ArrayList<String> namesList = new ArrayList<>(Arrays.asList( "alex", "brian", "charles") );

        for (String name : namesList) {
            System.out.println(name);
        }

        ListIterator<String> listItr = namesList.listIterator();
        while (listItr.hasNext()) {
            System.out.println(listItr.next());
        }

        namesList.forEach(name -> System.out.println(name));
    }

    static void addReplaceElement() {
        ArrayList<String> namesList = new ArrayList<>(Arrays.asList( "alex", "brian", "charles") );

        System.out.println(namesList); // list size is 3

        // add element at 0 index
        namesList.add(0, "Lokesh");

        System.out.println(namesList); // list size is 4

        //Add element at 0 index
        namesList.set(0, "john");

        System.out.println(namesList);  //list size is 4
    }

    static void addMultipleItems() {
        // list 1
        List<String> namesList = Arrays.asList("alex", "brian", "charles");

        // list 2
        ArrayList<String> otherList = new ArrayList<>();

        // copy all items from list 1 to list 2
        // otherList.addAll(namesList);

        // System.out.println(otherList);

        // skip element with value 'alex'
        namesList.stream()
                .filter(name -> !name.equals("alex"))
                .forEachOrdered(otherList::add);

        System.out.println(otherList);
    }

    static void replaceElement() {
        ArrayList<String> list = new ArrayList<>();

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list);

        // replace C with C_NEW
        // in single step replace D with D_NEW
        list.set(list.indexOf("D"), "D_NEW");

        System.out.println(list);
    }

    static void compareArrayLists() {
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));
        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        Collections.sort(listOne);
        Collections.sort(listTwo);

        // Compare unequal lists example
        boolean isEqual = listOne.equals(listTwo);
        System.out.println(isEqual);

        // Compare equals lists example
        ArrayList<String> listThree = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));

        isEqual = listOne.equals(listThree);
        System.out.println(isEqual);

        // find what are additional elements
        // ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));

        // ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        //remove all elements of second list
        // listOne.removeAll(listTwo);

        // System.out.println(listOne);


        // get the missing elements in first list
        // ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));

        // ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        //remove all elements from second list
        // listTwo.removeAll(listOne);

        // System.out.println(listTwo);

        // find common elements in two arraylists
        // ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));

        // ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        // listOne.retainAll(listTwo);

        // System.out.println(listOne);
    }

    static void removeDuplicateElements() {
        // ArrayList with duplicate elements
        // remove duplicate elements in arraylist using LinkedHashSet

        ArrayList<Integer> numberList = new ArrayList<>(Arrays.asList(1,1,2,3,3,3,4,5,6,6,6,7,8));

        System.out.println(numberList);

        LinkedHashSet<Integer> hashSet = new LinkedHashSet<>(numberList);

        ArrayList<Integer> listWithoutDuplicates = new ArrayList<>(hashSet);

        System.out.println(listWithoutDuplicates);

        // remove duplicates in arraylist - Java 8
        ArrayList<Integer> numbersList2 = new ArrayList<>(Arrays.asList(1,1,2,3,3,3,4,5,6,6,6,7,8));

        System.out.println(numbersList2);

        List<Integer> listWithoutDuplicates2 = numberList.stream().distinct().collect(Collectors.toList());

        System.out.println(listWithoutDuplicates2);
    }

    static void mergeTwoArrayLists() {
        // merge arraylists - List.addAll() method
        ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "f"));

        ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        listOne.addAll(listTwo);    //Merge both lists

        System.out.println(listOne);

        // merge arraylists - Java 8 Stream.flatMap()
        // ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        // ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "f", "g"));

        /*
        List<String> combinedList = Stream.of(listOne, listTwo)
                .flatMap(x -> x.stream())
                .collect(Collectors.toList());
         */

        // System.out.println(combinedList);

        // Merge two arraylists without duplicates
        // ArrayList<String> listOne = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e"));

        // ArrayList<String> listTwo = new ArrayList<>(Arrays.asList("a", "b", "c", "f", "g"));

        //1

        /*
        Set<String> set = new LinkedHashSet<>(listOne);
        set.addAll(listTwo);
        List<String> combinedList = new ArrayList<>(set);

        System.out.println(combinedList);

        //2

        List<String> listTwoCopy = new ArrayList<>(listTwo);
        listTwoCopy.removeAll(listOne);
        listOne.addAll(listTwoCopy);

        System.out.println(listOne);
         */
    }

    static void swapTwoElements() {
        // swap two elements in arraylist - Collections.swap()
        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d", "e", "f"));

        System.out.println(list);

        Collections.swap(list, 1, 2);

        System.out.println(list);
    }

    static void convertArrayList() {
        // convert arraylist to array - List.toArray()
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("how");
        arrayList.add("to");
        arrayList.add("do");
        arrayList.add("in");
        arrayList.add("java");

        String[] strArray = arrayList.toArray(new String[arrayList.size()]);

        System.out.println(Arrays.toString(strArray));

        // convert arraylist to string array - Java 8 stream
        String[] strArray2 = arrayList.stream().toArray(String[]::new);

        System.out.println(Arrays.toString(strArray2));
    }
}
