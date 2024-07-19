package Trees;

// Given the root of a binary tree, check whether it is a mirror of itself (i.e., symmetric around its center).

public class SymmetricTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }
    
    public static boolean checkSymmetric(Node leftNode, Node rightNode)
    {
        if(leftNode == null && rightNode == null)
            return true;

        if(leftNode == null || rightNode == null || leftNode.data !=rightNode.data)
            return false;

        if(!checkSymmetric(leftNode.right, rightNode.left))
            return false;
        
        if(!checkSymmetric(leftNode.left, rightNode.right))
            return false;

        return true;
    }

    public static boolean isSymmetric(Node root)
    {
        if(root == null)
            return false;

        return checkSymmetric(root.left, root.right);
    }
    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(4);
        root.right.left = new Node(4);
        root.right.right = new Node(3);

        if(isSymmetric(root))
            System.out.println("The tree is symmetric");
        else
            System.out.println("The tree is not symmetric");

    }
}
