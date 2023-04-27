package binaryTree;

public class BST {
	private BinaryTreeNode<Integer> root ;
	private int size;
	
	private boolean helper(BinaryTreeNode<Integer> root, int x) {
		if(root==null) {
			return false;
		}
		if(root.data == x) {
			return true;
		}
		if(x<root.data) {
			return helper(root.left, x);
		}else {
			return helper(root.right, x);
		}
	}
	
	public boolean isPresent(int x) {
		
		return helper(root, x);
	}
	
	public void insert(int x) {
		
	}
	public  boolean deleteData(int x) {
		return false;
	}
	
	public int size() {
		return size;
	}
	
	public void printTree() {
		
	}

}
