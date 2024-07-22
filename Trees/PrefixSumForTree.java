package Trees;
import java.util.Arrays;

public class PrefixSumForTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    //if leaf node, return -1, we want height zero indexed for this question.
    public static int height(Node root)
    {
        if(root == null)
            return -1;

        return Math.max(height(root.left),height(root.right)) + 1;
    }

    public static void calculatePrefixSum(Node root,int[] prefix,int i)
    {
        if(root == null)
            return;

        //what is the prefix of a node? The prefix of a node is its parent, hence (i-1)/2.
        //Also, we are going for 0-index. hence 2*i+1 and 2*i+2;
        prefix[i] = i==0 ? root.data : prefix[(i-1)/2] + root.data;

        calculatePrefixSum(root.left, prefix, 2*i + 1);
        calculatePrefixSum(root.right, prefix, (2*i)+2);

    }

    public static void main(String[] args) {
        
        Node root = new Node(10);
        root.left = new Node(5);
        root.right = new Node(-3);
        root.right.right = new Node(11);
        root.left.left = new Node(3);
        root.left.right = new Node(2);
        root.left.right.right = new Node(1);
        root.left.left.left = new Node(3);
        root.left.left.right = new Node(-2);

        int arrSize = 0;
        int height = height(root);
        for(int i=0;i<=height;i++)
        {
            arrSize+=(int)Math.pow(2,i);
        }
        int[] prefix = new int[arrSize];
        calculatePrefixSum(root,prefix,0);

        System.out.println(Arrays.toString(prefix));
    }
    
}
