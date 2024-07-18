package Strings;

// Given two strings needle and haystack, return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

 

// Example 1:

// Input: haystack = "sadbutsad", needle = "sad"
// Output: 0
// Explanation: "sad" occurs at index 0 and 6.
// The first occurrence is at index 0, so we return 0.
// Example 2:

// Input: haystack = "leetcode", needle = "leeto"
// Output: -1
// Explanation: "leeto" did not occur in "leetcode", so we return -1.

public class IndexOfFirstOccuranceOfAString {

    public static int indexOfFirstOccurance(String needle, String haystack)
    {
        for(int i=0;i<haystack.length();i++)
        {
            char ch = haystack.charAt(i);

            if(ch == needle.charAt(0))
            {
                int k = i;
                int j = 0;

                while(k<haystack.length() && j < needle.length() && haystack.charAt(k) == needle.charAt(j))
                {
                    j++;
                    k++;
                }

                if(j== needle.length())
                    return i;
                else
                    j = 0;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        String haystack = "sadbutsad", needle = "but";

        System.out.println(indexOfFirstOccurance(needle, haystack));
    }
    
}
