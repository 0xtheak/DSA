package binaryTree;

import java.util.*;

public class BinaryTreeUse {
	
	
	public static void printTree(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data + " ");
		printTree(root.left);
		printTree(root.right);
	}
	public static void printTree2(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return ;
		}
		
		System.out.print(root.data + " : ");
		if(root.left!=null) {
			System.out.print("L" + root.left.data + " ");
		}
		if(root.right!=null) {
			if(root.left!=null) {
				System.out.print(", R" + root.right.data);
			}else {
				System.out.print("R"+root.right.data);
			}
		}
		System.out.println();
		printTree2(root.left);
		printTree2(root.right);
	}
	
	public static BinaryTreeNode<Integer> takeTreeInput(Boolean isRoot, int parentData, Boolean isLeft){
		if(isRoot) {
			System.out.println("Enter root data");
		}else {
			if(isLeft) {
				System.out.println("Enter " + parentData + "'s left data");
			}else {
				System.out.println("Enter " + parentData + "'s right data");
			}
		}
		Scanner s = new Scanner(System.in);
		int rootData = s.nextInt();
		if(rootData==-1) {
			return null;
		}
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(rootData);
		root.left=takeTreeInput(false, root.data, true);
		root.right=takeTreeInput(false, root.data, false);
		return root;
	}
	public static void preOrder(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		System.out.print(root.data + " ");
		preOrder(root.left);
		preOrder(root.right);
	}
	public static void postOrder(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		postOrder(root.left);
		postOrder(root.right);
		System.out.print(root.data + " ");
	}
	public static void inOrder(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		inOrder(root.left);
		System.out.print(root.data + " ");
		inOrder(root.right);
		
	}
	public static int LargestNode(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		return Math.max(root.data, Math.max(LargestNode(root.left), LargestNode(root.right)));
	}
	
	public static int leafNodes(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		if(root.left==null && root.right==null) {
			return 1;
		}
		return leafNodes(root.left) + leafNodes(root.right);
	}
	
	public static void depthK(BinaryTreeNode<Integer> root, int k) {
		if(root==null) {
			return;
		}
		if(k==0) {
			System.out.print(root.data + " ");
			return;
		}
		depthK(root.left, k-1);
		depthK(root.right, k-1);
	}
	
	public static BinaryTreeNode<Integer> removeLeaves(BinaryTreeNode<Integer> root){
		if(root==null) {
			return null;
		}
		if(root.left==null && root.right==null) {
			return null;
		}
		root.left=removeLeaves(root.left);
		root.right = removeLeaves(root.right);
		return root;
	}
	public static BinaryTreeNode<Integer> changeMe(BinaryTreeNode<Integer> root){
		if(root==null) {
			return null;
		}
		BinaryTreeNode<Integer> left = changeMe(root.left);
		BinaryTreeNode<Integer> right = changeMe(root.right);
		root.left = right;
		root.right = left;
		return root;
	}
	
	public static void mirrorBT(BinaryTreeNode<Integer> root) {
		changeMe(root);
	}

	public static void main(String[] args) {

		BinaryTreeNode<Integer> root = takeTreeInput(true, 0, false);
//		printTree2(root);

//		System.out.println("Largest node data " + LargestNode(root) );
//		System.out.println("Largest node data " + leafNodes(root) );
//		depthK(root, 2);
//		root = removeLeaves(root);
		printTree2(root);
		mirrorBT(root);
		printTree2(root);

	}

}