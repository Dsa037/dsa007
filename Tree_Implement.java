import java.util.Scanner;

public class Tree_Implement {

	public static void main(String[] args) {
		Tree bt = new Tree();
 
		btnode root = bt.createTree();
		System.out.println("binary root is " + root.data);
		
		System.out.println("\n predorder");
		bt.preorder(root);
		System.out.println("\n Indorder");
		bt.inorder(root);
		System.out.println("\n postorder");
		bt.posteorder(root);
	}

}

class btnode {
	public int data;
	public btnode left;
	public btnode right;

	btnode(int d) {
		this.data = d;
		this.left = null;
		this.right = null;
	}
}

class Tree {
	public btnode root;
	
	public void preorder(btnode rt) {
		if (rt == null) {
			return;
		}
		else {
			System.out.print(" data :"+ rt.data);
		    preorder(rt.left);
		    
		    preorder(rt.right);
		}
	}

	public void inorder(btnode rt) {
		if (rt == null) {
			return;
		}
		else {
		    preorder(rt.left);
			System.out.print(" data :"+ rt.data);
		    preorder(rt.right);
		}
	}

	public void posteorder(btnode rt) {
		if (rt == null) {
			return;
		}
		else {
		    preorder(rt.left);
		    preorder(rt.right);
			System.out.print(" data :"+ rt.data);
		}
	}	
	
	public btnode createTree() {
		btnode roott = null;
		System.out.print("enter data :");

		Scanner sc = new Scanner(System.in);
		int data = sc.nextInt();
		if (data == -1) {
			return null;
		}

		roott = new btnode(data);	
		System.out.println("Enter left for " + data);
		roott.left = createTree();

		System.out.println("Enter right for " + data);
		roott.right = createTree();
		
		return roott;

	}
}