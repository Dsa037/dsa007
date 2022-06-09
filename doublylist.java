public class doublylist {
	public static void main(String[] args) {
		Doublelinkedlist dl = new Doublelinkedlist();
		dl.insertAt(23, 1);
		dl.insertAt(38, 2);
		dl.insertAt(33, 3);
		dl.insertAt(78, 4);
		dl.insertAt(29, 5);
		dl.insertAt(86, 6);
		dl.insertAt(25, 5);
		dl.insertAt(45, 8);
  		dl.displayFrom(6);
		dl.displayFrom(2);
		dl.insertatlast(10);
		dl.insertatfirst(5);
		dl.insertatfirst(6);
		dl.insertatfirst(4);
		dl.insertatfirst(9);
		dl.insertatlast(2);
		
		dl.insertatlast(8);
		dl.insertAt(7,6);
		dl.daleteatfirst();
		dl.DELETE_AT_LAST();
		dl.DELETE_THE_SPECIFIC_NODE(6);
	}
}
class NodeD {
	public int data;
	NodeD pre, next;

	NodeD(int data) {
		this.data = data;
	}
}
class Doublelinkedlist {
	int size = 0;
	NodeD head, tail;

	Doublelinkedlist() {
		size = 0;
		head = null;
		System.out.println("Empty list is created!");
	}
	 public void insertatfirst(int x) {
		 if (head==null&& size==0) {
			 NodeD newNode=new NodeD(x);
			 size++;
				 head = newNode;
				 newNode.next= null;
			}
			 else if (head!= null) {
				 NodeD newNode=new NodeD(x);
			 size++;
				 head.pre = newNode;
				 newNode.next= head;
				 head=newNode;
				}
			
		 this.displayFrom();
		 
	 }
	 public void insertatlast(int x) {
		 if (head==null&& size==0) {
			 NodeD newNode=new NodeD(x);
			 size++;
			 System.out.println("list is empty that's why this time inserted at first in the list");
				 head = newNode;
				 newNode.next= null;}
		 else if (head!= null&& size!=0) {
		 
	NodeD target=head;
	
	NodeD newNode=new NodeD(x);
	 size++;
		 while(target.next!= null) {
			 target=target.next;
		 }
		 
		 newNode.pre = target;
		 target.next = newNode;
		 newNode.next=null;
		 }
	 
		 this.displayFrom();
	 }
	 
	 public void insertAt(int x, int y) {
		 if (head==null&& size==0) {
			 System.out.println("cant inserted because list is empty");
		 }
		 else if (head!= null&& size!=0||y > size + 1||y< 1 ) {
			 
				NodeD target=head;
				
				NodeD newNode=new NodeD(x);
				 size++;
					 while(target.data!= y) {
						 target=target.next;
					 }
					 newNode.next=target.next;
					 target.next=newNode;
					 newNode.pre=target;
					
					 }
		 this.displayFrom();
	 }
	
	public void daleteatfirst() {
		 if (head==null&& size==0) {
			 System.out.println("cant deleted because list is empty");}
			 else 
			 
					if(head.next==null) 
					{
						System.out.println("DELETION PERFOEMED WHEN ONLY ONE VALUE IN LIST AT: " +head.data );
					head=null;
					
					size--;
				}
				
				else {
					System.out.println("DELETION PERFOEMED FROM BEGINING OF THE LIST AND ELEMENT IS: "+ head.data);
					head=head.next;
					size--;
				}
		 displayFrom();
	}
	
	public void DELETE_AT_LAST() {
		if (head==null) {
			System.out.println("OOPS THE LIST IS EMPTY");
			System.out.println(" *PLEASE INSERT SOME AT FISRT SO YOU CAN PERFOAM DELETION * ");
			
			}
		else {
		NodeD target=head;
		while (target.next.next!= null) {
			target=target.next;
		}
		
		System.out.println("DELETION PERFOEMED FROM LAST OF THE LIST AND ELEMENT IS: "+ target.next.data);
		target.next=null;
		
		size--;
		System.out.println();
		}
		 displayFrom();
	}
	public void DELETE_THE_SPECIFIC_NODE(int y) {
		if (head==null) {
			System.out.println("OOPS THE LIST IS EMPTY");
			System.out.println(" *PLEASE INSERT SOME AT FISRT SO YOU CAN PERFOAM DELETION * ");
			
			}
		else {
		NodeD target=head;
		NodeD pred=null;
		
		while (target.data!= y) {
			pred=target;
			target=target.next;
			
		}
		System.out.println("DELETE OPERATION PERFOAMED AND ELEMENT IS: " + y );
		pred.next=target.next;
		
		}
		
		size--;
		System.out.println();
		
		 displayFrom();
		
	}


	public void displayFrom() {
		if (size == 0) {
			System.out.println("nothing to show");
		} else {
			NodeD target = head;
			while (target != null) {
				System.out.print(target.data + " ");
				target = target.next;
			}
			System.out.println("\n");
		}
	}

	public void displayFrom(int Loc) {
		if (size == 0||Loc == 0 || Loc > size) {
			System.out.println("undefined can't display");
		}
		 else {
			NodeD target = head;
			for (int i = 1; i <= size + 1; i++) {
				if (Loc == i) {
					while (target != null) {
						System.out.print(target.data + " ");
						target = target.next;
					}
					System.out.println("\n");
					break;
				}
				target = target.next;
			}
		}
	}
}