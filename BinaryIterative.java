
public class BinaryIterative {
	public static void main(String[] args) {
		int arrays[] = { 11, 12, 13, 14, 15, 16, 17, 18, 19 };
		int num =  18;
		int l = arrays.length;
		
 		int s = 0, e = l - 1;
 		
		for (int i = 0; i < l; i++) {
			
			int mid = s + (e - s) / 2;
			
			System.out.printf("\nmid "+mid+" end "+e+" s "+s+" e - s "+(e - s));

 			if (num == arrays[mid]) {
				System.out.println(num+" founded at index :" + mid);
				break;
			}
			if (num > arrays[mid]) {
				s += 1;
			}
			if (num < arrays[mid]) {
				e -= 1;
			} 
			else if (e < s) {
				System.out.println("not found");
			}
		}
	}
}
