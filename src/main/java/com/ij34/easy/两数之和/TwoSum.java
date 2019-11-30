package com.ij34.easy.两数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//计算两数的和
public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	
    public int[] twoSum(int[] nums, int target) {
    	int len=nums.length;
    	int[] result = new int[2];
        for(int i=0;i<len-1;i++){
        	int a=target-nums[i];
        	for(int j=i+1;j<len;j++){
        		if(a==nums[j]){
        			result[0]=i;
        			result[1]=j;
        			return result;
        		}
        	}
        }
		return null;
        
    }

}
