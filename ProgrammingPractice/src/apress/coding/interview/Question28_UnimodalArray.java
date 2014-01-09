package apress.coding.interview;

/**
 * A turning number is the maximum number in a unimodal array that increases and then decreases. 
 * Please write a function (or a method) that finds the index of the turning number in a unimodal array. 
 * For example, the turning number in the array {1, 2, 3, 4, 5, 10, 9, 8, 7, 6} is 10, so its index 5 is the expected output.
 * @author rohitkondekar
 *
 */

public class Question28_UnimodalArray {
	
	int getModel(int[] arr){
		
		if(arr==null || arr.length<2)
			return -1;
		
		int start=0, end=arr.length-1;
		int mid=(start+end)/2;
		
		while(start<end){
			mid=(start+end)/2;
			
			if(arr[mid]>arr[mid-1] && arr[mid]>arr[mid+1])
				return arr[mid];
			else if(arr[mid]>arr[mid-1])
				start=mid;
			else
				end=mid;
		}
		
		return -1;
		
	}

	public static void main(String[] args){
		Question28_UnimodalArray Q = new Question28_UnimodalArray();
		
		int[] arr = {1, 2, 3, 4, 5, 10, 9, 8, 7, 6};
		System.out.println(Q.getModel(arr));
	}
}
