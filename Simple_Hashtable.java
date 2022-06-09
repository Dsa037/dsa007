
public class Simple_Hashtable {
	public static void main(String[] args) {
		hashtable_simp h = new hashtable_simp(10,"divisonhash","linearprobing");
//		hashtable h = new hashtable(13, "divisonhash", "quadraticprobing");
		
//		hashtable_simp h = new hashtable_simp(10,"midsquare","linearprobing");

		h.display();
		h.insert(26);
		h.insert(13);
		
		h.search(26);
		h.search(50);
		h.search(13);

//		h.display();
//		h.searchme(5);
		
//		System.out.println(h.search(5));
	}
}

class hashtable_simp {
	public int[] arr;
	public int tablesize;
	public String hashfunc;
	public String collision_resolution;

	hashtable_simp(int tablesize, String hashfunc, String coll) {
		System.out.println("hash table is created");
		this.tablesize = tablesize;
		arr = new int[tablesize];
		this.hashfunc = hashfunc;
		this.collision_resolution = coll;
		for (int i = 0; i < tablesize; i++) {
			this.arr[i] = -1;
		}

	}

	public void display() {
		for (int i = 0; i < tablesize; i++) {
			if (arr[i] == -1) {
				System.out.print(" -- ");
			} else {
				System.out.print(" " + arr[i]);
			}
		}
		System.out.println();
	}
	 public void delete(int key) {
		 if (hashfunc == "divisonhash") {
			 int hash1 = divisonhash(key);
			 if (!isempty(hash1)) {
					this.arr[hash1] = -5;
				} 
		 }
	    }
	
	 public void insert(int x) { 
		int hash1 = -1;
		if (hashfunc == "divisonhash") {
			 hash1 = divisonhash(x); 
			 } //  v % tablesize;
		else if(hashfunc == "midsquare") {
			 hash1 =  mid_square(x); 
			 } //  v % tablesize;
		else {
			hash1 = -1;
		}
//			System.out.println(isempty(hash1));
			if (isempty(hash1) && hash1 != -1 ) {
				this.arr[hash1] = x;
			} 
			
			else {
				System.out.println(x+" collision with "+arr[hash1]+" at "+hash1);
				if (collision_resolution == "linearprobing") {
					int hashlinear = linearprobing(hash1);
					this.arr[hashlinear] = x;
				}
				if (collision_resolution == "quadraticprobing") {
					int hashquadratic = quadraticprobing(hash1);
					this.arr[hashquadratic] = x;
					System.out.println("quadratic insertion");
				}
			}
			display();		
	}

	 public int search(int target) {
		 int hash = -1;
		 if(hashfunc == "divisonhash") {
 			 hash = divisonhash(target);}
		 else if(hashfunc == "mid_square") {
	 			 hash = mid_square(target);}
		 else {
			  hash = -1;
		 }
		 //System.out.println(hash);
		//System.out.println(arr[hash]);
		if(isempty(hash)) {
			System.out.println("Not Found");
		}
		 else if (this.arr[hash] == target) {
					System.out.println("Found at " + hash);
					return hash;
				}
		 else {
			 System.out.println("collision");
				if(collision_resolution =="linearprobing") {
					int attempt = 1;
					 int h1 = hash;
					 while(!isempty(h1)) {
						 int fi = attempt;
						 h1 = (hash + fi)%tablesize;
						 System.out.println("h1 "+h1);
						 attempt++;
					 }
				} 
		 }
				System.out.println("Not Found ");
				return -1;
	 }
 
	
	public int linearprobing(int hash1) {
		int attempt = 1;
		int h1 = hash1;
		while (!isempty(h1)) {
			int fi = attempt;
			h1 = (hash1 + fi) % tablesize;
			System.out.println("attempt " + h1);
			attempt++;
		}
		return h1;
	}

	public int divisonhash(int v) {
		int mod = v % tablesize;
		return mod;
	}
	
	public int mid_square(int v) {
		int mod = (v*v)% tablesize;
		return mod;
	}

	public boolean isempty(int h1) {
		if (arr[h1] == -1) {
			return true;
		}
		return false;
	}

	public int quadraticprobing(int hash1) {
		int attempt = 1;
		int h1 = hash1;
		while (!isempty(h1)) {
			int fi = attempt;
			h1 = (hash1 + fi * fi) % tablesize;
			System.out.println("h1 " + h1);
			attempt++;
		}
		return h1;
	}

	public int hash2(int key) {
		int r = 11;
		return (r - (key % r));
	}

	public int doublehashing(int hash1, int key) {
		int attempt = 1;
		int h1 = hash1;
		while (!isempty(h1)) {
			int fi = attempt * hash2(key);
			h1 = (hash1 + fi * fi) % tablesize;
			System.out.println("h1 " + h1);
			attempt++;
		}
		return h1;
	}

}