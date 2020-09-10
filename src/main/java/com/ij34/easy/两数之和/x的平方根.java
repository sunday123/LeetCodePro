package com.ij34.easy.两数之和;

public class x的平方根 {
    public int mySqrt(int x) {
    	int l=1,h=x;
    	while(l<=h){
    		int mid=l+(h-l)/2;
    		int sqrt = x/mid;
    		if(sqrt ==mid) {
    			return sqrt;
    		}else if(sqrt<mid){
    			h=mid-1;
    		}else{
    			l=mid+1;
    		}
    	}
		return h;
    }
}
