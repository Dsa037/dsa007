package dsa_project_net;


public class Hash_table_separate_channing {

    public static void main(String[] args) {
//        hashtable h = new hashtable(13, "divisonhash", "Linearprobing");
//        hashtable h = new hashtable(13, "divisonhash", "quadraticprobing");
        
      hashtable h = new hashtable(5, "divisonhash", "Separate");

        h.display();
        h.insert(0, "Asghar", 500);
        h.insert(1, "Abbasi", 2033);
        h.insert(2, "kalhoro", 4543);

//		h.display();
        h.insert(3, "Ali", 4523);
        h.insert(4, "Hyder", 435);
        h.insert(5, "hamza", 345);
        h.insert(6, "Naveed", 325);
        h.insert(7, "owaix", 325);
        h.insert(8, "Sultan", 2435);
        h.insert(9, "Muhammad",535);

        h.deletesep(9);
        h.deletesep(8);
        h.deletesep(7);
        h.deletesep(6);
        h.deletesep(5);
        h.deletesep(4);
        h.deletesep(3);
        h.deletesep(2);
        h.deletesep(1);
        h.deletesep(0);
        h.deletesep(0);

        h.search(8);
        h.display();

    }
}

class Node {

    int id, index, salary;
    String name;
    public Node next;

    Node(int id, String name, int salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.next = null;
    }
}

class hashtable {

    public Node head;
    public Node[] arr;
    public int tablesize, size;
    public String hashfunc, collision_resolution;

    hashtable(int tablesize, String hashfunc, String coll) {
        System.out.println("hash table is created");
        this.tablesize = tablesize;
        this.size = 0;
        arr = new Node[tablesize];
        this.hashfunc = hashfunc;
        this.collision_resolution = coll;
        Node newNode = new Node(-1, null, 0);

        for (int i = 0; i < tablesize; i++) {
            this.arr[i] = newNode;
        }
    }

    public void delete(int key) {
        if ("divisonhash".equals(hashfunc)) {
            int hash1 = divisonhash(key);
            if (!isempty(hash1)) {
                Node newNode = new Node(-1, null, 0);
                System.out.println(arr[hash1].name + " deleted at " + hash1);
                this.arr[hash1] = newNode;
            }
//			 System.out.println("deleted "+arr[hash1].value);

        }
        display();
    }

    public int deletesep(int id) {
        Node newNode = new Node(-1, null, 0);
        int rtnindex = -1;
        if ("divisonhash".equals(hashfunc)) {
            int index_hash1 = divisonhash(id);  //  v % tablesize;
            if (!isempty(index_hash1) && arr[index_hash1].id == id) { // isempty returns true or false
                System.out.println(" 1st delete " + id + " " + arr[index_hash1].name);
                arr[index_hash1] = arr[index_hash1].next;

                if (arr[index_hash1] == null) {
//                                    Node newNode = new Node(-1, null);
                    arr[index_hash1] = newNode;
                }

                rtnindex = index_hash1;
            } else {
                if ("Separate".equals(collision_resolution)) {
                    boolean notdelete = seprate_chainingdelete(id, arr[index_hash1]);
                    if (notdelete) {
                    int hashlinear = linearprobing(index_hash1);
                    if (hashlinear == -1) {
                        System.out.println(id + " not exit to delete");
                        rtnindex = -5;
                    } else {
                        newNode.index = hashlinear;
                        this.arr[hashlinear] = newNode;
                        rtnindex = hashlinear;
                    }
                }
                }
                 if ("Linearprobing".equals(collision_resolution)) {
                    int hashlinear = linearprobing(index_hash1);
                    if (hashlinear == -1) {
                        System.out.println(id + " not exit to delete");
                        rtnindex = -5;
                    } else {
                        newNode.index = hashlinear;
                        this.arr[hashlinear] = newNode;
                        rtnindex = hashlinear;
                    }
                }
 
            }
            display();
        }
        return rtnindex;
    }

    public boolean seprate_chainingdelete(int targetid, Node dnode) { // finding node by data
        int add = 1;
        Node target = dnode;
        Node pred = null;
        try {
            while (target.id != targetid) {
                pred = target;
                target = target.next;
                add++;
            }
            System.out.println(" 1st delete saprate " + targetid + " " + target.id);
            pred.next = target.next;
 
            return false;
        } catch (Exception e) { // if value not found
            return true;
        }
    }

    public int insert(int id, String name, int salary) {
        Node newNode = new Node(id, name, salary);
        int rtnindex = -1;
        if ("divisonhash".equals(hashfunc)) {
            int index_hash1 = divisonhash(id);  //  v % tablesize;
            if (isempty(index_hash1)) { // isempty returns true or false

                 newNode.index = index_hash1;
                this.arr[index_hash1] = newNode;
                rtnindex = index_hash1;
            } else {
                if ("Separate".equals(collision_resolution)) {
                    seprate_chaining(index_hash1, newNode);
                }
                System.out.println(id + " collision with " + arr[index_hash1].name + " at " + index_hash1 + " for " + name + "linearprobing");
                if ("Linearprobing".equals(collision_resolution)) {
                    int hashlinear = linearprobing(index_hash1);
                    if (hashlinear == -1) {
                        System.out.println(name + " Can not insert Hash table is full");
                        rtnindex = -5;
                    } else {
                        newNode.index = hashlinear;
                        this.arr[hashlinear] = newNode;
                        rtnindex = hashlinear;
                    }
                }
                if ("Quadraticprobing".equals(collision_resolution)) {
                    int hashquadratic = quadraticprobing(index_hash1);
                    this.arr[hashquadratic] = newNode;
                    System.out.println("quadratic insertion");
                }
            }
            display();
        }
        return rtnindex;
    }

    public void seprate_chaining(int index_hash1, Node newNode) {
        Node target = arr[index_hash1];
        while (target.next != null) {
            target = target.next;
        }
        newNode.index = index_hash1;
        target.next = newNode; 			// insert at last
        System.out.println("inserted with seprate chainning");

    }

    public void display() {
        for (int i = 0; i < tablesize; i++) {
            if (arr[i] == null) {
                System.out.print(" -- ");
            } else {
//				System.out.print(" " + arr[i].value);
                System.out.print(i + " insde : ");
                Node target = arr[i];
                while (target != null) {
                    System.out.print(" --> " + target.name+" id: "+target.id+" sal: "+target.salary);
                    target = target.next;
                }
                System.out.println("");
            }
        }
        System.out.println();
    }

    public int search(int key) {
        int index_hash1 = divisonhash(key);
        if (key == arr[index_hash1].id) {
            System.out.println("found match at " + index_hash1);
            return index_hash1;
        } else if (isempty(index_hash1) || linearprobing(index_hash1) == -1) {
            System.out.println("not found");
            return -1;
        } else if (!isempty(index_hash1)) {
            System.out.println("occupied and no match");
//			return -0;
//			 linearprobing(index_hash1)-1;
            if (key == arr[linearprobing(index_hash1) - 1].id) {
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
            if (attempt > tablesize) {
                h1 = -1;
                break;
            } else {
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
        return arr[h1].id == -1; // returns true false
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
