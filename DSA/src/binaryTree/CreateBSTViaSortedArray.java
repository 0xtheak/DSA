package binaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class CreateBSTViaSortedArray {
	
	public static BinaryTreeNode<Integer> helper(int[] arr, int si, int ei){
		if(si> ei) {
			return null;
		}
		int mid = (si + ei) /2;
		BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
		root.left = helper(arr, si, mid-1);
		root.right = helper(arr, mid+1, ei);
		return root;
	}
	
	public static BinaryTreeNode<Integer> contructBSTViaArray(int[] arr){
		BinaryTreeNode<Integer> root = helper(arr, 0, arr.length -1);
		return root;
	}
	
	public static void printLevelWise(BinaryTreeNode<Integer> root) {
		Queue<BinaryTreeNode<Integer> > queue = new LinkedList<BinaryTreeNode<Integer>>();
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> front = queue.poll();
			System.out.print(front.data + " : ");
			if(front.left!=null) {
				System.out.print("L" + front.left.data);
				queue.add(front.left);
			}
			if(front.right!=null) {
				if(front.left!=null) {
					System.out.print(", R" + front.right.data);
				}else {
					System.out.print("R" + front.right.data);
				}
				queue.add(front.right);
				
			}
			System.out.println();
		}
	}
	
	public static int maximum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MIN_VALUE;
		}
		
		return Math.max(root.data, Math.max(maximum(root.left), maximum(root.right)));
	}
	
	public static int minimum(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return Integer.MAX_VALUE;
		}
		
		return Math.min(root.data, Math.min(minimum(root.left), minimum(root.right)));
	}
	
	public static boolean isBST(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int leftmax  = maximum(root.left);
		if(root.data <= leftmax) {
			return false;
		}
		int rightmin = minimum(root.right);
		if(root.data > rightmin) {
			return false;
		}
		
		return isBST(root.left) && isBST(root.right);
	}
	public static  CheckBSTReturn isBSTImproved(BinaryTreeNode<Integer> root) {
		if(root==null) {
			CheckBSTReturn output = new CheckBSTReturn();
			output.max = Integer.MIN_VALUE;
			output.min = Integer.MAX_VALUE;
			output.isBST = true;
			return output;
		}
		CheckBSTReturn left = isBSTImproved(root.left);
		CheckBSTReturn right = isBSTImproved(root.right);
		boolean isBST = true;
		if(!right.isBST || ! left.isBST) {
			isBST = false;
		}
		if(root.data<= left.max) {
			isBST = false;
		}
		if(root.data > right.min) {
			isBST = false;
		}
		int max = Math.max(root.data, Math.max(left.max, right.max));
		int min = Math.min(root.data, Math.min(left.min, right.min));
		CheckBSTReturn ans = new CheckBSTReturn();
		ans.max = max;
		ans.min = min;
		ans.isBST = isBST;
		return ans;
	}
	public static boolean BST3(BinaryTreeNode<Integer> root, int lrange, int rrange) {
		if(root==null) {
			return true;
		}
		
		if(root.data <= lrange || root.data > rrange) {
			return false;
		}
		return BST3(root.left, lrange, root.data-1) && BST3(root.right, root.data, rrange);
	}

	public static void main(String[] args) {
		int[] arr = {1,3,4,5,6,7};
		BinaryTreeNode<Integer> root = contructBSTViaArray(arr);
//		root.data=2;
		printLevelWise(root);
//		CheckBSTReturn output = isBSTImproved(root);
//		System.out.println(output.max + " " + output.min + " " + output.isBST);
		System.out.println(BST3(root, Integer.MIN_VALUE, Integer.MAX_VALUE));

	}

}
