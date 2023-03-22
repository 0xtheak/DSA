package linkedList;

public class Lpalindrom {

	public static ListNode reverse(ListNode head){
        ListNode prev = null;
        ListNode pnext=head.next;
        while(head!=null){
            head.next = prev;
            prev = head;
            head = pnext;
            if(pnext!=null) {
            	pnext = pnext.next;
            }
            
        }
        return prev;
        
    }
    
    public static int lPalin(ListNode A) {
        int count = 0;
        ListNode head = A;
        ListNode slow = A;
        ListNode fast = A;
        while(fast!=null && fast.next!=null){
            slow = slow.next;
            fast = fast.next.next;
            count++;
        }
        
        slow = reverse(slow);
        
        while(slow!=null && count>0){
            System.out.print(slow.val);
            if(head.val!=A.val) {
            	return 0;
            }
            slow = slow.next;
            head = head.next;
            count--;
        }
        
        return 1;
    }
	
	public static void main(String[] args) {
		ListNode head = new ListNode(4);
		ListNode l2 = new ListNode(5);
		head.next = l2;
		ListNode l3 = new ListNode(4);
		l2.next = l3;
		lPalin(head);

	}

}
