public class bianry_tree_implemented_in_class {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 
		impbinary bt = new impbinary();

		bt.createTree(5);
		bt.insertleft(4);
		bt.insertleft(4);
		bt.insertleft(4);

		 
	}

}

class binarynode {
	public int data;
	public binarynode left;
	public binarynode right;

	binarynode(int d) {
		this.data = d;
		this.left = null;
		this.right = null;
	}
}

class impbinary {
	public binarynode root;

	public void createTree(int x) {
		root = new binarynode(x);

		System.out.println("root is created");
	}
	
	public void insertleft(int x) {
		binarynode newnode = new binarynode(x);
		if (root.left != null) {
			System.out.println("we have already left node");
		} else {
			root.left = newnode;
			System.out.println("inserted left");
		}
	}

	public void insertright(int x) {
		binarynode newnode = new binarynode(x);
		if (root.right != null) {
			System.out.println("we have already right node");
		} else {
			root.right = newnode;
			System.out.println("inserted right");
		}
	}
}