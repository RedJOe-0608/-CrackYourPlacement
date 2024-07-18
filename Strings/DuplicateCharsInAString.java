package Strings;

import java.util.HashMap;
import java.util.Set;

public class DuplicateCharsInAString {

    public static void printDuplicates(String str)
    {
        HashMap<Character,Integer> map = new HashMap<>();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);
            if(map.containsKey(ch))
                map.put(ch,map.get(ch)+1);
            else
                map.put(ch,1);
        }

        // System.out.println(map);
        System.out.println("Frequency of characters");
        System.out.println("Character  \t     Frequency");
        Set<Character> set = map.keySet();

       for(char ch: set)
       {
            System.out.println(ch + "\t\t\t" + map.get(ch));
       }
    }

    public static void main(String[] args) {
        String str = "geeksforgeeks";
        printDuplicates(str);
    }
    
}
