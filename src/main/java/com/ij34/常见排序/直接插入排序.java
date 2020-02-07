package com.ij34.常见排序;

public class 直接插入排序 {
   
	public static void insertSort(int[] a){
		if(a.length>1){
			int insertNum;
			//下标0的默认是有序，后面的都是要插入的数
			for(int i=1;i<a.length;i++){
				insertNum = a[i];
				//i-1个都是有序的
				int j=i-1;
				for(;j>=0;j--){
					//待插的数比前面小，就后一位
					if(insertNum<a[j]){
						a[j+1]=a[j];
					}else{
						//否则停止移动
						break;
					}
				}
				
				a[j+1]=insertNum;
			}
		}
		
	}
	
	public static void main(String[] args) {
		int[] a=new int[]{1,2,3,4,5};
		 insertSort(a);
		 for(int a1 :a)
		 System.out.print(a1+"|");
	}
}
