
public class recursiveLinear {
	public static void main(String[] args) {
		int array[] = { 11, 12, 13, 14, 15, 16, 17, 18, 19 };
		int find = 18;
//		System.out.println(RecusiveSearch(array, find, 0,array.length-1));
		
		for(int i= 0; i <array.length;i++) {
			
			if(array[i]==find) {
				System.out.println(i);
			}
			else {
				System.out.println("not found");
			}
		}	
	}
	
	static int RecusiveSearch(int arr[], int n, int i,int len) {

		if ( len <i ) {		
			return -1;
		}
		
		if (arr[i] == n) {
			System.out.println(i);
			return i;
		} 
			return RecusiveSearch(arr, n, i+1,len);
	}

}
