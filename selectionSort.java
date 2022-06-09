package sotring;

public class selectionSort {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int array[] = {4,2,1,7,6,3,5,9,8};
		
		for(int i=0 ;i < array.length-1;i++) {
			int index = i;
			for(int j = i+1 ;j < array.length; j++) {
				if(array[j] < array[index]) {
					index = j;
				}
			}
			int smaller = array[index];
	        System.out.println("smallest "+ smaller);
			
			array[index] = array[i];
			array[i] = smaller;
		}
	
	for(int k = 0 ;k< array.length;k++) {
		System.out.print(" "+array[k]);
	}

	}
}
