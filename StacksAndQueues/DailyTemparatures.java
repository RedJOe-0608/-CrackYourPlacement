package StacksAndQueues;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemparatures {

    public static void main(String[] args) {
        int[] temperatures = {73,74,75,71,69,72,76,73};
        int[] output = new int[temperatures.length];
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < temperatures.length; i++) {
            while (!st.isEmpty() && temperatures[st.peek()] < temperatures[i]) {
                output[st.peek()] = i - st.pop();
            }

            st.push(i);
        }

        System.out.println(Arrays.toString(output));
    }
    
}