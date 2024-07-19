package Trees;

//maximum depth or height
public class MaximumDepthOfABinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static int height(Node root)
    {
        if(root == null)
            return 0;

        return Math.max(height(root.left),height(root.right)) + 1;
    }

    public static void main(String[] args) {

        /*
                    1
                  /  \
                 2    3
               /  
             4     
           /
          5

         */
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.left.left = new Node(5);

        System.out.println(height(root));
    }
    
}
