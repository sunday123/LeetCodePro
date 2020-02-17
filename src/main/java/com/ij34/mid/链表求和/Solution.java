package com.ij34.mid.链表求和;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	if(l1 == null) return l2;
    	else if(l2 == null) return l1;
    	Queue<ListNode> stack1 = getNodeList(l1); //长度长
    	Queue<ListNode> stack2 = getNodeList(l2);
        if(stack1.size() < stack2.size()){
        	Queue<ListNode> temp = stack1;
        	stack1 = stack2;
        	stack2 =temp;
        }
        Queue<ListNode> result =new LinkedList<ListNode>();
        int forward = 0;//进位
        while(!stack1.isEmpty()){
        	ListNode s1 = stack1.poll();
        	ListNode s2 = null;
        	if(!stack2.isEmpty()){
        		s2 = stack2.poll();
        	}
        	int value = s1.val + forward;
        	if(s2 !=null){
        		value += s2.val;
        	}
        	forward = value/10;
        	result.add(new ListNode(value%10));
        	
        }
        if(forward > 0){
        	result.add(new ListNode(forward));
        }
        if(result.size() == 1) return result.peek();
        else{
            ListNode head,p = result.poll();
            p.next = result.poll();
            head = p;
            p = p.next;
            while(!result.isEmpty()){
            	p.next = result.poll();
            	p = p.next;
            }
            return head;
        }

        
        
        
    }
    
    /**链表转栈*/
    private Queue<ListNode> getNodeList(ListNode node){
    	if(node == null ) return null;
    	Queue<ListNode> stack = new LinkedList<ListNode>();
    	while(node.next !=null){
    		stack.offer(node);
    		node = node.next;
    	}
    	stack.offer(node);
    	
		return stack;
    	
    }
    
    
    public static void main(String[] args) {

    	 
	     ListNode l1 =new ListNode(7);
	     l1.next =new ListNode(1);
	     l1.next.next=new ListNode(6);
	     ListNode l2 =new ListNode(5);
	     l2.next =new ListNode(9);
	     l2.next.next=new ListNode(2);
	     Solution s =new Solution();
	     ListNode list = s.addTwoNumbers(l1,l2);
	     if(list ==null) System.out.println("空");
	     else {
	    	 while(list.next!=null){
	    		 System.out.print(list.val+" ");
	    		 list = list.next;
	    	 }
	    	 System.out.print(list.val);
	     }
	}
}