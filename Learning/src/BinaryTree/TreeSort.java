package BinaryTree;

import java.util.ArrayList;
import java.util.List;

/**
 * TreeSort is implementation of binary tree 
 * @author shubhamsharma
 *
 */
public class TreeSort {
	TreeNode root;
	

	/**
	 * Takes an unsorted list of integers, creates a binary tree to store the
	 * integers
	 *
	 * @param inputs Unsorted list of Integers
	 */
	public TreeSort(List<Integer> inputs) {
		if (inputs != null) { // added this check for null inputs 
			int sizeOfArray = inputs.size();
			for (int i = 0; i < sizeOfArray; i++) {
				if (i == 0) {
					root = new TreeNode(inputs.get(i));
				} else {
					insert(root, new TreeNode(inputs.get(i)));
				}
			}
		}
	}

	/**
	 * Method allows to add new node to tree with a check whether element already exists or not
	 * @param root
	 * @param newNode
	 */
	private void insert(TreeNode root, TreeNode newNode) {
		if (root == null || newNode == null) // here we check for coming root and new node is not null
			return;

		if (root.compareTo(newNode) == 0) //at any point we don't allow to add duplicate data in tree so we simply placed return
			return;

		// this piece of code simply determine whether coming element is greater or smaller than current element and call recursive it's self for
		// drill down in to the tree.
		if (root.compareTo(newNode) > 0) { // here we check compare logic from compareTo method it will help us in future if compare logic will change only need to change compareTo method
			if (root.getLeft() == null) {
				root.setLeft(newNode);
			} else {
				insert(root.getLeft(), newNode);
			}

		} else if (root.compareTo(newNode) < 0) {
			if (root.getRight() == null) {
				root.setRight(newNode);
			} else {
				insert(root.getRight(), newNode);
			}
		}
	}

	/**
	 * Walks the binary tree to return a sorted list of integers
	 *
	 * @return Sorted list of Integers if root is null or blank it will return null
	 */
	public List<Integer> getSortedIntegers() {
		if(root == null) return null;
		List<Integer> sortedList =new ArrayList<Integer>();
		traverseBinaryTreeInOrder(root,sortedList);
		return sortedList;

	}

	/**
	 * This method is used for Traversing our Tree and add element in final Sorted List
	 * @param root
	 */
	private void traverseBinaryTreeInOrder(TreeNode root,List<Integer> sortedList) {
		if (root != null) {
            System.out.print(" "+root.getData());
            traverseBinaryTreeInOrder(root.getLeft(), sortedList); // here we call recursively left  itself to drill down in tree

			traverseBinaryTreeInOrder(root.getRight(), sortedList); // here we call recursively right node itself to drill down in tree

            sortedList.add(root.getData());
		}
	}
	
}
