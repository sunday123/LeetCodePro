package com.ij34.easy.两数相加;

import java.util.LinkedList;
/*给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

示例：

输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
输出：7 -> 0 -> 8
原因：342 + 465 = 807

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/add-two-numbers
*/
class Solution {
	
	public static void main(String[] args) {
		ListNode ha,hb;
		ListNode a=new ListNode(2);
		ha=a;
		a.next=new ListNode(4);
		a=a.next;
		ha.next=a;
		a.next=new ListNode(3);
		a=a.next;
		ha.next.next=a;
		
		ListNode b=new ListNode(5);
		hb=b;
		b.next=new ListNode(6);
		b=b.next;
		hb.next=b;
		b.next=new ListNode(4);
		b=b.next;
		hb.next.next=b;
		new Solution().addTwoNumbers(ha, hb);

	}
	
	
	
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	String s1=getStringByNum(l1);//243
    	String s2=getStringByNum(l2);//564
    	
    	if(s1.length()<s2.length()){
    		String tmp=s1;
    		s1=s2;
    		s2=tmp;
    	}
    	LinkedList<Integer> list=new LinkedList<Integer>();
    	
    	int lastVar=0; //进位
    	int len2=s2.length();
    	
    	for(int i=0;i<s1.length();i++){
    		int a=s1.charAt(i)-'0';
    		if(i<len2){
    			int b=s2.charAt(i)-'0';
    			int sum=a+b+lastVar;
    			list.add(sum%10);
    			lastVar=sum/10;
    			
    			
    		}else{
    			int sum=a+lastVar;
    			list.add(sum%10);
    			lastVar=sum/10;
    		}
    	}
    	
		if(lastVar>0){
			list.add(lastVar);
		}
    	

    	ListNode result=new ListNode(list.get(0));
        ListNode p=new ListNode(0);  //辅助get头结点,为next节点
        p.next=result;
       for(int i=1;i<list.size();i++){
        		result.next=new ListNode(list.get(i));
        		result=result.next;
        	}

    		printListNode(p.next);
        
    	
		
		return p.next;
        
    }
    
    
   //遍历获得该链表的所有节点的值,不用int long因为长度不确定
    public String getStringByNum(ListNode node){
    	StringBuilder result =new StringBuilder();
    	while(node.next!=null){
    		result.append(node.val);
    		System.out.print(node.val);
    		node=node.next;
    	}
    	result.append(node.val);
    	
    	
		return result.toString();
    	
    }
    
    
    //遍历获得该链表的所有节点的值,逆序保存
    public void printListNode(ListNode node){
    	StringBuilder result =new StringBuilder();
    	result.append("链表：");
    	while(node.next!=null){
    		result.append(node.val+"->");
    		node=node.next;
    	}
    	result.append(node.val);
    	
    	
		System.out.println(result.toString());
    	
    }
}