

public class QueueCode {

	public static void main(String[] args) {
		Queue queue = new Queue(10);

		queue.enqueue(16);
		queue.enqueue(76);
		queue.enqueue(96);
		queue.enqueue(16);
		queue.enqueue(26);
		queue.enqueue(36);
		queue.enqueue(89);
		queue.enqueue(26);
		queue.enqueue(26);
		queue.enqueue(26);
		queue.enqueue(26);
		queue.enqueue(26);
		queue.enqueue(26);
		queue.enqueue(26);

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

		queue.dequeue();

		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();
		queue.dequeue();

	}

}

class Queue {
	static int front;
	static int back;
	static int size;
	static int arr[];
	static int currentsize;

	Queue(int size) {
		this.size = size;
		front = -1;
		back = -1;
		currentsize = 0;
		arr = new int[size];
		System.out.println("empty Queue size of " + size + "has been created");

	}

	public static void enqueue(int value) {
		if (currentsize == size) {
			System.out.println("Queue is full");
		}
		else if (back == size - 1) {
			System.out.println("insertion is not possiable");
		}
		else if (currentsize != 0 && currentsize < size) {
			back++;
			currentsize++;
			arr[back] = value;
			System.out.println(value + " Number is inserted size " + currentsize);
			display();
		}
		else if (currentsize == 0) {
			front = 0;
			back = 0;
			currentsize++;
			arr[back] = value;
			System.out.println(value + " Number is inserted size " + currentsize);
			display();
		}
	}

	public void dequeue() {
		if (currentsize == 0) {
			System.out.println("empty queue");
			front = -1;
			back = -1;
		} else if (front == back) {
			System.out.println("queue is empty ");
			front = -1;
			back = -1;
			currentsize = 0;

		} else {
			int temp = arr[front];
			front++;
			currentsize--;
			System.out.println(temp + " deleted Successfully " + currentsize);
		}
		display();
	}

	public static void display() {
		if (currentsize == 0) {
			System.out.println("Queue is empty");
		} else {
			for (int i = front; i <= back; i++) {
				System.out.print(arr[i] + ",");
			}
			System.out.println("");
		}
	}
}