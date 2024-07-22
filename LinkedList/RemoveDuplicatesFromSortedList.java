package LinkedList;

public class RemoveDuplicatesFromSortedList {

    static class Node{
        int data;
        Node next;

        public Node(int data)
        {
            this.data = data;
        }
    }

    static Node head = null;

    public static void add(int data)
    {
        Node newNode = new Node(data);
        if(head == null)
        {
            head = newNode;
            return;
        }

        Node temp = head;

        while(temp.next!=null)
        {
            temp = temp.next;
        }

        temp.next = newNode;

    }

    public static void removeDuplicates()
    {
        if(head == null || head.next == null)
            return;

        Node temp1 = head;
        Node temp2 = head.next;

        while(temp2!=null)
        {
            if(temp2.data == temp1.data)
            {
                while (temp2!=null && temp2.data == temp1.data ) {
                    temp2 = temp2.next;
                }
                temp1.next = temp2;
            }
            else{
                temp1 = temp2;
                temp2 = temp2.next;
            }
        }
    }

    public static void print()
    {
        if(head == null)
        {
            System.out.println("List is empty!!");
            return;
        }

        Node temp = head;

        while(temp!=null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
       
        add(1);
        add(2);
        add(2);
        add(2);
        add(3);
        print();
        removeDuplicates();
        print();
    }
    
}
