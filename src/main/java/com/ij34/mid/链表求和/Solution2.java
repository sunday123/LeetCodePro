package com.ij34.mid.链表求和;

public class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	else if(l2 == null) return l1;
    	else{
    		int forward =0;
    		ListNode head = null,p = null;
    		boolean first =true;
    		while(l1 !=null || l2 !=null){
    			if(l1!=null) {
    				forward +=l1.val;
    				l1=l1.next;
    			}
    			if(l2!=null) {
    				forward +=l2.val;
    				l2=l2.next;
    			}
                if(first){
        			p= new ListNode(forward%10);
        			forward/=10;
        			head=p;
        			first=false;
                }else{
        			p.next= new ListNode(forward%10);
        			forward/=10;
        			p=p.next;
                }
    			
    		}
    		if(forward>0) p.next=new ListNode(forward);
    		return head;
    	}
    } 
    
    
    public static void main(String[] args) {

   	 
	     ListNode l1 =new ListNode(7);
	     l1.next =new ListNode(1);
	     l1.next.next=new ListNode(6);
	     ListNode l2 =new ListNode(5);
	     l2.next =new ListNode(9);
	     l2.next.next=new ListNode(2);
	     Solution2 s =new Solution2();
	     ListNode list = s.addTwoNumbers(l1,l2);
	     if(list ==null) System.out.println("空");
	     else {
	    	 System.out.println("结果");
	    	 while(list.next!=null){
	    		 System.out.print(list.val+" ");
	    		 list = list.next;
	    	 }
	    	 System.out.print(list.val);
	     }
	}
}
