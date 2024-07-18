package Trees;

public class InorderTraversal {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static void inorder(Node root)
    {
        if(root == null)
            return;

        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {

        Node rootNode = new Node(3);
        rootNode.left = new Node(9);
        rootNode.right = new Node(20);
        rootNode.right.left = new Node(15);
        rootNode.right.right = new Node(7);

        inorder(rootNode);
        
    }
    
}
