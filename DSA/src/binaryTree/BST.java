package binaryTree;

public class BST {
	private BinaryTreeNode<Integer> root ;
	private int size;
	
	private static boolean isPresenthelper(BinaryTreeNode<Integer> node, int x) {
		if(node==null) {
			return false;
		}
		if(node.data == x) {
			return true;
		}
		if(x<node.data) {
			return isPresenthelper(node.left, x);
		}else {
			return isPresenthelper(node.right, x);
		}
	}
	
	
	public boolean isPresent(int x) {
		
		return isPresenthelper(root, x);
	}
	
	private BinaryTreeNode<Integer> insertHelper(BinaryTreeNode<Integer> node, int x){
		if(node == null) {
			BinaryTreeNode<Integer> child = new BinaryTreeNode<Integer>(x);
			size++;
			return child;
		}
		if(x<node.data) {
			node.left = insertHelper(node.left, x);
		}else {
			node.right = insertHelper(node.right, x);
		}
		return node;
	}
	
	public void insert(int x) {
		root = insertHelper(root, x);
		
	}
	
	private static int smallestNode(BinaryTreeNode<Integer> node) {
		if(node==null) {
			return Integer.MAX_VALUE;
		}
		return Math.min(node.data, Math.min(smallestNode(node.left), smallestNode(node.right)));
	}
	
	private BSTDeleteReturn deleteDataHelper(BinaryTreeNode<Integer> node, int x) {
		if(node == null) {
			return new BSTDeleteReturn(null, false);
		}
		
		if(node.data < x) {
			BSTDeleteReturn outputRight  = deleteDataHelper(node.right, x);
			node.right = outputRight.root; 
			outputRight.root = node;
			return outputRight;
		}
		if(node.data > x) {
			BSTDeleteReturn outputLeft  = deleteDataHelper(node.left, x);
			node.left = outputLeft.root; 
			outputLeft.root = node;
			return outputLeft;
		}
//		0 children
		if(node.left ==null && node.right == null) {
			return new  BSTDeleteReturn(null, true);
		}
//		only left child
		if(node.left != null && node.right == null) {
			return new BSTDeleteReturn(node.left, true);
		}
//		only right child
		if(node.right != null && node.left == null) {
			return new BSTDeleteReturn(node.right, true);
		}
		
//		both children are present
		int rightMin = smallestNode(node.right);
		node.data = rightMin;
		BSTDeleteReturn output = deleteDataHelper(node.right, rightMin);
		node.right = output.root;
		return new BSTDeleteReturn(node, true);	
	}
	
	public  boolean deleteData(int x) {
		BSTDeleteReturn output = deleteDataHelper(root, x);
		if(output.deleted) {
			size--;
		}
		return output.deleted;
	}
	
	public int size() {
		return size;
	}
	
	private static void printTreeHelper(BinaryTreeNode<Integer> node) {
		if(node == null) {
			return;
		}
		System.out.print(node.data + " : ");
		if(node.left!=null) {
			System.out.print("L" + node.left.data);
		}
		if(node.right!=null) {
			if(node.left!=null) {
				System.out.print(", R" + node.right.data);
			}else {
				System.out.print("R" +  node.right.data);
			}
		}
		System.out.println();
		printTreeHelper(node.left);
		printTreeHelper(node.right);
		
		
	}
	
	public void printTree() {
		printTreeHelper(root);
		
	}
}