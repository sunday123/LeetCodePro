package com.test.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**二分查找*/
public class 二分法 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
/*         int[] a={1,2,3,4,5,6,7,8,9};
         int key=5;
         
         int result = searchMid(key, a);
         System.out.println(result);*/
         
		
		System.out.println(partitionLabels("aaa"));
	}
	
	
/*	
	输入: S = "ababcbacadefegdehijhklij"
	输出: [9,7,8]
             划分结果为 "ababcbaca", "defegde", "hijhklij"。

	*/
    public static List<Integer> partitionLabels(String S) {
         int startIndex=0;
         int endIndex=S.lastIndexOf(S.charAt(startIndex));
         List<Integer> result =new ArrayList<Integer>();
         while(endIndex<=(S.length()-1)){
        	 
             for(int i=startIndex+1;i<endIndex;i++){
            	 int tmpIndex=S.lastIndexOf(S.charAt(i));
            	 if(tmpIndex>endIndex){
            		 endIndex=tmpIndex;
            	 }
             }
             result.add(endIndex-startIndex+1);
             if(endIndex+1>=S.length()){
            	 break;
             }
             startIndex=endIndex+1;
             endIndex=S.lastIndexOf(S.charAt(startIndex));
             
         }

         return result;
    }
	
	
	
	
	
	
	
	
	
	
/*	
	字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
*/
    public boolean isSubsequence(String s, String t) {
       int i=0,j=0,sl=s.length(),tl=t.length();
       while(i<sl&&j<tl){
    	   if(s.charAt(i)==t.charAt(j)){
    		   i++;
    	   }
    	   j++;
       }
    	   
      return i==sl;  
    	   
    }
	
    
    
    
    
    
    
    
    
    
	
/**	输入: nums = [4,2,3]
	输出: true
	解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
*/
    public boolean checkPossibility(int[] nums) {
    	int count=0;
    	for(int i=1;i<nums.length;i++){
    		if(nums[i-1]>nums[i]){
    			count++;
    			if(i-2>=0&&nums[i-2]>nums[i]){
    				 nums[i]=nums[i-1];
    			}
    			else{
    				nums[i-1]=nums[i];
    			}
    			
    		}
    	}
    	
        return count<=1;
    }
	
	
/**	输入: flowerbed = [1,0,0,0,1], n = 1
	输出: True
*/
    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
    	for(int i=0;i<flowerbed.length;i++){
    		if(flowerbed[i]==1) continue;
    		int pre=i>0?flowerbed[i-1]:0;
    		int next=(i+1)<flowerbed.length?flowerbed[i+1]:0;
    		if(pre==0&&next==0){
    			n--;
    			if(n<=0) return true;
    			flowerbed[i]=1;
    			
    		}
    	}
        return n<=0?true:false;
    }
	
	
	//二分法找中位数
	public static int searchMid(int key,int [] a){
		int l=0,h=a.length-1;
		int c=0;
		//<=号，因为集合一个数，时候。
		while(l<=h){
			int mid =l+(h-l)/2;
			if(key == a[mid]) {
				System.out.println("c1:"+(++c));
				return mid;
			}else if(key <a[mid]){
				System.out.println("c2:"+(++c));
				h=mid-1;
			}else{
				System.out.println("c3:"+(++c));
				l=mid+1;
			}
	
		}
		
		
		return -1;
	}
	
    public static int mySqrt(int x) {
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
    
   // 排列硬币
    public static int arrangeCoins(int n) {
    	int c=1;
    	while(n>=c){
    		n-=c;
    		c++;
    	}
    
    	return c-1;

    }
	
    public int singleNonDuplicate(int[] nums) {
        for(int i=0;i<nums.length-1;i+=2){
            if(nums[i]!=nums[i+1]){
                return nums[i];
            }
        }
		return 0;

    }
    
    
    
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int gi=0,si=0;
        while(gi<g.length&&si<s.length){
        	if(g[gi]<=s[si]){//满足
        		gi++;
        		si++;
        	}else{
        		si++;
        	}
        }
        return gi;
    }
    
    
    
    public int findMinArrowShots(int[][] points) {
    	if(points.length<1) return 0;
        Arrays.sort(points, (a,b) ->(a[1]-b[1]));
        int count=1;
        int temp=points[0][1];
        for(int i=1;i<points.length;i++){
        	if(temp>=points[i][0]){
        		continue;
        	}
        	
        	temp=points[i][1];
        	count++;
        }
         return count;
        
    }
    

}
