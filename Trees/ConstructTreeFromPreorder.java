package Trees;

public class ConstructTreeFromPreorder {

    static class Node{
        int data;
        Node left;
        Node right;

        public Node(int data)
        {
            this.data = data;
        }
    }

    static int index = -1;
    public static Node constructTree(int n, int pre[], char preLN[]){
	    // code here
	    index++;
	    
	    if(preLN[index] == 'L')
	        return new Node(pre[index]);
	    
	    Node newNode = new Node(pre[index]);
	    newNode.left = constructTree(n,pre,preLN);
	    newNode.right = constructTree(n,pre,preLN);
	    
	    
	    return newNode;
	    
    }
    
    public static void main(String[] args) {
        int N = 5;
        int pre[] = {10, 30, 20, 5, 15};
        char preLN[] = {'N', 'N', 'L', 'L', 'L'};

        Node head = constructTree(N,pre,preLN);

        System.out.println(head.data);
    }
}
