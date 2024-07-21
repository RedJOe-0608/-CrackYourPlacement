package StacksAndQueues;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsingQueues {

    static class Stack{

        Queue<Integer> q1;
        Queue<Integer> q2;

        public Stack()
        {
            this.q1 = new LinkedList<>();
            this.q2 = new LinkedList<>();
        }

        public void push(int x)
        {
            q1.add(x);
        }

        public int pop()
        {
            if(q1.size() == 1)
                return q1.remove();

            while(q1.size()!=1)
            {
                q2.add(q1.remove());
            }

            int res = q1.remove();

            while(!q2.isEmpty())
            {
                q1.add(q2.remove());
            }

            return res;
        }

        public int top()
        {
            if(q1.size() == 1)
                return q1.peek();

            while(q1.size()!=1)
            {
                q2.add(q1.remove());
            }

            int res = q1.remove();
            q2.add(res);

            while(!q2.isEmpty())
            {
                q1.add(q2.remove());
            }

            return res;
        }

        public boolean isEmpty()
        {
            return q1.isEmpty() && q2.isEmpty();
        }
    }

    public static void main(String[] args) {
        Stack s = new Stack();
        s.push(1);
        s.push(4);
        s.push(5);

        System.out.println(s.top());
        System.out.println(s.pop());
        System.out.println(s.top());
    }
    
}
