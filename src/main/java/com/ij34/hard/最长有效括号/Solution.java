package com.ij34.hard.最长有效括号;

import java.util.Stack;


/*给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度
*/
public class Solution {
    public int longestValidParentheses(String s) {
    	int max = 0;
    	Stack<Integer> stack = new Stack<Integer>();
    	stack.add(-1);
    	for(int i=0;i<s.length();i++ ){
    		char ch = s.charAt(i);
    		if(ch == '(') {
    			stack.add(i);
    		}else{
    			
    		    stack.pop();
    		    if(stack.isEmpty()) stack.add(i);

    			max = Math.max(max, i-stack.peek());
    		}
    	}
    			
		return max;
        
    }
    
    public static void main(String[] args) {
		Solution s= new Solution();
		System.out.println(s.longestValidParentheses(")()())"));
	}
}