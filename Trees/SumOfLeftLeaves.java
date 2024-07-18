package Trees;

public class SumOfLeftLeaves {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
        }
    }

    public static int sumOfLeftLeaves(Node root)
    {
        if(root == null)
            return 0;

        int sum = 0;
        if(root.left !=null)
        {
            if(root.left.left == null && root.left.right == null)
            {
                sum+=root.left.data;
            }
            else{
                //if left is not a leaf node, do a recursive call.
                sum+=sumOfLeftLeaves(root.left);
            }
        }

        sum+=sumOfLeftLeaves(root.right);

        return sum;
    }

    public static void main(String[] args) {
        Node rootNode = new Node(3);
        rootNode.left = new Node(9);
        rootNode.right = new Node(20);
        rootNode.right.left = new Node(15);
        rootNode.right.right = new Node(7);

        System.out.println(sumOfLeftLeaves(rootNode));
    }
    
}
