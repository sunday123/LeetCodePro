package com.ij34.常见排序;

import java.util.Arrays;

public class 堆排序 {
	public static void heapSort(int[] a){
	   int len=a.length;
	   for(int i=0;i<len-1;i++){
		   //建堆
		   buildHeap(a,len-i-1);
		   //交换堆顶和最后一个的元素
		   swap(a, 0, len-i-1);
		   System.out.println(Arrays.toString(a));
	   }
		
	 }
	//0-index建立大顶堆
	private static void buildHeap(int[] a, int index) {
		// 最后节点的父节点开始
		for(int i=(index-1)/2;i>=0;i--){
			int k=i;
			//左子节点存在
			while(2*k+i<=index){
				int biggerIndex=2*k+1;
				//右子节点存在
				if(biggerIndex<index){
					if(a[biggerIndex]<a[biggerIndex+1]){
						biggerIndex++;
					}
				}
				
				//k节点值小于最大值，交换
				if(a[k]<a[biggerIndex]){
					swap(a, k, biggerIndex);
					k=biggerIndex;
				}else{
					break;
				}
				
			}
		}
	}

	public static void swap(int[] a,int i,int j){
		int temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	   
	   public static void main(String[] args) {
			 int[] a=new int[]{32,43,23,13,5};
			 heapSort(a);
			 for(int a1 :a)
			 System.out.print(a1+"|");
	}
}
