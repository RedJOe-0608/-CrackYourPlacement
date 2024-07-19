package Trees;

public class PathSum {


    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static boolean hasPathSum(Node root, int targetSum,int sum)
    {
        if(root == null)
            return false;

        sum+=root.data;

        //leaf node
        if(root.left == null && root.right == null)
        {
            if(sum == targetSum)
                return true;
            else
                return false;
        }

        return hasPathSum(root.left, targetSum, sum) || hasPathSum(root.right, targetSum, sum);
    }

    public static void main(String[] args) {
         /*
         *             1
         *           /  \
         *          2    3
         *        /  \  / \     
         *       4    5    6
         */


         Node rootNode = new Node(1);
         rootNode.left = new Node(2);
         rootNode.right = new Node(3);
         rootNode.left.left = new Node(4);
         rootNode.left.right = new Node(5);
         rootNode.right.right = new Node(6);

         System.out.println(hasPathSum(rootNode, 10, 0));
    }
    
}
