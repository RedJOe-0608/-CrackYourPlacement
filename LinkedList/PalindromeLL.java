package LinkedList;

public class PalindromeLL {

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

    public static boolean isPalindrome(Node head)
    {
        if(head == null)
            return false;

        Node midNode = findMiddle(head);

        Node curr = midNode,prev = null,temp=null;

        while(curr!=null)
        {
            prev = curr;
            curr = curr.next;
            prev.next = temp;
            temp = prev;
        }

        Node lh = head;
        Node rh = prev;

        while(rh!=null)
        {
            if(lh.data !=rh.data)
                return false;
            lh = lh.next;
            rh = rh.next;
        }

        return true;
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(2);
        head.next.next.next = new Node(3);
        
        System.out.println(isPalindrome(head));
    }
    
}
