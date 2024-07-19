package LinkedList;


public class RemoveLinkedListElements {

    static class Node{
        int data;
        Node next;

        public Node(int d)
        {
            this.data = d;
        }
    }

    static Node head = null;

    public static void add(int data)
    {
        if(head == null)
        {
            head = new Node(data);
            return;
        }

        Node newNode = new Node(data);
        Node temp = head;

        while(temp.next !=null)
        {
            temp = temp.next;
        }

        temp.next = newNode;

    }

    public static void print()
    {
        Node temp = head;

        while(temp !=null)
        {
            System.out.print(temp.data + "-->");

            temp = temp.next;

            if(temp == null)
            {
                System.out.print("null");
                System.out.println();
                return;
            }
        }
    }

    public static void removeElements(int val)
    {
        if(head == null)
            return;

        if(head.data == val)
        {
            while(head !=null && head.data == val)
            {
                head = head.next;
            }
        }

        Node temp = head,temp1 = head;

        while (temp!=null) {

            if(temp.data == val)
            {
                while(temp!=null && temp.data == val)
                {
                    temp1.next = temp.next;
                    temp = temp.next;
                }

            }
            if(temp !=null)
            {
                temp1 = temp;
                temp = temp.next;
            }
            
        }
    }

    public static void main(String[] args) {
        
        add(2);
        add(2);
        add(3);
        add(5);
        add(6);
        add(2);
        add(8);
        add(2);
        print();
        removeElements(2);
        print();
    }
    
}
