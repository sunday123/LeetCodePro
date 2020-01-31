package com.ij34.easy.有效的括号;

import java.util.Stack;

/*
 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。*/
public class Solution {
    public boolean isValid(String s) {
    	int len = s.length();
    	//个数是单数，就闭合不了
    	if(len%2==1) return false;
    	Stack<Character> stack = new Stack<Character>();
    	for(int i=0 ; i < len ; i++){
    		char ch = s.charAt(i);
    		if(ch=='(' || ch=='{' || ch=='['){
    			stack.add(ch);
    		}else{
    			//判断栈顶元素是否匹配
    			if(stack.isEmpty()) return false;
    				
    			char topC = stack.pop();
    			if( topC =='(') topC=')';
    			   else if(topC=='{') topC='}';
    			   else if(topC=='[') topC=']';
    			
    			if(topC!=ch) return false;
    		}
    		
    	}
    	if(stack.isEmpty())
		   return true;
    	else return false;
        
    }
    
    public static void main(String[] args) {
    	Solution s= new Solution();
    	System.out.println(s.isValid("{[]}"));
	}
    
}