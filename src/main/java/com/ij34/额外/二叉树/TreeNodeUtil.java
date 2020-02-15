package com.ij34.额外.二叉树;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	/*---------------------------------二叉树序列化---------------------------------*/
	/**二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存
	 *<br> 序列化时通过 某种符号表示空节点（#）*/
	public String Serialize(TreeNode root) {
		StringBuilder sb = new StringBuilder();
		if(root == null){
			sb.append("#,");
			return sb.toString();
		}
		sb.append(root.val+",");
		sb.append(Serialize(root.left));
		sb.append(Serialize(root.right));
		
		return sb.toString();
		
	}
	
	/**二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。*/
	int IDeserialize = -1;//下标
	public TreeNode Deserialize(String str) {
		++IDeserialize;
		if(IDeserialize >= str.length()) return null;
		String[] strs = str.split(",");
		TreeNode node = null;
		if(!strs[IDeserialize].equals("#")){
			node = new TreeNode(Integer.valueOf(strs[IDeserialize])); //不为空新建节点
			node.left = Deserialize(str);
			node.right = Deserialize(str);
		}
		
		return node;
		
	}
	
	/**二叉搜索树Binary Search Tree
	 *<br>找出其中的第k小的结点-中序非递归*/
	TreeNode KthNode(TreeNode node, int k){
        if(node != null){
      	   Stack<TreeNode> stack = new Stack<TreeNode>();
      	   while(!stack.isEmpty() || node != null){
      		   while(node !=null){  //再遍历左节点,出栈前访问根节点
      			   stack.push(node);
      			   node = node.left;
      		   }
      		   
      		   if(!stack.isEmpty()){
      			   node = stack.pop();
      			   --k;
      			   if(k == 0){
      				   return node;
      			   }
      			   node = node.right;
      		   }
      	   }
       }
		return null;
	}
	
	/**从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行
	 * <br> 获取层数*/
    ArrayList<ArrayList<Integer> > sPrint(TreeNode node) {
        ArrayList<ArrayList<Integer> > result = new ArrayList<ArrayList<Integer> >();
        if(node != null){
   	     Queue<TreeNode> queue = new LinkedList<TreeNode>();
   	     queue.offer(node); //放进根节点
   	     int len = treeDepth(node);//层数
   	     for(int c = 0;c < len;c++){
   	    	ArrayList<Integer> list = new ArrayList<Integer>();
   	    	Queue<TreeNode> tempQueue = new LinkedList<TreeNode>();
   	    	TreeNode pollNode = null;
      	     while((pollNode = queue.poll())!=null){//出队列
      	    	 list.add(pollNode.val);
       	    	 //将出队列的子节点放进队列里
       	    	 if(pollNode.left != null){
       	    		tempQueue.offer(pollNode.left);
       	    	 }
       	    	 if(pollNode.right != null){
       	    		tempQueue.offer(pollNode.right);
       	    	 }
       	     }
      	   queue.addAll(tempQueue);
      	   result.add(list);
   	     }
   	  /**打印之字形--第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印
          ArrayList<ArrayList<Integer> > result2 = new ArrayList<ArrayList<Integer> >();  
          for(int c=1;c<=len;c++){
              ArrayList<Integer> list =result.get(c-1);
              if(c%2==0){
            	  Collections.reverse(list);
                  result2.add(list);
              }else{
                  result2.add(list);
              }
          }
            result=result2;*/
     } 
        return result;
    }
	
	/**判断两个二叉树是否对称 都不为空情况下值相同，两个子节点相同（递归遍历）*/
    boolean isSame(TreeNode p,TreeNode q){
        if(p==null&&q==null) return true;
        if(p!=null&&q!=null) return (p.val==q.val)&&isSame(p.left,q.right)&&isSame(p.right,q.left);
        return false;
    }
    boolean isSymmetrical(TreeNode pRoot)
    {
         if(pRoot==null) return true;
        return isSame(pRoot.left,pRoot.right);
    }
	
	
    /**二叉树的前序遍历和中序遍历的结果，请重建出该二叉树*/
    public TreeNode reConstructBinaryTree(int [] pre,int [] in) {
        if(pre.length==0 || in.length==0) return null;
        TreeNode node=new TreeNode(pre[0]);
        for(int i=0;i<in.length;i++){
            if(in[i]==pre[0]){
                node.left=reConstructBinaryTree(Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                node.right=reConstructBinaryTree(Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return node;
    }
	
    /**二叉树A，B，判断B是不是A的子结构*/
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
         if(root1==null||root2==null) return false;
        return IsSubTree(root1,root2)||IsSubTree(root1.left,root2)||IsSubTree(root1.right,root2);
    }
    private boolean IsSubTree(TreeNode root1,TreeNode root2){
        if(root2==null) return true;
        if(root1==null) return false;
        if(root1.val==root2.val)
            return IsSubTree(root1.left,root2.left)&&IsSubTree(root1.right,root2.right);
        else return false;
    }

   /** 给定的二叉树，将其变换为源二叉树的镜像: 交换左右子树的节点，然后递归*/
    public void Mirror(TreeNode root) {
        if(root==null) return;
        TreeNode temp=null;
        temp=root.right;
        root.right=root.left;
        root.left=temp;
        Mirror(root.left);
        Mirror(root.right);
    }
	
	
   /** 一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果*/
    public boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length<1) return false;
        return isBSF(sequence,0,sequence.length-1);
    }
    private boolean isBSF(int[] S,int left,int right){
        if(left>=right) return true;
        int mid = left;
        while(mid < right && S[mid]<S[right]) mid++; //找到根节点位置的右边
        for(int i = mid ;i < right;i++){  //右边判断有小于根节点就不是二叉搜索树
        	if(S[i]<S[right]) return false;
        }
        return isBSF(S, left, mid-1)&&isBSF(S, mid, right-1);
    }
	
    /**根节点到叶子节点的和为某个值的路径*/
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
         ArrayList<ArrayList<Integer>> results=new ArrayList<ArrayList<Integer>>();
         ArrayList<Integer> list=new ArrayList<Integer>();
         return subFindPath(root, target, results,list);
    }
    public ArrayList<ArrayList<Integer>> subFindPath(TreeNode root,int target,ArrayList<ArrayList<Integer>> results,ArrayList<Integer> list) {
        if(root==null) return results;
        list.add(root.val);
        target-=root.val;
        if(target==0&&root.left==null&&root.right==null)
            results.add(new ArrayList<Integer>(list));
        subFindPath(root.left,target,results,list);
        subFindPath(root.right,target,results,list);
        list.remove(list.size()-1);  //该路径没有找到，返回上一个节点继续深度遍历
        return results;
    }
    
    
    
     /**二叉搜索树转换成一个排序的双向链表*/
    public TreeNode Convert(TreeNode node) {
    	if(node == null) return null;
    	LinkedList<TreeNode> list = inOrderList(node);
        for(int i = 0; i < list.size() - 1; i++){
            list.get(i).right = list.get(i + 1);
            list.get(i + 1).left = list.get(i);
        }
        return list.get(0);

    }
	/**中序遍历-非递归  返回LinkedList<TreeNode>*/
	private LinkedList<TreeNode> inOrderList(TreeNode node) {
		LinkedList<TreeNode> result = new LinkedList<TreeNode>();
        if(node != null){
     	   Stack<TreeNode> stack = new Stack<TreeNode>();
     	   
     	   while(!stack.isEmpty() || node != null){
     		   while(node !=null){  //再遍历左节点,出栈前访问根节点
     			   
     			   stack.push(node);
     			   node = node.left;
     		   }
     		   
     		   if(!stack.isEmpty()){
     			   node = stack.pop();
     			  result.add(node);
     			   node = node.right;
     		   }
     	   }
     	   return result;
      }
		return null;
	}
	
	/**判断该二叉树是否是平衡二叉树 ,它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树*/
    public boolean IsBalanced_Solution(TreeNode root) {
        if(root==null) return true;
        int l=treeDepth(root.left);
        int r=treeDepth(root.right);
        int dif=r-l;
        if(dif>1||dif<-1) return false;
        return IsBalanced_Solution(root.left)&&IsBalanced_Solution(root.right);
      
    }

	
	
}
