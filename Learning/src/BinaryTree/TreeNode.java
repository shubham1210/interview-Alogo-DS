package BinaryTree;

/**
 * This class works as a dataStructure it has a left and right node that Node must have.
 * 
 * @author ShubhamSharma
 *
 */
class TreeNode implements Comparable<TreeNode> {
	private int data; // This will contain the value of Node as integer
	private TreeNode left; // This is a node on left side Node
	private TreeNode right; // This is a node on right side Node

	public TreeNode(int data) {
		this.data = data;
		left = null;
		right = null;
	}

	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public void setRight(TreeNode right) {
		this.right = right;
	}

	public TreeNode getLeft() {
		return this.left;
	}

	public TreeNode getRight() {
		return this.right;
	}

	public int getData() {
		return this.data;
	}

	public boolean equals(TreeNode n) {
		if(n ==  null) return false;
		return this.data == n.getData() ? true : false;
	}
	
	/**
	 * This method is implemented if we need to change our comparison logic in future we do not need to  change in implementation
	 */
	public int compareTo(TreeNode o) {
		if(o ==  null) return -1;
		return this.equals(o) ? 0 : this.data - o.getData();
	}
	
	
}