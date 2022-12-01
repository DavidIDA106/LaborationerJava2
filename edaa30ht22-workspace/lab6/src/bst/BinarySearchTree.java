package bst;

import java.util.ArrayList;
import java.util.Comparator;


public class BinarySearchTree<E> {
  BinaryNode<E> root;  // Används också i BSTVisaulizer
  int size;            // Används också i BSTVisaulizer
  private Comparator<E> comparator;
    
	/**
	 * Constructs an empty binary search tree.
	 */
	public BinarySearchTree() {
		root = null;
		size = 0;
	}
	
	/**
	 * Constructs an empty binary search tree, sorted according to the specified comparator.
	 */
	public BinarySearchTree(Comparator<E> comparator) {
		root = null;
		size = 0;
		this.comparator = comparator;
	}

	/**
	 * Inserts the specified element in the tree if no duplicate exists.
	 * @param x element to be inserted
	 * @return true if the the element was inserted
	 */
	public boolean add(E x) {
		if(size == 0) {
			root = new BinaryNode<E>(x);
			size++;
			return true;
		}
		BinaryNode<E> n = addCalc(root, x);
		if(n != null) {
			n = new BinaryNode<E>(x);
			size++;
			return true;
		}
		
		return false;
	}

	private BinaryNode<E> addCalc(BinaryNode<E> n, E x) {
		if(n.left ==null && n.right == null && comparator.compare(n.element, x) == -1) {
			return n.right;
		}
		else if(n.left ==null && n.right == null && comparator.compare(n.element, x) == 1) {
			return n.left;
		}
		else if(n.element.equals(x)) { 		//eventuellt byta equals till comparator
			return null;
		}

		if(comparator.compare(n.element, x) == -1) {
			addCalc(n.right, x);
		}
		else if(comparator.compare(n.element, x) == 1) {
			addCalc(n.left, x);
		}
		return null;
	} 
	
	/**
	 * Computes the height of tree.
	 * @return the height of the tree
	 */
	public int height() {
		return calcHeight(root);
	}

	private int calcHeight(BinaryNode<E> n) {
		int countR = 0;
		int countL = 0;
		if(size < 2) {
			return size;
		}
		if(n.right != null) {
			countR++;
			calcHeight(n.right);
		}
		if(n.left != null) {
			countL++;
			calcHeight(n.left);
		}
		return Math.max(countR, countL);
	}
	
	/**
	 * Returns the number of elements in this tree.
	 * @return the number of elements in this tree
	 */
	public int size() {
		return size;
	}
	
	/**
	 * Removes all of the elements from this list.
	 */
	public void clear() {
		root = null;
		size = 0;
	}
	
	/**
	 * Print tree contents in inorder.
	 */
	public void printTree() {
		print(root);
	}
	private void print(BinaryNode<E> n) {
		if(n!=null) {
			print(n.left);
 			System.out.println(n.element);
 			print(n.right);
		}
	}

	/** 
	 * Builds a complete tree from the elements in the tree.
	 */
	public void rebuild() {

	}
	
	/*
	 * Adds all elements from the tree rooted at n in inorder to the list sorted.
	 */
	private void toArray(BinaryNode<E> n, ArrayList<E> sorted) {
	
	}
	
	/*
	 * Builds a complete tree from the elements from position first to 
	 * last in the list sorted.
	 * Elements in the list a are assumed to be in ascending order.
	 * Returns the root of tree.
	 */
	private BinaryNode<E> buildTree(ArrayList<E> sorted, int first, int last) {
		return null;
	}

	static class BinaryNode<E> {
		E element;
		BinaryNode<E> left;
		BinaryNode<E> right;

		private BinaryNode(E element) {
			this.element = element;
		}	
	}
	
}
