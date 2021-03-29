package others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.function.Consumer;

public class ArrayListMethods {

    public static void main(String[] args) {

        convertToStringArray();
    }

    static void addAll() {
        // list 1
        ArrayList<String> list1 = new ArrayList<>();

        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");

        // list 2
        ArrayList<String> list2 = new ArrayList<>();

        list2.add("E");
        list2.add("F");

        // Elements will be inserted from index 2
        list1.addAll(2, list2);

        // combined list
        System.out.println(list1);
    }

    static void clear() {
        ArrayList<String> arrayList = new ArrayList<>();

        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        System.out.println(arrayList);

        arrayList.clear();

        System.out.println(arrayList);
    }

    static void contains() {
        ArrayList<String> list = new ArrayList<>(2);

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        System.out.println(list.contains("A")); // true
        System.out.println(list.contains("Z")); // false
    }

    static void forEach() {
        ArrayList<String> names = new ArrayList<>(Arrays.asList("A", "B", "C", "D"));

        // 1
        names.forEach(name -> System.out.println(name.toLowerCase()));

        // 2
        Consumer<String> lambdaExpression = x -> System.out.println(x.toLowerCase());

        names.forEach(lambdaExpression);
    }

    static void removeAll() {
        ArrayList<String> alphabets = new ArrayList<>(Arrays.asList("A", "B", "A", "D", "A"));

        System.out.println(alphabets);

        alphabets.removeAll(Collections.singleton("A"));

        System.out.println(alphabets);
    }

    static void removeIf() {
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1,2,3,4,5,6,7,8,9,10));

        numbers.removeIf(number -> number % 2 == 0);

        System.out.println(numbers);
    }

    static void retainAll() {
        ArrayList<String> alphabets = new ArrayList<>(Arrays.asList("A", "B", "A", "D", "A"));

        System.out.println(alphabets);

        alphabets.retainAll(Collections.singleton("A"));

        System.out.println(alphabets);
    }

    static class Student {
        private Long id;
        private String name;

        public Student(Long id, String name) {
            super();
            this.id = id;
            this.name = name;
        }

        public Long getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return "Student [id=" + id + ", name=" + name + "]";
        }
    }

    static class NameSorter implements Comparator<Student>
    {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getName().compareToIgnoreCase(o2.getName());
        }
    }

    static class IdSorter implements Comparator<Student>
    {
        @Override
        public int compare(Student o1, Student o2) {
            return o1.getId().compareTo(o2.getId());
        }
    }

    static void sort() {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(1L, "Alex"));
        students.add(new Student(4L, "Brian"));
        students.add(new Student(3L, "David"));
        students.add(new Student(5L, "Charles"));
        students.add(new Student(2L, "Edwin"));

        students.sort(new NameSorter());
        System.out.println(students);
    }

    static void subList() {
        // get sublist of arraylist
        ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        ArrayList<Integer> sublist = new ArrayList<Integer>(list1.subList(2, 6));

        System.out.println(sublist);

        // remove sublist of arraylist
        ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6,7,8,9));

        list2.subList(2, 6).clear();

        System.out.println(list2);

    }

    static void convertToStringArray() {
        ArrayList<String> list = new ArrayList<>(2);

        list.add("A");
        list.add("B");
        list.add("C");
        list.add("D");

        // convert to string array
        String[] array = list.toArray(new String[list.size()]);

        System.out.println(Arrays.toString(array));
    }
}

