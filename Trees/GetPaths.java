package Trees;

import java.util.ArrayList;

public class GetPaths {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    public static boolean getPath(Node root, Node node, ArrayList<Node> path)
    {
        if(root == null)
            return false;

        path.add(root);

        if(root.data == node.data)
            return true;

        if(getPath(root.left, node, path) || getPath(root.right, node, path))
            return true;

        path.remove(path.size()-1);

        return false;
    }

    public static Node lca(Node root,Node n1, Node n2)
    {
        ArrayList<Node> p1 = new ArrayList<>();
        ArrayList<Node> p2 = new ArrayList<>();

        int ans = 0;

        getPath(root,n1, p1);
        getPath(root,n1, p2);

        for(int i=0;i<p1.size() && i < p2.size();i++)
        {
            if(p1.get(i).data != p2.get(i).data)
                ans = i-1;
        }

        return p1.get(ans);
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

         System.out.println("lca is: " + lca(rootNode, new Node(4), new Node(6)).data);
    }
    
}
