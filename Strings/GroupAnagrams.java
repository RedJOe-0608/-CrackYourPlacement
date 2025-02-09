package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class GroupAnagrams {

    public static ArrayList<ArrayList<String>> groupAnagrams(String[] strs)
    {
        HashMap<String,ArrayList<String>> map = new HashMap<>();

        for(String word: strs)
        {
            char[] chars = word.toCharArray();
            Arrays.sort(chars);

            String sortedWord = new String(chars);

            if(!map.containsKey(sortedWord))
                map.put(sortedWord, new ArrayList<>());

            map.get(sortedWord).add(word);
        }

        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        String [] strs = {"eat","tea","tan","ate","nat","bat"};
        System.out.println(groupAnagrams(strs));
    }
    
}
