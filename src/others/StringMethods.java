package others;

import java.util.Arrays;

public class StringMethods {

    public static void main(String[] args) {

       lastIndexOf();
    }

    static void indexOf() {
        String s = "elte bme mit oxford elte";
        System.out.println(s.indexOf("elte"));
    }

    static void lastIndexOf() {
        String s = "elte bme mit oxford elte";
        System.out.println(s.lastIndexOf("elte"));
    }

    static void concat() {
        System.out.println("Hello".concat(" world"));
    }

    static void contains() {
        System.out.println("Hello World".contains("Hello"));
        System.out.println("Hello World".contains("Java"));
    }

    static void compareTo() {
        System.out.println( "apple".compareTo("banana") );  //-1 - apple comes before banana
        System.out.println( "apple".compareTo("cherry") );  //-2 - apple comes before cherry
        System.out.println( "cherry".compareTo("banana") ); //1  - cherry comes after banana
        System.out.println( "cherry".compareTo("cherry") ); //0  - Both strings are equal
    }

    static void split() {
        // The split()method in java.lang.String class returns a string array
        // after it splits the given string around matches of a given the regular expression.

        // split a string into an array with the given delimiter
        String str = "how to do-in-java-provides-java-tutorials";
        String[] strArray = str.split("-");
        System.out.println(Arrays.toString(strArray));

        // split string by whitespace
        String str2 = "how to do in java provides java tutorials";
        String[] strArray2 = str.split("\\s");
        System.out.println(Arrays.toString(strArray));

        // split a string into an array by comma
        String str3 = "A,B,C,D";
        String[] strArray3 = str.split(",");
        System.out.println(Arrays.toString(strArray));
    }

    static void replace() {
        // java string replace(char oldChar, char newChar) example
        String originalString = "Hello world !!";
        String newString = originalString.replace('o', 'O');
        System.out.println(originalString);
        System.out.println(newString);

        // java string replace(CharSequence target, CharSequence replacement) example
        String originalString2 = "how to do in java - java tutorials";
        String newString2 = originalString2.replace("java", "JAVA");
        System.out.println(originalString2);
        System.out.println(newString2);
    }

    static void substring() {
        // find substring with beginning index
        String text = "Hello, world";
        String substring = text.substring(3);
        System.out.println(substring);

        // find substring with beginning index and the end index
        String text2 = "Hello, world";
        String substring2 = text.substring(3, 10);
        System.out.println(substring2);
        System.out.println(substring2.length());
    }

    static void startsWith() {
        String name = "ELTE University";
        System.out.println(name.startsWith("ELTE"));
        System.out.println(name.startsWith("BME"));

        // java string startsWith(String str, int fromIndex)
        String name2 = "ELTE University";
        System.out.println(name2.startsWith("Univ", 5));
        System.out.println(name2.startsWith("ELTE", 2));
    }

    static void endsWith() {
        // java string endsWith(String str) method
        String name = "ELTE University";
        System.out.println(name.endsWith("sity"));
        System.out.println(name.endsWith("ELTE"));
    }

    static void upperLower() {
        // java convert string to uppercase example
        String string = "hello world";
        String uppercaseString = string.toUpperCase();
        System.out.println(uppercaseString);

        // java convert string to lowercase example
        String string2 = "Hello World";
        String lowercaseString = string2.toLowerCase();
        System.out.println(lowercaseString);
    }

    static void stringBuilder() {
        String str = "ELTE";

        // convert string to stringBuilder
        StringBuilder sb = new StringBuilder(str);

        // convert stringBuilder to string
        sb.toString();

        // concatenation
        // Not only string type, but int and char types allowed
        sb.append("what you want to concat");

        // insert at the certain position
        // sb.insert(int index, "what you want to concat")

        // delete substring
        // it doesn't include the endIndex
        // sb.delete(int beginIndex, int endIndex)

        // change an character at the certain position
        // sb.setCharAt(int index, char c)

        // reverse string
        // sb.reverse()

        // replacement string
        // sb.replace(int start, int end, "replace string")
    }
}
