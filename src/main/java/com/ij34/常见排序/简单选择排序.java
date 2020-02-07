package com.ij34.常见排序;

public class 简单选择排序 {
	
	
	public static void selectSort(int[] a){
		for(int i=0;i<a.length;i++){
			//第i个数的值和下标
			int key=a[i];
			int position=i;
			//确保value是i往后下标中是最小的
			for(int j=i+1;j<a.length;j++){
				if(a[j]<key){
					key=a[j];
					position=j;
				}
			}
			//原先j位置放i的值，i放最小值
			a[position]=a[i];
			a[i]=key;
		}
	}
	
	


	public static void main(String[] args) {
			int[] a=new int[]{49,38,65,97,76,13,27,55,04};
			 selectSort(a);
			 for(int a1 :a)
			 System.out.print(a1+"|");
		
	}

}
