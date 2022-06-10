package ppp;

public class mainTreeBinary {
	public static void main(String[] args) {

		Tree tree = new Tree();
		tree.addNode(10);
		tree.addNode(3);
		tree.addNode(5);
		tree.addNode(8);
		tree.addNode(65);
		tree.addNode(17);
		tree.addNode(19);
		tree.addNode(21);
		tree.addNode(35);

		int count = tree.countNodes(tree.root);

		System.out.println("Nodes | " + count);

		System.out.println("_" + "\n");

		tree.inOrderTravers(tree.root);

		System.out.println("_" + "\n");

		Node serachNode = tree.find(19);

		System.out.println("Found Node - Value | " + serachNode.value);

		//        tree.inOrderTravers(tree.root);
		tree.preOrderTravers(tree.root);
		System.out.println("");

		tree.inOrderTravers(tree.root);
		System.out.println("");

		tree.postOrderTravers(tree.root);

	}
}

class Node {
	int value;
	Node right;
	Node left;

	public Node(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

class Tree {
	Node root;

	public void addNode(int value) {

		Node newNode = new Node(value);

		if (root == null) {

			root = newNode;

		} else {

			Node currentNode = root;
			Node parent;

			while (true) {

				parent = currentNode;

				if (value < currentNode.value) {

					currentNode = currentNode.left;

					if (currentNode == null) {

						parent.left = newNode;
						return;

					}
				} else {

					currentNode = currentNode.right;

					if (currentNode == null) {

						parent.right = newNode;
						return;

					}
				}

			}
		}
	}

	public int countNodes(Node r) {

		if (r == null) {

			return 0;

		} else {

			int l = 1;
			l += countNodes(r.left);
			l += countNodes(r.right);
			return l;

		}
	}


	public void inOrderTravers(Node currentNode) {
//		System.out.println("");
		if (currentNode != null) {
			inOrderTravers(currentNode.left);
			System.out.print(currentNode.value+" ");
			inOrderTravers(currentNode.right);
		}
	}

	public void preOrderTravers(Node currentNode) {
//		System.out.println("");

		if (currentNode != null) {
			System.out.print(currentNode.value+" "); // w
			inOrderTravers(currentNode.left); // l
			inOrderTravers(currentNode.right); // r

		}
	}


	public void postOrderTravers(Node currentNode) {
//		System.out.println("");
		if (currentNode != null) {
			inOrderTravers(currentNode.left); // l
			inOrderTravers(currentNode.right); // r
			System.out.print(currentNode.value+" "); // w

		}
	}


	public Node find(int value) {

		Node currentNode = root;

		if (currentNode == null) {

			return null;
		}

		while (currentNode.value != value) {

			if (value < currentNode.value) {

				currentNode = currentNode.left;

			} else {

				currentNode = currentNode.right;

			}
		}
		return currentNode;

	}

}