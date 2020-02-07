package com.ij34.常见排序;

public class 快速排序 {
  
	public static void quickSort(int[] a, int start,int end){
		if(start<end){
			//选基数
			int base = a[start];
			int i=start,j=end;
			do{
				while(a[i]<base&&i<end) i++;
				while(a[j]>base&&j>start)j--;
				
				if(i<=j){
					int temp=a[i];
					a[i]=a[j];
					a[j]=temp;
					
					i++;
					j--;
				}
			}while(i<=j);
			System.out.println(start+"-"+j+"|"+i+"-"+end);
			if(start<j)quickSort(a, start, j);
			if(i<end) quickSort(a, i, end);
			
		}
		
	}
	
	
	   public static void main(String[] args) {
			 int[] a=new int[]{32,43,23,13,5};
			 quickSort(a,0,a.length-1);
			 for(int a1 :a)
			 System.out.print(a1+"|");
	}
}
