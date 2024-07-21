package StacksAndQueues;

import java.util.Stack;

// Given two strings s and t, return true if they are equal when both are typed into empty text editors. '#' means a backspace character.

// Note that after backspacing an empty text, the text will continue empty.


// Example 1:

// Input: s = "ab#c", t = "ad#c"
// Output: true
// Explanation: Both s and t become "ac".

// Example 2:

// Input: s = "a#c", t = "b"
// Output: false
// Explanation: s becomes "c" while t becomes "b".

public class BackspaceStringCompare {

    public static boolean backspaceCompare(String s,String t)
    {
        Stack<Character> s1 = new Stack<>();
        Stack<Character> s2 = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            
            char ch = s.charAt(i);

            if(ch == '#')
            {
                if(!s1.isEmpty())
                    s1.pop();
            }
            else{
                s1.push(ch);
            }
            
        }

        for (int i = 0; i < t.length(); i++) {
            
            char ch = t.charAt(i);

            if(ch == '#')
            {
                if(!s2.isEmpty())
                    s2.pop();
            }
            else{
                s2.push(ch);
            }
            
        }

        //compare
        String res1 = new String();
        String res2 = new String();

        while(!s1.isEmpty())
        {
            res1+=s1.pop();
        }

        while(!s2.isEmpty())
        {
            res2+=s2.pop();
        }

        return res1.equals(res2);

    }

    public static void main(String[] args) {
        // String s = "ab#c", t = "ad#c";
        String s = "a#c", t = "ad#c";
        
        System.out.println(backspaceCompare(s, t));
    }
    
}
