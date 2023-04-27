package binaryTree;

public class BSTUse {

	public static void main(String[] args) {
		BST b = new BST();
		b.insert(4);
		b.insert(3);
		b.insert(2);
		b.insert(1);
		b.insert(5);
		b.insert(9);
		b.insert(10);
		
		
		b.printTree();
		System.out.println(b.deleteData(4));
		b.printTree();
		

	}

}
