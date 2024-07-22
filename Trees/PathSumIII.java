package Trees;

import java.util.HashMap;

/*
  Given the root of a binary tree and an integer targetSum, return the number of paths where the sum of the values along the path equals targetSum.

The path does not need to start or end at the root or a leaf, but it must go downwards (i.e., traveling only from parent nodes to child nodes)

 */
public class PathSumIII {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    static int count = 0;
    static HashMap<Integer,Integer> map = new HashMap<>();

    public static void calculateNoOfPaths(Node root,int currSum, int targetSum)
    {
        if(root == null)
            return;

        currSum+=root.data;

        if(currSum == targetSum)
            count++;

        if(map.containsKey(currSum - targetSum))
            count+=map.get(currSum - targetSum);

        map.put(currSum,map.getOrDefault(currSum,0) + 1);

        calculateNoOfPaths(root.left, currSum, targetSum);
        calculateNoOfPaths(root.right, currSum, targetSum);

        //backtrack
        map.put(currSum, map.get(currSum) - 1);
        
    }

    public static void main(String[] args) {
        
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(5);
        root.left = new Node(3);
        root.left.right = new Node(4);
        root.right.right = new Node(6);

        calculateNoOfPaths(root, 0, 6);
        System.out.println(count);
    }
    
}
