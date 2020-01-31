package com.ij34.mid.无重复字符的最长子串;

import java.util.ArrayList;
import java.util.List;

//给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。

public class Solution {
	
	
	
    public int lengthOfLongestSubstring(String s) {
    	int maxLen=1;
    	if(s.length()<1) return 0;
    	else if(s.length()==1) return 1;
    	
    	for(int i=0;i<s.length()-1;i++){//从第一个开始
    		List<Character> list=new ArrayList<Character>();
    		list.add(s.charAt(i));
    		//i开始的 n个不重复的子序列
    		for(int j=i+1;j<s.length();j++){
    			if(list.contains(s.charAt(j))){
    				break;
    			}else{
    				list.add(s.charAt(j));
    			}
    		}
    		
    		maxLen=maxLen>list.size()?maxLen:list.size();
    		
    	}
		return maxLen;
        
    }
    
    public static void main(String[] args) {
		Solution s=new Solution();
		System.out.println(s.lengthOfLongestSubstring("pwwkew"));
	}
    
}