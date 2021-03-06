package com.ij34.额外.二叉树;

import java.util.ArrayList;

public class TestTreeNode {

	public static void main(String[] args) {
		TreeNodeUtil util = new TreeNodeUtil();
		
		
		TreeNode bstRoot = new TreeNode(5);
		bstRoot.left = new TreeNode(3);
		bstRoot.right = new TreeNode(7);
		bstRoot.left.left = new TreeNode(2);
		bstRoot.left.right = new TreeNode(4);
		bstRoot.right.left = new TreeNode(6);
		bstRoot.right.right = new TreeNode(8);
//		root.left.right = new TreeNode(2);
//		root.left.right.right = new TreeNode(1);
		
		//构建树
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(5);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(2);
		root.left.right.right = new TreeNode(1);
		
		System.out.println("前序递归遍历");
		util.preOrder(root);
		System.out.println("\n------------------------------------");
		System.out.println("前序no递归遍历");
		util.preOrder_nonrecursive(root);
		System.out.println("\n------------------------------------");
		System.out.println("中序递归遍历");
		util.inOrder(root);
		System.out.println("\n------------------------------------");
		System.out.println("中序no递归遍历");
		util.inOrder_nonrecursive(root);
		System.out.println("\n------------------------------------");
		System.out.println("后序递归遍历");
		util.postOrder(root);
		System.out.println("\n------------------------------------");
		System.out.println("后序no递归遍历");
		util.postOrder_nonrecursive(root);
		System.out.println("\n------------------------------------");
		System.out.println("层次遍历");
		util.bfsOrder(root);
		System.out.println("\n------------------------------------");
		System.out.println("总节点数");
		System.out.println(util.nodeCount(root));
		System.out.println("------------------------------------");
		System.out.println("叶子树");
		System.out.println(util.Leaves(root));
		System.out.println("------------------------------------");
		System.out.println("高度");
		System.out.println(util.treeDepth(root));
		System.out.println("------------------------------------");
		System.out.println("序列化二叉树");
		System.out.println(util.Serialize(root));  //3,5,4,#,#,2,#,1,#,#,#,
		System.out.println("------------------------------------");
		String SerializeStr = "3,5,4,#,#,2,#,1,#,#,#,";
		System.out.println("反序列化二叉树");
		TreeNode SerializeNode = util.Deserialize(SerializeStr);
		util.preOrder(SerializeNode);  
		System.out.println("------------------------------------");
		System.out.println("查询二叉树搜索树的第K个节点");
		
		TreeNode bstNode = util.KthNode(bstRoot, 3); 
		util.print(bstNode);
		System.out.println("\n------------------------------------");
		System.out.println("从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行");
		ArrayList<ArrayList<Integer> > sList = util.sPrint(bstRoot);
		for(ArrayList<Integer> list : sList){
			for(Integer value : list){
				System.out.print(value+",");
			}
			System.out.println();
		}
		
		System.out.println("------------------------------------");
		
		
	}

}
