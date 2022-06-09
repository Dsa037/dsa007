/**
 * 
 */
package hashtable_data;
public class hash_table_imp {
	public static void main(String[] args) {
// 				hashtable h = new hashtable(13,"divisonhash","linearprobing");
//		hashtable h = new hashtable(13, "divisonhash", "quadraticprobing");
 				hashtable h = new hashtable(13,"divisonhash","Seprate");

		h.display();
		h.insert(5,"Asghar");
		h.insert(5,"Abbasi");
		
		h.insert(5,"A");
		h.insert(5,"B");
		h.insert(5,"C");
		h.insert(5,"D");
		h.insert(5,"E");
		h.insert(5,"F");
		 


		h.delete(5);
		h.insert(26,"Ali");
		h.insert(17,"Hyder");
		h.insert(18,"hamza");
		h.insert(13,"Naveed");
		
 	 
		h.display();

		System.out.println(h.search(5));
	}
}

class Node{
	int key,index ;
	String value;
	public Node next;

	Node(int key, String value){
		this.key = key;
		this.value = value;
		this.next = null;
	}
}
class hashtable {
	public Node head;
	public Node[] arr;
	public int tablesize,size;
	public String hashfunc,collision_resolution;

	hashtable(int tablesize, String hashfunc, String coll) {
		System.out.println("hash table is created");
		this.tablesize = tablesize;
		this.size = 0;
		arr = new Node[tablesize];
		this.hashfunc = hashfunc;
		this.collision_resolution = coll;
		Node newNode = new Node(-1,null);
		for (int i = 0; i < tablesize; i++) {
			this.arr[i] = newNode;
 
		}
	}
	public void delete(int key) {
		 if (hashfunc == "divisonhash") {
			 int hash1 = divisonhash(key);
			 if (!isempty(hash1)) {
				 Node newNode = new Node(-1,null);
				 System.out.println(arr[hash1].value+" deleted at "+hash1);
					this.arr[hash1] = newNode;
				} 
		 }
 		 display();
	    } 
	public int insert(int x,String value) {
		Node newNode = new Node(x,value);
		int index = -1;
		if (hashfunc == "divisonhash") {
			int index_hash1 = divisonhash(x);  //  v % tablesize;
 			if (isempty(index_hash1)) { // is empty returns true or false
				Node head = arr[index_hash1];
				newNode.index=index_hash1;
				this.arr[index_hash1] = newNode;
				index = index_hash1;
			} else {
				if (collision_resolution == "Seprate") {
					seprate_chaining(index_hash1, newNode);
				}
				System.out.println(x+" collision with "+arr[index_hash1].value+" at "+index_hash1+" for "+value);
				if (collision_resolution == "linearprobing") {
					int hashlinear = linearprobing(index_hash1);
					if(hashlinear == -1) {
						System.out.println(value+" Can not insert Hash table is full");
					}
					else {
					newNode.index=hashlinear;
					this.arr[hashlinear] = newNode;
					index= hashlinear;
					}
					
				}
				if (collision_resolution == "quadraticprobing") {
					int hashquadratic = quadraticprobing(index_hash1);
					this.arr[hashquadratic] = newNode;
					System.out.println("quadratic insertion");
				}
			}
			display();
		}
		return index;
	}
	public void display() {
		for (int i = 0; i < tablesize; i++) {
			if (arr[i] == null) {
				System.out.print(" -- ");
			} else {
//				System.out.print(" " + arr[i].value);
				System.out.print(i +" insde : ");
				Node target = arr[i];
				while(target != null) {
					System.out.print(" --> "+target.value);
					target = target.next;
				}
				System.out.println("");
			}
		}
		System.out.println();
	}

	public int search(int key) {
		int index_hash1 = divisonhash(key);
		if( key ==  arr[index_hash1].key) {
			System.out.println("found match at "+ index_hash1);
			return index_hash1;
		}
		else if(isempty(index_hash1) || linearprobing(index_hash1) == -1) {
			System.out.println("not found");
			return -1;
		}
		else if(!isempty(index_hash1)) {
			System.out.println("occupied and no match");
//			return -0;
//			 linearprobing(index_hash1)-1;
			if( key == arr[linearprobing(index_hash1)-1].key) {
				System.out.println("found match in lineaer");
			}
			 linearprobing(index_hash1);
		}
		return -1;
	}
	public int linearprobing(int index_hash1) {
		int attempt = 1;
		int h1 = index_hash1;
		while (!isempty(h1)) {
			int fi = attempt;
			if(attempt > tablesize ) {
				h1 = -1;
				break;
			}
			else {
			h1 = (index_hash1 + fi) % tablesize;
			System.out.println("attempt " + h1);
			attempt++;
			}
		}
		return h1;
	}

	public int divisonhash(int v) {
		int mod = v % tablesize;
		return mod;
	}

	public boolean isempty(int h1) {
		if (arr[h1].key == -1) {
			return true;
		}
		return false;
	}

	public void seprate_chaining(int index_hash1, Node newNode) {
           Node target = arr[index_hash1]; 
 			while (target.next != null) {
				target = target.next;
			}
 			target.next =newNode; 			// insert at last
		System.out.println("seprate chain");
		
	}
	public int quadraticprobing(int index_hash1) {
		int attempt = 1;
		int h1 = index_hash1;
		while (!isempty(h1)) {
			int fi = attempt;
			h1 = (index_hash1 + fi * fi) % tablesize;
			System.out.println("h1 " + h1);
			attempt++;
		}
		return h1;
	}

	public int hash2(int key) {
		int r = 11;
		return (r - (key % r));
	}

	public int doublehashing(int index_hash1, int key) {
		int attempt = 1;
		int h1 = index_hash1;
		while (!isempty(h1)) {
			int fi = attempt * hash2(key);
			h1 = (index_hash1 + fi * fi) % tablesize;
			System.out.println("h1 " + h1);
			attempt++;
		}
		return h1;
	}

}