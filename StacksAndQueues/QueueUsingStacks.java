package StacksAndQueues;

import java.util.Stack;

public class QueueUsingStacks {

    static class Queue{

        Stack<Integer> s1;
        Stack<Integer> s2;

        public Queue()
        {
            this.s1 = new Stack<>();
            this.s2 = new Stack<>();
        }

        public void add(int x)
        {
            s1.add(x);
        }

        public int remove()
        {
            if(s2.isEmpty())
            {
                while(!s1.isEmpty())
                {
                    s2.push(s1.pop());
                }
            }

            return s2.pop();
        }

        public int peek()
        {
            if(s2.isEmpty())
            {
                while(!s1.isEmpty())
                {
                    s2.push(s1.pop());
                }
            }

            return s2.peek();
        }

        public boolean isEmpty()
        {
            return s1.isEmpty() && s2.isEmpty();
        }
    }

    public static void main(String[] args) {
        
        Queue q = new Queue();
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println(q.peek());
        System.out.println(q.remove());
        System.out.println(q.peek());
    }
    
}
