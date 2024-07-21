package Trees;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class AllNodesAtDistanceK {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static ArrayList<Integer> allNodes(Node root,Node target,int k)
    {
        Queue<Node> q = new LinkedList<>();
        HashMap<Integer,Node> map = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();

        q.add(root);

        //BFS1 - to store the parent-child relationship.

        while (!q.isEmpty()) {
            int size = q.size();

            for(int i=0;i<size;i++)
            {
                Node node = q.remove();

                if(node.left!=null)
                {
                    map.put(node.left.data,node);
                    q.add(node.left);
                }
                if(node.right!=null)
                {
                    map.put(node.right.data,node);
                    q.add(node.right);
                }
            }
        }


        //BFS2:
        HashMap<Integer,Integer> visited = new HashMap<>();

        q.add(target);
        while(k > 0 && !q.isEmpty())
        {
            int size = q.size();

            for(int i=0;i<size;i++)
            {
                Node node = q.remove();
                visited.put(node.data, 1);

                if(node.left!=null && !visited.containsKey(node.left.data))
                {
                    q.add(node.left);
                }

                if(node.right!=null && !visited.containsKey(node.right.data))
                {
                    q.add(node.right);
                }

                if(map.containsKey(node.data) && !visited.containsKey(map.get(node.data).data))
                {
                    q.add(map.get(node.data));
                }
            }

            k--;
        }

        while(!q.isEmpty())
        {
            list.add(q.remove().data);
        }

        return list;

    }

    public static void main(String[] args) 
    {
        
              /*
         *             1
         *           /  \
         *          2    3
         *        /  \  / \     
         *       4    5 6  7
         *           / \
         *          8   9
         *               \
         *               10 
         */


         Node rootNode = new Node(1);
         rootNode.left = new Node(2);
         rootNode.right = new Node(3);
         rootNode.left.left = new Node(4);
         rootNode.left.right = new Node(5);
         rootNode.right.left = new Node(6);
         rootNode.right.right = new Node(7);

         rootNode.left.right.left = new Node(8);
         rootNode.left.right.right = new Node(9);
         rootNode.left.right.right.right = new Node(10);

        Node target = rootNode.left;
        System.out.println( allNodes(rootNode,target, 3));


    }
    
}
