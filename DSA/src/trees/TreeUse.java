package trees;
import java.util.*;

public class TreeUse {
	
	public static void printTree(TreeNode<Integer> root) {
//		special case not the base case
		if(root==null) {
			return;
		}
		System.out.print(root.data);
		for(int i=0;i<root.children.size(); i++) {
			printTree(root.children.get(i));
		}
	}
	public static void printTree2(TreeNode<Integer> root) {
//		special case not the base case
		if(root==null) {
			return;
		}
		System.out.print(root.data + " : ");
		for(int i=0; i<root.children.size(); i++) {
			System.out.print(root.children.get(i).data + " ");
		}
		System.out.println();
		for(int i=0;i<root.children.size(); i++) {
			printTree2(root.children.get(i));
		}
	}
	
	public static int noOfNodes(TreeNode<Integer> root) {
		if(root==null) {
			return 0;
		}
		int totalNodes = 1;
		for(int i=0; i<root.children.size(); i++) {
			totalNodes += noOfNodes(root.children.get(i));
		}
		return totalNodes;
	}
	
	public static TreeNode<Integer> takeInput(){
		Scanner s = new Scanner(System.in);
		Queue<TreeNode<Integer>> pendingNodes = new LinkedList<TreeNode<Integer>>();
		System.out.println("Enter root data");
		int rootData = s.nextInt();
		if(rootData==-1) {
			return null;
		}
		TreeNode<Integer> root = new TreeNode<Integer>(rootData);
		pendingNodes.add(root);
		while(!pendingNodes.isEmpty()) {
			TreeNode<Integer> front = pendingNodes.remove();
			System.out.println("Enter the no of children for " + front.data);
			int noOfChild = s.nextInt();
			for(int i= 0; i<noOfChild; i++) {
				System.out.println("Enter the " + i + "th child data for: " + front.data);
				int childrenData = s.nextInt();
				TreeNode<Integer> children = new TreeNode<Integer>(childrenData);
				front.children.add(children);
				pendingNodes.add(children);
			}
		}
		return root;
	}
	
	public static void printTreeLevelWise(TreeNode<Integer> root) {
		if(root==null) {
			return;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()){
			TreeNode<Integer> front = queue.remove();
			if(front!=null) {
				System.out.print(front.data + " ");
				for(int i=0; i<front.children.size(); i++) {
					queue.add(front.children.get(i));
				}
				
			}else {
				System.out.println();
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			}
			
			
		}
	}
	public static ArrayList<Integer> TreeToArray(TreeNode<Integer> root){
		if(root==null) {
			return null;
		}
		Queue<TreeNode<Integer>> queue = new LinkedList<>();
		ArrayList<Integer> arr = new ArrayList<Integer>();
		queue.add(root);
		queue.add(null);
		while(!queue.isEmpty()) {
			TreeNode<Integer> front = queue.remove();
			if(front!=null) {
				arr.add(front.data);
				for(int i=0; i<front.children.size(); i++) {
					queue.add(front.children.get(i));
				}
			}else {
				if(!queue.isEmpty()) {
					queue.add(null);
				}
			}
		}
		return arr;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		TreeNode<Integer> root = new TreeNode<>(4);
//		TreeNode<Integer> child1 = new TreeNode<>(2);
//		TreeNode<Integer> child2 = new TreeNode<>(3);
//		TreeNode<Integer> child3 = new TreeNode<>(1);
//		TreeNode<Integer> child4 = new TreeNode<>(5);
//		TreeNode<Integer> child5 = new TreeNode<>(6);
//		root.children.add(child1);
//		root.children.add(child2);
//		root.children.add(child3);
//		child2.children.add(child4);
//		child2.children.add(child5);
		TreeNode<Integer> root = takeInput();
		printTreeLevelWise(root);
		ArrayList<Integer> output = TreeToArray(root);
		if(output!=null) {
			for(int i: output) {
				System.out.print(i + " ");
			}
		}
//		System.out.println(noOfNodes(root));

	}

}
