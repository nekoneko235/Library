package others;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.*;

public class StringExamples {

    public static void main(String[] args) {

        findDuplicateCharacters();
    }

    static void convertStringToInt() {
        // Using Integer.parseInt() method
        int intVal = Integer.parseInt("1001");
        System.out.println(intVal);

        // Using Integer.valueOf() method
        // valueOf() returns Integer instance which is converted to int
        int intVal2 = Integer.valueOf("1001");
        System.out.println(intVal2);

        // Base X String to int

        // base 2
        System.out.println(Integer.parseInt("1001", 2));
        System.out.println(Integer.valueOf("1001", 2));

        // base 8
        System.out.println(Integer.parseInt("1001", 8));
        System.out.println(Integer.valueOf("1001", 8));

        // base 16
        System.out.println(Integer.parseInt("1001", 16));
        System.out.println(Integer.valueOf("1001", 16));
    }

    static void convertIntToString() {
        // 1. Converting int value to String value
        int intParam = 1001;
        String strValue1 = String.valueOf(intParam);
        String strValue2 = Integer.toString(intParam);

        // 2. Converting Integer object to String value
        Integer integerParam = 2018;
        String strValue3 = String.valueOf(integerParam);
        String strValue4 = integerParam.toString();

        // Verify results
        System.out.println(strValue1);
        System.out.println(strValue2);
        System.out.println(strValue3);
        System.out.println(strValue4);
    }

    static void convertFloatToString() {
        // java format float to String
        float pi = 3.1415927f;
        NumberFormat formatter = new DecimalFormat("0.00");
        String formmatedFloatValue = formatter.format(pi);

        System.out.println(formmatedFloatValue);
        System.out.println(formatter.format(1.1));
        System.out.println(formatter.format(1.123));

    }

    static void findDuplicateWords() {
        // java program to find repeated words
        String text = "a r b k c d se f g a d f s s f d s ft gh f ws w f v x s g h d h j j k f sd j e wed a d f";

        List<String> list = Arrays.asList(text.split(" "));

        Set<String> uniqueWords = new HashSet<>(list);
        for (String word : uniqueWords) {
            System.out.println(word + ": " + Collections.frequency(list, word));
        }
    }

    static String reverseStringRecursion(String string) {
        // reverse String using recursion
        if (string.isEmpty()) {
            return string;
        }
        // calling function recursively
        return reverseStringRecursion(string.substring(1)) + string.charAt(0);
    }

    static void reverseString() {
        String blogName = "How To Do In Java";

        StringBuilder reverseString = new StringBuilder(blogName).reverse();

        System.out.println(reverseString);
    }

    static void findDuplicateCharacters() {
        String blogName = "howtodoinjava dot com";
        char[] chars = blogName.toCharArray();

        Map<Character, Integer> map = new HashMap<>();
        for (char c : chars) {
            if (map.containsKey(c)) {
                int counter = map.get(c);
                map.put(c, ++counter);
            } else {
                map.put(c, 1);
            }
        }

        System.out.println("Duplicate characters:");

        // print duplicate characters
        for (char c : map.keySet()) {
            if (map.get(c) > 1) {
                System.out.println(c);
            }
        }

        System.out.println("Duplicate characters excluding white space :");

        // print duplicate characters excluding white space
        for (char c : map.keySet()) {
            if (map.get(c) > 1 && !Character.isWhitespace(c)) {
                System.out.println(c);
            }
        }

        System.out.println("Distinct characters:");

        //Print distinct characters
        for(char c : map.keySet()) {
            if(map.get(c) == 1) {
                System.out.println(c);
            }
        }

    }
}
