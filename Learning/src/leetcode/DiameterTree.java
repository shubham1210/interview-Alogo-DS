package leetcode;

public class DiameterTree {

    static int result  = Integer.MIN_VALUE;
    public static class TreeNode {
     int val;
     TreeNode left;
      TreeNode right;
     TreeNode(int x) { val = x; }
  }

    /**
     * so height of the tree can be think of the the one small tree at atime from bottom where it is sum of left and right +1
     * @param root
     * @return
     */
  static int height(TreeNode root)
  {
      if(root ==null ) return 0;

      int left_height =  height(root.left);
      int right_height =  height(root.right);
      //this is just added tp tract the diameter of each tree at every point.
      result =  Math.max(result,left_height+right_height+1);
      // either the left can be deeper or right can be more deeper but one can win for the height factor
      return Math.max(left_height,right_height)+1;
  }

  public static  int diameter(TreeNode root){
        if(root==null) return 0;
        height(root);
        return result;

  }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);node.right = new TreeNode(3);
        node.left.left = new   TreeNode(4);node.left.right = new   TreeNode(5);
        diameter(node);
        System.out.println(result-1);
    }

}
