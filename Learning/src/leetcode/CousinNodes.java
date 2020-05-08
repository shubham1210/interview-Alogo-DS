package leetcode;

public class CousinNodes {
    int xDepth;
    int yDepth;

    TreeNode xParent;
    TreeNode yParent;
    int foundCount =2;
    public boolean isCousins(TreeNode root, int x, int y) {

        if(root==null || root.val ==x || root.val==y) return false;
        depth( root,x,y,null,0);

        if(foundCount==0 && xDepth==yDepth && xParent!=yParent) return true;
        else
            return false;
    }

    public void depth(TreeNode root, int x, int y, TreeNode parent, int height)
    {
        if(root==null || foundCount==0) return ;
        if(root.val==x) {
            xDepth = height;
            xParent =parent;
            foundCount--;
        };
        if(root.val==y) {
            yDepth = height;
            yParent =parent;
            foundCount--;
        };

        depth(root.left,x,y,root,height+1);
        depth(root.right,x,y,root,height+1);

    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1,new TreeNode(2),new TreeNode(3));
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(5);

        CousinNodes cousinNodes = new CousinNodes();
        cousinNodes.isCousins(root,5,4);
    }
}
