package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {

    static class Node{
        int data;
        Node left;
        Node right;

        Node(int data)
        {
            this.data = data;
        }
    }

    public static void levelOrder(Node root)
    {
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        q.add(null);

        while(!q.isEmpty())
        {
            if(q.peek() != null)
            {
                Node node = q.remove();
                System.out.print(node.data + " ");
                if(node.left !=null)
                    q.add(node.left);
                if(node.right !=null)
                    q.add(node.right);
            }
            else{
                q.remove();
                System.out.println();

                if(q.isEmpty())
                    return;
                else    
                    q.add(null);
            }
        }
    }

    public static void main(String[] args) {

        Node rootNode = new Node(3);
        rootNode.left = new Node(9);
        rootNode.right = new Node(20);
        rootNode.right.left = new Node(15);
        rootNode.right.right = new Node(7);

        levelOrder(rootNode);
    }
    
}
