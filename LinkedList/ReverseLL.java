package LinkedList;

public class ReverseLL {

    static class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data = data;
            this.next = null;
        }
    }

    static Node head = null;

    public static Node reverse(Node head)
    {
        if(head == null)
            return null;

        Node curr = head,prev = null,temp = null;
        while(curr!=null)
        {
            prev = curr;
            curr = curr.next;
            prev.next = temp;
            temp = prev;
        }

        return prev;
    }

    public static void print(Node head)
    {
        Node temp = head;

        while(temp!=null)
        {
            System.out.print(temp.data+ "-->");
            temp = temp.next;

            if(temp == null)
                System.out.print("null");
        }
        System.out.println();

    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);

        print(head);
        head = reverse(head);

        print(head);
        
    }
    
}
