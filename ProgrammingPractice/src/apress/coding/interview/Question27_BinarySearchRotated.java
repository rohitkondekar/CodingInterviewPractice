package apress.coding.interview;

/**
 * When some elements at the beginning of an array are moved to the end, it becomes a rotation of the original array. 
 * Please implement a function to get the minimum number in a rotation of an increasingly sorted array. 
 * For example, the array {3, 4, 5, 1, 2} is a rotation of array {1, 2, 3, 4, 5}, of which the minimum is 1.
 * @author rohitkondekar
 *
 */
public class Question27_BinarySearchRotated {
	
	/**
	 * Find Minimum
	 * - not rotated
	 * - singly rotated
	 * - just 2 elements rotated
	 * - corner mids
	 * 
	 * Keep excluding till end-start==1 && then answer is end
	 */
	
	int findMin(int[] arr){
		
		if(arr==null)
			return -1;
		else if(arr.length==1)
			return arr[0];
		
		int start=0, end=arr.length-1;
		int mid=0;
		
		while(arr[start]>arr[end]){
			if(end-start==1){
				mid=end;
				break;
			}
			
			mid=(end+start)/2;
			if(arr[mid]>arr[start])
				start=mid;
			else if(arr[mid]<arr[end])
				end=start;
		}
		
		return arr[mid];
	}
	
	public static void main(String[] args){
		
		int[] arr = {4,5,6,7,2,3};
		
		Question27_BinarySearchRotated Q = new Question27_BinarySearchRotated();
		System.out.println(Q.findMin(arr));
	}

}
