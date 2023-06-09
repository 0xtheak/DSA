package linkedList;

import java.util.Scanner;

public class MergeShortLL {
	
	public static Node<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		int data = s.nextInt();
		Node<Integer> head =null,temp=null;
		while(data!=-1) {
			Node<Integer> child = new Node(data);
			if(head==null) {
				head = child;
				temp = head;
			}else {
				temp.next = child;
				temp = child;
			}
			data = s.nextInt();
			
		}
		return head;
	}
	public static void printR(Node<Integer> head) {
		if(head==null) {
			return;
		}
		System.out.print(head.data + " ");
		printR(head.next);
	}
	public static Node<Integer> midFind(Node<Integer> head){
		if(head == null) {
			return head;
		}
		Node<Integer> slow = head, fast = head;
		while(fast.next!=null && fast.next.next!=null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;
	}
	public static Node<Integer> mergeLL(Node<Integer>head1, Node<Integer> head2){
		if(head1==null) {
			return head2;
		}
		if(head2==null) {
			return head1;
		}
		Node<Integer>head=null, tail=null;
		while(head1!=null && head2!=null) {
			if(head1.data<=head2.data) {
				Node<Integer> child = new Node<>(head1.data);
				if(head==null) {
					head=child;
					tail=child;
				}else {
					tail.next = child;
					tail = child;
				}
				head1 = head1.next;
			}else {
				Node<Integer> child = new Node<>(head2.data);
				if(head==null) {
					head=child;
					tail=child;
				}else {
					tail.next = child;
					tail = child;
				}
				head2 = head2.next;
				
			}
		}
		
		if(head1!=null) {
			tail.next = head1;
		}
		if(head2!=null) {
			tail.next = head2;
		}
		return head;
	}
	
	public static Node<Integer> mergeSort(Node<Integer> head){
		if(head==null || head.next==null) {
			return head;
		}
		Node<Integer> midNode = midFind(head);
		Node<Integer>h2 = midNode.next;
		midNode.next = null;
		Node<Integer> p1 = mergeSort(head);
		Node<Integer> p2 = mergeSort(h2);
		Node<Integer> mergedList = mergeLL(p1, p2);
		return mergedList;
	}

	public static void main(String[] args) {
		Node<Integer> head = takeInput();
		head = mergeSort(head);
		printR(head);

	}

}
