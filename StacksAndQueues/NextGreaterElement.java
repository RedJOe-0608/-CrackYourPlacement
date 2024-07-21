package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {

    public static int[] nextGreater(int[] arr)
    {
        Stack<Integer> s = new Stack<>();
        int[] output = new int[arr.length];

        for(int i=arr.length-1;i>=0;i--)
        {
            int curr = arr[i];
            if(!s.isEmpty())
            {
                if(curr < s.peek())
                {
                    output[i] = s.peek();
                    s.push(curr);
                }
                else{
                    while(!s.isEmpty() && curr > s.peek())
                    {
                        s.pop();
                    }
                    if(s.isEmpty())
                        output[i] = -1;
                    else
                        output[i] = s.peek();

                    s.push(curr);
                }
            }   
            else{
                s.push(curr);
                output[i] = -1;
            }
        }

        return output;
    }

    public static void main(String[] args) {
        int[] arr = {1,3,4,2};
        System.out.println(Arrays.toString(nextGreater(arr)));
    }
    
}
