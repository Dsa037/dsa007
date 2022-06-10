package sotring;

public class binary_Search_tree_ok {
	
	 public static void main(String[] args){
	        binary_Search_tree_ok tree = new binary_Search_tree_ok();
	        tree.insert(50);
	        tree.insert(30);
	        tree.insert(20);
	        tree.insert(40);
	        tree.insert(70);
	        tree.insert(60);
	        tree.insert(80);
	        System.out.println("Pre-order traversal of the given tree: ");
	        tree.preorder();
	        System.out.println("\nDelete 20");
	        tree.deleteNode(20);
	        System.out.println("Pre-order traversal of the modified tree: ");
	        tree.preorder();
	        System.out.println("\nDelete 30");
	        tree.deleteNode(30);
	        System.out.println("Pre-order traversal of the modified tree: ");
	        tree.preorder();
	        System.out.println("\nDelete 50");
	        tree.deleteNode(50);
	        System.out.println("Pre-order traversal of the modified tree: ");
	        tree.preorder();
	    }
	
	
	
    Node root = null;
    class Node {
        int x;
        Node left;
        Node right;
        public Node(int data)
        {
            x = data;
            left = right = null;
        }
    }
    void deleteNode(int data) {
    root = deleteNode(root, data);
    }
    Node deleteNode(Node root, int data)
    {
        if (root == null)
            return root;
        if (data < root.x)
            root.left = deleteNode(root.left, data);
        else if (data > root.x)
            root.right = deleteNode(root.right,data);
        else {
            if (root.left == null)
                return root.right;
            else if (root.right == null)
                return root.left;
            root.x = minValue(root.right);
            root.right = deleteNode(root.right, root.x);
        }
        return root;
    }
    int minValue(Node root)
    {
        int minv = root.x;
        while (root.left != null)
        {
            minv = root.left.x;
            root = root.left;
        }
        return minv;
    }
    void insert(int key) {
    root = insertRec(root, key);
    }
    Node insertRec(Node root, int key){
        if (root == null) {
            root = new Node(key);
            return root;
        }
        if (key < root.x)
            root.left = insertRec(root.left, key);
        else if (key > root.x)
            root.right = insertRec(root.right, key);
        return root;
    }
    void preorder() {
    preorder(root);
    }
    void preorder(Node root){
        if (root != null) {
            System.out.print(root.x + " ");
            preorder(root.left);
            preorder(root.right);
        }
    }
   
}