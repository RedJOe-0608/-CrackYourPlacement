package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class ViewsOfABinaryTree {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    static HashMap<Integer,Integer> map = new HashMap<>();
    static int max=0,min=0;


    public static void topView(Node root, int hd)
    {
        if(root == null)
            return;

        if(hd<min)
            min = hd;

        if(hd>max)
            max = hd;

        if(!map.containsKey(hd))
            map.put(hd,root.data);

        topView(root.left, hd-1);
        topView(root.right, hd+1);

    }

    public static void bottomView(Node root,int hd)
    {
        if(root == null)
            return;

        if(hd<min)
            min = hd;

        if(hd > max)
            max = hd;

        bottomView(root.left, hd-1);

        if(!map.containsKey(hd))
            map.put(hd,root.data);

        bottomView(root.right, hd + 1);
    }

    public static void leftView(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        //this is to indicate levelchange. Left view is basically the first node of each level.
        boolean levelChange = true;
        while (!q.isEmpty()) {
            
            if(q.peek() != null)
            {
                Node node = q.remove();

                if(levelChange)
                {
                    System.out.print(node.data + " ");
                    levelChange = false;
                }

                if(node.left !=null)
                    q.add(node.left);
                if(node.right !=null)
                    q.add(node.right);
            }

            else{
                levelChange = true;
                q.remove();
                if(!q.isEmpty())
                    q.add(null);
                else
                    return;
            }
        }

    }

    public static void rightView(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        Node node = null;
        while(!q.isEmpty())
        {
            if(q.peek() !=null)
            {
                node = q.remove();
                if(node.left !=null)
                    q.add(node.left);
                if(node.right !=null)
                    q.add(node.right);
            }
            else{
                System.out.print(node.data + " ");

                q.remove();
                if(!q.isEmpty())
                    q.add(null);
                else
                    return;
            }
        }
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

         topView(rootNode, max);

        //  bottomView(rootNode, max);

        //  System.out.println("Top view is: ");
        //  for(int i=min;i<=max;i++)
        //  {
        //     System.out.print(map.get(i) + " ");
        //  }

        leftView(rootNode);
        System.out.println();
        rightView(rootNode);
    }
    
}
