package LinkedList;

public class FindMiddleInLL {

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

    public static Node findMiddle(Node head)
    {
        Node slow = head,fast = head;

        while(fast!=null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        System.out.println(findMiddle(head).data);
    }
    
}
