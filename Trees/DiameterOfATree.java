package Trees;


//diameter of a tree is defined as the longest path between any two nodes. Now, for a tree, the longest path will usually be from one end to the other, so the diameter would include leaves.

public class DiameterOfATree {

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

    public static int diameter1(Node root)
    {
        if(root == null)
            return 0;

        int lh = height(root.left);
        int lDia = diameter1(root.left);
        int rh = height(root.right);
        int rDia = diameter1(root.right);

        int selfDia = lh + rh + 1;

        return Math.max(selfDia, Math.max(lDia,rDia));
    }

    static class Info{
        int d;
        int ht;

        public Info(int d, int h)
        {
            this.d = d;
            this.ht = h;
        }
    }

    public static Info diameter2(Node root)
    {   
        if(root == null)
            return new Info(0,0);

        Info leftInfo = diameter2(root.left);
        Info rightInfo = diameter2(root.right);

        int d = Math.max((leftInfo.ht + rightInfo.ht + 1),Math.max(leftInfo.d,rightInfo.d));
        int ht = Math.max(leftInfo.ht,rightInfo.ht) + 1;

        return new Info(d,ht);

    }

    public static void main(String[] args) {
        
         /*
        
                          1
                      /      \
                    2         8 
                  /  \
                3     5
                 \     \
                  4     6
                 /       \
                10        7
                           \
                            9
        */ 

        Node root = new Node(1);
        root.left = new Node(2);
        root.left.left = new Node(3);
        root.left.right = new Node(5);
        root.left.left.right = new Node(4);
        root.left.left.right.left = new Node(10);
        root.left.right.right = new Node(6);
        root.left.right.right.right = new Node(7);
        root.left.right.right.right.right = new Node(9);
        root.right = new Node(8);

        System.out.println("Diameter: " + diameter1(root));
        System.out.println("Diameter: " + diameter2(root).d);
    }
    
}
