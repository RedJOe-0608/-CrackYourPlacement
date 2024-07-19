package Trees;

public class SubtreeOfATree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static boolean isIdentical(Node root, Node subRoot)
    {
        if(root == null && subRoot == null)
            return true;

        if(root == null || subRoot == null || root.data !=subRoot.data)
            return false;

        if(!isIdentical(root.left, subRoot.left))
            return false;

        if(!isIdentical(root.right, subRoot.right))
            return false;

        return true;
    }

    public static boolean isSubtree(Node root, Node subRoot)
    {
        if(root == null)
            return false;

        if(root.data == subRoot.data)
        {
            if(isIdentical(root,subRoot))
                return true;
        }

        return (isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot));
    }

    public static void main(String[] args) {
        
        /* Subtree
         *     2
         *    / \
         *   4   5
         */

         Node subRoot = new Node(2);
         subRoot.left = new Node(4);
         subRoot.right = new Node(5);
 
 
     /* *              1
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
 
         System.out.println(isSubtree(rootNode, subRoot));
    }
    
}
