package apress.coding.interview;


/**
 * Please implement a function to sort a given list.
 */
public class Question14_sortLinkedList {

	/**
	 * Insertion sort
	 * 3 pointers needed
	 * change in head once head changes
	 * Cases:
	 * - single node
	 * - 2 nodes
	 * - 3 nodes
	 * 
	 */
	
	class Node{
		int val;
		Node next=null;
		
		Node(int val){
			this.val = val;
		}
	}
	
	Node sortLinkedList(Node head){
		
		if(head==null)
			return head;
		else if(head.next==null)
			return head;
		else if(head.next.next==null)
		{
			if(head.val>head.next.val){
				head.next.next=head;
				head.next=null;
				return head;
			}
			else
				return head;
		}
		
		Node t1=head,t2=head.next,t3=head.next.next;
		Node tmp1,tmp2;
		
		while(t2!=null){
			tmp1 = null;
			tmp2 = head;
			while(tmp2.val<t2.val && tmp2.next!=t2){
				tmp1=tmp2;
				tmp2 = tmp2.next;
			}
			
			if(tmp2.next!=t2 || tmp2.val>t2.val){
				t1.next=t2.next;
				if(tmp2==head){
					t2.next=head;
					head=t2;
				}
				else{
					tmp1.next=t2;
					t2.next=tmp2;
				}
				t2=t1.next;
			}
			else{
				t2=t2.next;
				t1=t1.next;
			}
		}
		return head;
	}
	
	public static void main(String[] args)
	{
		Question14_sortLinkedList Q = new Question14_sortLinkedList();
		Node head = Q.new Node(7);
		Node t = head.next = Q.new Node(8);
		t = t.next = Q.new Node(4);
		t= t.next = Q.new Node(3);
		t= t.next = Q.new Node(5);
		t= t.next = Q.new Node(1);
		t=head;
		while(t!=null){
			System.out.print(t.val+" ");
			t=t.next;
		}
		System.out.println();
		head=Q.sortLinkedList(head);
		t=head;
		while(t!=null){
			System.out.print(t.val+" ");
			t=t.next;
		}
	}
}
