import java.util.*;

public class Tree{

	public static class Node{
		int key;
		Node left = null;
		Node right = null;

		public Node(int d){
			key = d;
			left = right = null;
		}
	}

	// MAKING A BINARY TREE WHICH CONTAINS AT MOST 2 NODES

	public static class binaryTree{
		Node root;

		public binaryTree(int d){
			root = new Node(d);
		}
		public binaryTree(){
			root = null;
		}
	}

	// Funtion to get the height of the tree using recursion

	public int getHeight(Node root){
		 int leftD = 0 ;
		 int rightD = 0;
		 if(root!=null){
		 	leftD = getHeight(root.left);
		 	rightD = geteight(root.right);
		 }
		 if(leftD>rightD)
		 	return leftD+1;
		 else	
			return rightD+1;
	}



	public static void level(Node root,int level){
		if(level == 0){
			System.out.print(root.data+" ");
		}
		else if(level > 0){
			level(root.left,level-1);
			level(root.right,level-1);
		}
	}

	// Function to print the level order or BFS using recursion

	public static void levelOrder(Node root){
		int h = getHeight(root);
		for(int x=0;x<h;x++){
			level(root,x);
		}
	}
	

	public static void main(String[] args){
		binaryTree tree = new binaryTree(1);
		tree.root.left = new Node(2);
		tree.root.right = new Node(4);
		tree.root.left.left = new Node(3);
		System.out.println(getHeight());
	}


}
