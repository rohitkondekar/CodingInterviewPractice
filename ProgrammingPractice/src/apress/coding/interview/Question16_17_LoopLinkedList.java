package apress.coding.interview;

/**
 * If there is a loop in a linked list, how do you get the entry node of the loop? 
 * The entry node is the first node in the loop from the head of a list. 
 * @author rohitkondekar
 *
 */


public class Question16_17_LoopLinkedList {

	class Node{
		int val;
		Node next=null;
		
		Node(int val){
			this.val = val;
		}
	}
	
	/**
	 * 1 node loop 
	 * 2 nodes - total loop
	 * 3 nodes - total loop
	 * no loop
	 */
	
	public Node isLoop(Node head){
		
		if(head==null)
			return null;
		else if(head.next==head)
			return head;
		
		Node tmp1=head,tmp2=head;
		
		do{
			tmp1=tmp1.next;
			tmp2=tmp2.next;
			if(tmp2!=null)
				tmp2=tmp2.next;
		}while(tmp1!=tmp2 && tmp2!=null && tmp1!=null);
		
		if(tmp1==tmp2 && tmp1!=null){
			tmp1=head;
			
			while(tmp1!=tmp2){
				tmp1=tmp1.next;
				tmp2=tmp2.next;
			}
			return tmp1;
		}
		
		return null;
		
		
	}
	public static void main(String[] args) {
		
		Question16_17_LoopLinkedList Q = new Question16_17_LoopLinkedList();
		Node head = Q.new Node(1);
		Node t = head.next = Q.new Node(2);
		t = t.next = Q.new Node(3);
		t = t.next = Q.new Node(4);
		t = t.next = Q.new Node(5);
		Node t1 = t = t.next = Q.new Node(6);
		t.next=t1;
		
		Node head1 = Q.isLoop(head);
		System.out.println(head1.val);

	}

}
