public class DoubleLinkedTest {
	public static void main(String[] args) {
		Doublelinkedlist l = new Doublelinkedlist();
		l.insertat(1, 1);
		l.insertat(5, 2);
		l.insertat(77, 3);
		l.insertat(33, 1);
		l.insertat(88, 5);
		l.insertat(99, 6);
		l.insertat(22, 3);
		l.insertat(82, 8);
		l.deleteAt(4);
		l.deleteAt(3);
		l.displayFrom(4);
		l.displayFrom(1);
	}
}

class Node {
	public int data;
	Node pre, next;

	Node(int data) {
		this.data = data;
	}
}

class Doublelinkedlist {
	int size = 0;
	Node head, tail;

	Doublelinkedlist() {
		size = 0;
		head = null;
		System.out.println("Empty list is created!");
	}

	public void displayFrom() {
		if (size == 0) {
			System.out.println("nothing to show");
		} else {
			Node target = head;
			while (target != null) {
				System.out.print(target.data + " ");
				target = target.next;
			}
			System.out.println("\n");
		}
	}

	public void displayFrom(int Location) {
		if (size == 0) {
			System.out.println("list is empty");
		}
		if (Location == 0 || Location > size) {
			System.out.println("location not exist");
		} else {
			Node target = head;
			for (int i = 1; i <= size + 1; i++) {
				if (Location == i) {
					while (target != null) {
						System.out.print(target.data + " ");
						target = target.next;
					}
					System.out.println();
					break;
				}
				target = target.next;
			}
		}
	}

	public void deleteAt(int Location) {
		Node target = head;
		Node pred = null;
		for (int i = 1; i < Location; i++) {
			pred = target;
			target = target.next;
		}
		pred.next = target.next;
		target.pre = pred;
		System.out.println(target.data + " deleted location " + Location);
		size--;
		displayFrom();
	}

	public void insertat(int x, int location) {
		if (location > size + 1) {
			System.out.println("can not insert");
		}

		else if (location < 1 || location > size + 1) {
			System.out.println("location should be grater > 0");

		} else {
			Node newNode = new Node(x);
			if (head == null || location == 1) {
				newNode.next = head;
				head = newNode;
			} else if (location == size + 1) {
				Node target = head;
				while (target.next != null) {
					target = target.next;
				}
				target.next = newNode;
				newNode.pre = target;
			} else {
				Node pred = null;
				Node target = head;
				for (int i = 0; i < location - 1; i++) {
 					pred = target;
					target = target.next;
				}
				pred.next = newNode;
				newNode.next = target;
			}
			size++;
			System.out.println(x + " inserted location " + location);
			displayFrom();
		}
	}
}
