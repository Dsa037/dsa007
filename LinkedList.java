package hashtable_data;
public class LinkedList {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		singleLinkedlist mylist = new singleLinkedlist();
		
//		mylist.display();
		mylist.insertelements(1, 2, 3, 4, 5, 6, 7, 8, 9);
//		mylist.display();
//		mylist.insertAt1st(77);
//		mylist.display();
//		mylist.insertAt1st(88);
//		mylist.deleteLast();
// 		
//		mylist.display();
//		System.out.println(mylist.findbyValue(66));
//		System.out.println(mylist.findNodevalue(88));
//		mylist.lenght();
//		mylist.display();	
//		mylist.deleteany(9);
//		mylist.display();	
	mylist.insert(5);
		mylist.lenght();


		mylist.display();
		mylist.seconddelete();
//		mylist.deleteLast();
		mylist.display();
		mylist.lenght();
		mylist.seconddelete();
 		mylist.display();
		mylist.lenght();
		mylist.seconddelete();
 		mylist.display();
 		
 		mylist.secondinsert(10);
 		mylist.display();



	}
}

class link_Node {
	public int data;
	public link_Node next;

	public link_Node(int d) {
		this.data = d;
		next = null;
	}

	public link_Node(int d, link_Node n) {
		this.data = d;
		next = n;
	}
}

class singleLinkedlist {
	private link_Node head;
	private link_Node tail;
	private int size = 0;

	singleLinkedlist() {
		head = null;
		size = 0;
		System.out.println("empty list created");
	}

	public void lenght() {
		System.out.println(size);
		}

	public void insertelements(int... a) {
		for (int i : a) {
			link_Node newNode = new link_Node(i);
//			size++;
			insert(i);
		}
	}
	
	public void deleteLast() {
		link_Node target = head;
		link_Node pred = null;
		
		while (target.next != null) {
			pred = target;
			target = target.next;
		}
		pred.next = null;
		size--;
		System.out.println("deleted last ");
	}

	public void deleteany(int x) {
		if (x > size) { // if x size is grater the node
			System.out.println("Node Size is less then " + x + "Node size is " + size);
		} else { // else x size is less then or equal the node
			link_Node target = head;
			link_Node pred = null;
			int countnode = 1;
			if (x == 1) { // deleting 1st node
				head = target.next;
				size--;
				System.out.println("deleted 1st node, node size is " + size);
			} else if (x < 1) { // if user enterd 0
				System.out.println("node starts from 1");
				
			} else {
				while (countnode != x) {
					pred = target;
					countnode++;
					target = target.next;
				}
				pred.next = target.next;
				size--;
 			}
		}

	}

	public void seconddelete() {
		link_Node target = head;
	    link_Node pred = null;
		while (target.next.next != null) {
			pred = target;
		    target = target.next;
 		}
		System.out.println("second last deleted "+pred.next.data);

  		pred.next = target.next;
		size--;
	}
	
	public void secondinsert(int x) {
		link_Node newNode = new link_Node(x); // create a new node		
		size++; 
		if (head == null) { // first time insertion
			head = newNode;
			System.out.println("1st node added " + x);
		} 
		else { 
			link_Node target = head;
			link_Node pred = null;
			while (target.next != null) {
				pred = target;
			    target = target.next;
	 		}
	  		pred.next = newNode;
	  		newNode.next = target;
			System.out.println("node added in second last " + x);
		}
	}

	// insert x at last position
	public void insert(int x) {
		link_Node newNode = new link_Node(x); // create a new node
		size++; 
		if (head == null) { // first time insertion
			head = newNode;
			System.out.println("1st node added " + x);
		} 
		else { // insert at last
					// access last node
			link_Node target = head;
			while (target.next != null) {
				target = target.next;
			}
			// insert at last
			target.next = newNode;
			
			System.out.println("node added in last " + x);
		}
	}
	
	public void display() {
		if (size == 0) {
			System.out.println(" list is empty ");
		} else {
			link_Node target = head;
			while (target != null) {
				System.out.print(target.data + ", ");
				target = target.next;
			}
			System.out.println();

		}

	}

	public void insertAT(int x, int pos) { // insert at particular position
		if (head == null && size == 0) { // if list is empty and user enter > then 1
			System.out.println("insertion unsccessfull, list is empty try insert(" + x + ")");
		} else {
			link_Node newNode = new link_Node(x);
			size++;
			link_Node target = head;
			int nodecount = 1;
			link_Node pred = null;
			while (nodecount < pos) {// to access the position
				nodecount++;
				pred = target;
				target = target.next;
			}

			if (pos != 0) { // perform insertion
				newNode.next = target;
				pred.next = newNode;
			} 
			if (pos == 1) 
			{ // if user enters 1 address then we store data
				head = newNode;
			}
			System.out.println(x + " has been inserted at " + pos);
		}
	}

	public void insertAt1st(int n) {
		link_Node newNode = new link_Node(n);
		newNode.next = head;
		head = newNode;
		
	}
	
	 public void find( int x ){
	        link_Node target = head;
	        int counter = 1;
	        boolean isMatch = false;

	        while (isMatch == false && target.next != null){
	            if(target.data == x){
	                System.out.println(x + " is found at position: " + counter);
	                isMatch = true;
	                break;
	            }else{
	                target = target.next;
	                counter++;
	            }
	        }
	        if(isMatch == false){
	            System.out.println("not found");
	        }

	    }
	
	public String middle() { // middle node finding by by slow and fast trick
		link_Node slow = head;
		link_Node fast = head;
		link_Node target = head;
		while (fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		int i = 0, l = size / 2; // middle node finding by size divide into 2
		while (i != l) {
			target = target.next;
			i++;
		}
		return slow.data + " target " + target.data;

	}

	public int findbyValue(int value) { // finding node by data
		int add = 1;
		link_Node target = head;
		try {
			while (target.data != value) {
				target = target.next;
				add++;
			}
			return add;

		} catch (Exception e) { // if value not found
			return -1;
		}
	}
	
	public int findNodevalue(int add) { // finding data by node address
		int count = 1;
		link_Node target = head;

		if (add > size) { // if address grater then size
			return -5;
		} else {
			while (count != add) {
				target = target.next;
				count++;
			}
			return target.data;
		}
	}
}