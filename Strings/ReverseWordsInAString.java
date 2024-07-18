package Strings;

public class ReverseWordsInAString {

    public static String reverseWords(String s) {

        //for initial white spaces
        int i=0;
        while(i < s.length() && s.charAt(i) == ' ')
        {
            i++;
        } 

        String newSentence = new String();
        String word = "";

        for(int j=i;j<s.length();j++)
        {
            
            char ch = s.charAt(j);
            if(ch != ' ')
            {
                word = word+ch;
            }else{
                while(j < s.length()-1 && s.charAt(j+1) == ' ')
                {
                    j++;
                }
                if(j==s.length()-1)
                    newSentence = word + newSentence;
                else
                    newSentence = " " + word + newSentence;
                
                word = "";
            }
        }

        if(word != "")
            newSentence = word + newSentence;

        return newSentence;
    }

    public static void main(String[] args) {
        String str = "The sky is blue";
        System.out.println(reverseWords(str));
    }
    
}
