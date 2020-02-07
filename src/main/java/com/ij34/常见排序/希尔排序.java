package com.ij34.常见排序;

public class 希尔排序 {
  
	public static void shellSort(int[] a){
		if(a.length>1){
		   int len=a.length;
		   while(len>0){
			   len/=2;
			   for(int i=0;i<len;i++){//分的组
				   for(int j=i+len;j<a.length;j+=len){//组中的元素,除了第一个元素
					   //组内直接插入排序
					   int t=j-len; //组内第一个元素默认有序
					   int insertNum=a[j];
						for(;t>=0;t-=len){
							//待插的数比前面小，就后一位
							if(insertNum<a[t]){
								a[t+len]=a[t];
							}else{
								//否则停止移动
								break;
							}
						}
						
						a[t+len]=insertNum;
						
				   }
			   }
//				 for(int a1 :a)
//					 System.out.print(a1+"-");
//				 System.out.println();
		   }
		}
	}
	public static void main(String[] args) {
		int[] a=new int[]{49,38,65,97,76,13,27,49,55,04};
		 shellSort(a);
		 for(int a1 :a)
		 System.out.print(a1+"|");
	}
}
