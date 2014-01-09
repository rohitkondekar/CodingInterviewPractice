package apress.coding.interview;

/**
 * Please implement a function to merge two sorted lists into a single sorted list. 
 * @author rohitkondekar
 *
 */

public class Question15_MergeSortedLists {
	
	class Node{
		int val;
		Node next=null;
		
		Node(int val){
			this.val = val;
		}
	}
	
	/**
	 * 
	 * h1/h2 are null
	 * 
	 */
	
	Node merge(Node h1,Node h2){
		
		Node head = null;
		
		if(h1==null && h2==null)
			return head;
		else if(h1==null)
			return h2;
		else if(h2==null)
			return h1;
		
		Node tmp=null;
		
		while(h1!=null && h2!=null){
			
			if(h1.val < h2.val){
				if(head==null){
					tmp=head=h1;
				}
				else{
					tmp = tmp.next = h1;
				}	
				h1=h1.next;
			}
			else{
				if(head==null){
					tmp=head=h2;
				}
				else{
					tmp = tmp.next = h2;
				}	
				h2=h2.next;
			}
		}
		
		if(h1!=null){
			tmp.next=h1;
		}
		else if(h2!=null){
			tmp.next=h2;
		}
		
		return head;
	}
	
	public static void main(String[] args)
	{
		Question15_MergeSortedLists Q = new Question15_MergeSortedLists();
		Node head1 = Q.new Node(3);
		Node t = head1.next = Q.new Node(5);
		t = t.next = Q.new Node(7);
		t = t.next = Q.new Node(10);
		
		Node head2 = Q.new Node(1);
		t = head2.next = Q.new Node(4);
		t = t.next = Q.new Node(6);
		t = t.next = Q.new Node(8);
		
		Node head = Q.merge(head1, head2);
		t=head;
		while(t!=null){
			System.out.print(t.val+" ");
			t=t.next;
		}
	}
	
	

}
