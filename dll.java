
public class dll {
	public static void main(String[] args) {
		doublylinkedlist dll = new doublylinkedlist();

		dll.insertat(56, 1);
		dll.insertat(50, 2);
		dll.insertat(80, 3);
		dll.insertat(70, 4);
		dll.insertat(1, 5);
		dll.insertat(5, 6);
		dll.insertat(2, 4);
		dll.insertat(20, 8);

		dll.deleteAt(3);
		dll.deleteAt(4);

		System.out.println("display from");
		dll.displayfrom(3);
		dll.displayfrom(5);

	}

}

class doublylinkedlist {
	int size = 0;
	Node head, tail;

	doublylinkedlist() {
		size = 0;

	}

	public void insertat(int x, int location) {
		if (location > size + 1 || location < 0) {
			System.out.println("Can't insert at this location");
		}

		else if (location < 1 || location > size + 1) {
			System.out.println("position should be >= 1");

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
				newNode.prev = target;
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
			System.out.println(x + " is inserted");
			displayfrom(0);
		}
	}

	public void deleteAt(int location) {
		if (location == 0) {
			System.out.println("There is no 0 index");
		} else if (location > size) {
			System.out.println("location does'nt exist");
		} else {
			Node target = head;
			Node pred = null;
			for (int i = 1; i < location; i++) {
				pred = target;
				target = target.next;
			}
			pred.next = target.next;
			target.prev = pred;
			System.out.println(target.data + " is deleted");
			size--;
			displayfrom(0);
		}

	}

	public void displayfrom(int location) {
		if (size == 0) {
			System.out.println("Empty List");
		} else if (location > size) {
			System.out.println("location does not exist");
		}

		else {

			Node target = head;
			for (int i = 1; i <= location; i++) {
				target = target.next;
			}

			while (target != null) {
				System.out.print(target.data + ", ");
				target = target.next;
			}
			System.out.println();

		}
	}

	class Node {
		public int data;
		Node prev, next;

		Node(int data) {
			this.data = data;
		}
	}
}
