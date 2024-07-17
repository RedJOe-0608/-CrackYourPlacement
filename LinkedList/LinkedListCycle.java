package LinkedList;

public class LinkedListCycle {

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

    public static boolean hasCycle(Node head) {

        if(head == null)
            return false;
            Node slow =head;
            Node fast = head;
         while(fast !=null && fast.next !=null)
        {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast)
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = head;

        System.out.println(hasCycle(head));
    }
    
}
