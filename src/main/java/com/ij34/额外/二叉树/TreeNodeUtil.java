package com.ij34.额外.二叉树;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class TreeNodeUtil {
	
	/**打印节点*/
	void print(TreeNode node){
		System.out.print(node.val);
	}
	
	
	/**前序遍历-递归*/
	public void preOrder(TreeNode node) {
		if(node != null){
			print(node);
			preOrder(node.left);
			preOrder(node.right);
		}
	}
	
	/**中序遍历-递归*/
	public void inOrder(TreeNode node) {
		if(node != null){
			inOrder(node.left);
			print(node);
			inOrder(node.right);
		}
	}
	
	/**后序遍历-递归*/
	public void postOrder(TreeNode node) {
		if(node != null){
			postOrder(node.left);
			postOrder(node.right);
			print(node);
		}
	}
	
	/**层次遍历 ：借助队列，节点出队将子节点放进队列*/
	public void bfsOrder(TreeNode node) {
      if(node != null){
    	     Queue<TreeNode> queue = new LinkedList<TreeNode>();
    	     queue.offer(node); //放进根节点
    	     TreeNode pollNode;
    	     while((pollNode = queue.poll())!=null){//出队列
    	    	 print(pollNode);
    	    	 //将出队列的子节点放进队列里
    	    	 if(pollNode.left != null){
    	    		 queue.offer(pollNode.left);
    	    	 }
    	    	 if(pollNode.right != null){
    	    		 queue.offer(pollNode.right);
    	    	 }
    	    	 
    	     }
      }
	}
	
	/**求二叉树的节点数*/
	public int nodeCount(TreeNode node) {
      if(node != null){
            return 1 + nodeCount(node.left) + nodeCount(node.right);
      }else{
    	  return 0;
      }
	}
	
	/**求二叉树的叶子树*/
	public int Leaves(TreeNode node) {
      if(node != null){
    	  int left = Leaves(node.left);
    	  int right = Leaves(node.right);
          if(left == 0 && right == 0){
        	  return 1;
          }else{
             return left + right;
          }
      }else{
    	  return 0;
      }
	}
	
	/**求二叉树的高度*/
	public int treeDepth(TreeNode node) {
      if(node == null){
    	  return 0;
      }
//      System.out.println(node.val);
      int l = treeDepth(node.left);
//      System.out.println("l"+l);
      int r = treeDepth(node.right);
//      System.out.println("r"+r);
      return l > r?l + 1 : r+1;
      
	}
   
   /*----------------------------------非递归--------------------------------------*/
	
	/**前序遍历-非递归 用栈*/
	public void preOrder_nonrecursive(TreeNode node) {
        if(node != null){
        	   Stack<TreeNode> stack = new Stack<TreeNode>();
        	   
        	   while(!stack.isEmpty() || node != null){
        		   while(node !=null){  //访问根节点，再遍历左节点
        			   print(node);
        			   stack.push(node);
        			   node = node.left;
        		   }
        		   
        		   if(!stack.isEmpty()){
        			   node = stack.pop();
        			   node = node.right;
        		   }
        	   }
         }
	}
	
	/**中序遍历-非递归 :栈*/
	public void inOrder_nonrecursive(TreeNode node) {
        if(node != null){
     	   Stack<TreeNode> stack = new Stack<TreeNode>();
     	   
     	   while(!stack.isEmpty() || node != null){
     		   while(node !=null){  //再遍历左节点,出栈前访问根节点
     			   
     			   stack.push(node);
     			   node = node.left;
     		   }
     		   
     		   if(!stack.isEmpty()){
     			   node = stack.pop();
     			   print(node);
     			   node = node.right;
     		   }
     	   }
      }
	}
	
	/**后序遍历-非递归 栈*/
	public void postOrder_nonrecursive(TreeNode node) {
        if(node != null){
      	 Stack<TreeNode> stack = new Stack<TreeNode>();
      	TreeNode last = null;//标志上一次打印节点
      	 while(!stack.isEmpty() || node != null){
 		   while(node !=null){  //左节点入栈
  			   stack.push(node);
  			   node = node.left;
  		   }
      	   
 		   
      	   if(!stack.isEmpty()){
      		/*弹出栈顶，如果右孩子为null或者last是右孩子，则打印当前值；如果不是，则将指针指向右孩子*/
      		 TreeNode popNode = stack.pop();
      		   if(popNode.right == null || popNode.right == last){
      			   print(popNode);
      			   last = popNode;
      		   }else{
      			   stack.push(popNode);
      			   node = popNode.right;
      		   }
      	    } 
      	   }
       }
	}
	
	
	
}
