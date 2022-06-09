
public class stack {
    public static void main(String[] args) {
    	Stack_code s = new Stack_code(5);
    	s.push(1);
    	s.push(2);
    	s.push(3);
    		s.pop();
//    		s.pop();
    }
}

class Stack_code {
    public int top;
    public int size;
    public int[] arr;

    Stack_code(int size) {
        this.size = size;
        top = -1;
        this.arr = new int[size];
//        System.out.println("stack array is created");
                System.out.println("stack array is created with size "+size);

    }
    public boolean push(int num) {
        if (top == size - 1) {
            System.out.println("stack is full");
            return true;
        } else {
            top++;
            this.arr[top] = num;
        }
        display();
        return false;
    }

    public boolean pop() {
        if (top == -1) {
            System.out.println("stack is empty");
            return true;
        } else {
            int temp = arr[top];
            this.top--;
            System.out.println(temp + " has been popped");
//            display();
        }
        return false;
    }

    public String peek() {
		if(top== -1) {
			String a=("Null");
                        return a;
		}
		else {
			String b=arr[top]+"";
                        return b;
		}
		
	}
    public void display() {
        if (top == -1) {
            System.out.println("array is empty");
        } else {
            for (int i = 0; i <= top; i++) {
                System.out.print(" " + arr[i]);
            }
            System.out.println();
        }
    }
    
     public int getlen() {
           return top;  // top is giving last index
    }

}
