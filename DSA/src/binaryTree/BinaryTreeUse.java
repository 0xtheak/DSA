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
	
	public static int heightBT(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		return 1 + Math.max(heightBT(root.left), heightBT(root.right));
	}
	
	public static void mirrorBT(BinaryTreeNode<Integer> root) {
		changeMe(root);
	}
//	
	public static boolean checkBalanceTree(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return true;
		}
		int lst = heightBT(root.left);
		int rst = heightBT(root.right);
		if(Math.abs(lst-rst)>1) {
			return false;
		}
		return checkBalanceTree(root.left) && checkBalanceTree(root.right);
	}
	
	public static BalanceTreeReturn isBalancedBetter(BinaryTreeNode<Integer> root) {
		if(root==null) {
			BalanceTreeReturn output = new BalanceTreeReturn();
			output.height = 0;
			output.isBalance = true;
			return output;
		}
		
		BalanceTreeReturn left = isBalancedBetter(root.left);
		BalanceTreeReturn right = isBalancedBetter(root.right);
		boolean isBal = true;
		
		if(Math.abs(left.height - right.height) >1) {
			isBal = false;
		}
		if(!left.isBalance || !right.isBalance) {
			isBal = false;
		}
		BalanceTreeReturn output = new BalanceTreeReturn();
		output.height = 1 + Math.max(left.height, right.height);
		output.isBalance = isBal;
		return output;
	}
	
	public static int diameterOfTree(BinaryTreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		return heightBT(root.left) + heightBT(root.right) + 1;	
	}
	
	public static BinaryTreeNode<Integer> takeInputLevelWise(){
		Scanner s = new Scanner(System.in);
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if(rootData==-1) {
			return null;
		}
		Queue<BinaryTreeNode<Integer>> queue = new LinkedList<BinaryTreeNode<Integer>>();
		BinaryTreeNode<Integer> root = new  BinaryTreeNode<Integer>(rootData);
		queue.add(root);
		while(!queue.isEmpty()) {
			BinaryTreeNode<Integer> front = queue.poll();
			System.out.println("Enter left child of " + front.data);
			int left = s.nextInt();
			if(left!=-1) {
				BinaryTreeNode<Integer> lchild = new BinaryTreeNode<Integer>(left);
				front.left = lchild;
				queue.add(lchild);
			}
			System.out.println("Enter right child of " + front.data);
			int right = s.nextInt();
			if(right!=-1) {
				BinaryTreeNode<Integer> rchild = new BinaryTreeNode<Integer>(right);
				front.right = rchild;
				queue.add(rchild);
			}
			
			
		}
		return root;
	}
	
	public static boolean BST3(BinaryTreeNode<Integer> root, int lrange, int rrange) {
		if(root==null) {
			return true;
		}
		if(root.data <= lrange) {
			return false;
		}
		
		if(root.data > rrange) {
			return false;
		}
		return BST3(root.left, lrange, root.data-1) && BST3(root.right, root.data+1, rrange);
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
	
	public static ArrayList<Integer> XtoRootPath(BinaryTreeNode<Integer> root, int x){
		if(root==null) {
			return null;
		}
		if(root.data == x) {
			ArrayList<Integer> output = new ArrayList<Integer>();
			output.add(root.data);
			return output;
		}
		ArrayList<Integer> lside = XtoRootPath(root.left, x);
		
		if(lside!=null) {
			lside.add(root.data);
			return lside;
		}
		ArrayList<Integer> rside = XtoRootPath(root.right, x);
		if(rside!=null) {
			rside.add(root.data);
			return rside;
		}
		return null;
	}

	public static void main(String[] args) {

//		BinaryTreeNode<Integer> root = takeTreeInput(true, 0, false);
//		printTree2(root);

//		System.out.println("Largest node data " + LargestNode(root) );
//		System.out.println("Largest node data " + leafNodes(root) );
//		depthK(root, 2);
//		root = removeLeaves(root);
		BinaryTreeNode<Integer> root = takeInputLevelWise();
		printLevelWise(root);
		ArrayList<Integer> path = XtoRootPath(root, 1);
		if(path==null) {
			System.out.println("Not Found!");
		}else for(int i: path) {
			System.out.print(i + " ");
		}
//		printTree2(root);
//		mirrorBT(root);
//		printTree2(root);
//		System.out.println("height of the tree : " + heightBT(root));
//		BalanceTreeReturn output = isBalancedBetter(root);
//		System.out.println("tree height : " + output.height + "\nis tree balanced : " + output.isBalance);
//		System.out.println("Diameter of tree : " + diameterOfTree(root));
	}

}
