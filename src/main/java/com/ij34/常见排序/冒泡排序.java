package com.ij34.常见排序;

import java.util.Arrays;

public class 冒泡排序 {
	
	public static void bubbleSort(int[] a){
		int temp;
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a.length-i-1;j++){
				if(a[j]>a[j+1]){
					temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
			System.out.println(Arrays.toString(a));
		}
	}
  
	public static void main(String[] args) {
		 int[] a=new int[]{32,43,23,13,5};
		 bubbleSort(a);
		 System.out.println(Arrays.toString(a));
	}
}
