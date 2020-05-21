package leetcode;

public class KthsmallelementBST {
    int count=0;
    public int kthSmallest(TreeNode root, int k) {
        /*TreeNode node = traverse(root, k);
        return node.val;*/

        int[] num = new int[2];
        traverseEasy(root,k,num);
        return num[1];
    }
    //inorder traversal give elemenet in asc order in BST
    public TreeNode traverse(TreeNode root, int k)
    {
        if(root==null) return null;
        TreeNode leftnode = traverse(root.left,k);
        // this condition is gng to true only when k==0 return the element
        if(leftnode!=null) return leftnode;
        //BST has property of lowest element must be at end.
        //this is the counter for how many nodes has been processed. and this is class level so it will be not changing with eac call.
        count++;
        if(count==k) return root;

        return traverse(root.right,k);

    }

    /*/
    this is really easy to understand.
     */
    public void traverseEasy(TreeNode root, int k,int[] num) {
        if (root == null) return;
        traverseEasy(root.left, k, num);
        if (++num[0] == k)
        {
            num[1] =root.val;
            return;
        }
        traverseEasy(root.right,k,num);

    }
    public static void main(String[] args) {
        //TreeNode root = new TreeNode(3,new TreeNode(1,null,new TreeNode(2,null,null)),new TreeNode(4));
        TreeNode root = new TreeNode(5,new TreeNode(3,new TreeNode(2,new TreeNode(1),null),new TreeNode(4,null,null)),new TreeNode(6));
        KthsmallelementBST kthsmallelementBST = new KthsmallelementBST();
        kthsmallelementBST.kthSmallest(root,3);
    }
}
