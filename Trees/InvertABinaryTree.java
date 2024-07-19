package Trees;

public class InvertABinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static Node invert(Node root)
    {
        if(root == null)
            return null;
        
        Node leftNode = invert(root.left);
        Node rightNode = invert(root.right);

        //swap
        root.left = rightNode;
        root.right = leftNode;

        return root;
    }

    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);

        invert(root);

        System.out.println(root.left.data);
    }
    
}
