package Trees;

public class SameTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static boolean isIdentical(Node p, Node q)
    {
        if(p == null && q == null)
            return true;

        if(p == null || q == null || p.data !=q.data)
            return false;

        if(!isIdentical(p.left, q.left))
            return false;

            if(!isIdentical(p.right, q.right))
            return false;

        return true;
        
    }

    public static void main(String[] args) {
        
        Node root1 = new Node(1);
        root1.left = new Node(2);
        root1.right = new Node(3);

        Node root2 = new Node(1);
        root2.left = new Node(2);
        root2.right = new Node(3);

        System.out.println(isIdentical(root1, root2));
    }
    
}
