package linkedlist;

import java.security.GuardedObject;
import java.util.*;

class DoubleNode{
	Node<Integer> head;
	Node<Integer> tail;
	public DoubleNode() {
		
	}
	public DoubleNode(Node<Integer> head, Node<Integer>tail) {
		this.head = head;
		this.tail = tail;
	}
}

public class NodeUse {
	
	public static Node<Integer> createNode(){
		Node<Integer> arr = new Node<>(1);
		Node<Integer> arr2 = new Node<>(2);
		Node<Integer> arr3 = new Node<>(3);
		Node<Integer> arr4 = new Node<>(4);
		arr.next = arr2;
		arr2.next = arr3;
		arr3.next = arr4;
		return arr;
	}
	
	public static void printLL(Node<Integer> head) {
		while(head!=null) {
			System.out.println(head.data);
			head = head.next;
		}
	}
	public static void rPrintLL(Node<Integer> head) {
		if(head == null) {
			return;
		}
		System.out.print(head.data + " ");
		rPrintLL(head.next);
	}
	
	
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
	public static Node<Integer> insertR(Node<Integer> head, int index, int data){
		if(head==null && index>0) {
			return  null;
		}
		if(index==0) {
			Node<Integer> newdata = new Node<>(data);
			newdata.next = head;
			return newdata;
		}else {
			head.next = insertR(head.next, index-1, data);
			return head;
		}
		
	}
	
	public static Node<Integer> deleteR(Node<Integer> head, int pos){
		if(head==null) {
			return null;
		}
		if(pos==0) {
			return head.next;
		}
		head.next = deleteR(head.next, pos-1);
		return head;
	}
	
	public static Node<Integer> reverseR(Node<Integer>head){
		if(head==null || head.next == null) {
			return head;
		}
		Node<Integer> smallHead = reverseR(head.next);
		head.next.next = head;
		head.next = null;
		return smallHead;
	}
	public static DoubleNode reverseRBetter(Node<Integer> head) {
		if(head ==null || head.next==null) {
			DoubleNode ans = new DoubleNode(head, head);
			return ans;
		}
		DoubleNode smallHead = reverseRBetter(head.next);
		smallHead.tail.next = head;
		head.next = null;
		DoubleNode ans = new DoubleNode(smallHead.head, head);
		return ans;
	}
	

	public static void main(String[] args) {
		Node<Integer> arr = takeInput();
		Node<Integer> head = arr;
//		rPrintLL(head);
//		head = insertR(head, 5, 10);
//		head = deleteR(head, 4);
		DoubleNode ans = reverseRBetter(head);
		rPrintLL(ans.head);


	}

}
