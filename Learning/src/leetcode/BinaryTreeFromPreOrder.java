package leetcode;

import java.util.concurrent.atomic.AtomicInteger;

public class BinaryTreeFromPreOrder {

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }

    public static TreeNode bstFromPreorder(int[] preorder) {

        AtomicInteger pIndex = new AtomicInteger(0);

      return insert(preorder,Integer.MIN_VALUE,Integer.MAX_VALUE ,pIndex);

    }

    //AtomicInteger is needed as we dont need to start from privios index we alwyas need to look forward that means it is like class it will alway give the latest value.
    static TreeNode insert(int[] arr, int min, int max, AtomicInteger index){

        if(index.get()==arr.length) return null;
        if (arr[index.get()] < min || arr[index.get()] > max) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index.get()]);
        index.getAndIncrement();

        root.left = insert(arr, min, root.val - 1, index);

        root.right = insert(arr,root.val+1,max,index);

        return root;
    }

    // this is not fruitfull as index is int and when recysive call back index value also go down so that we get backt to processed elements in the list
    static TreeNode insert(int[] arr, int min, int max, int index){

        if(index==arr.length) return null;
        if (arr[index] < min || arr[index] > max) {
            return null;
        }
        TreeNode root = new TreeNode(arr[index]);
        index++;

        root.left = insert(arr, min, root.val - 1, index);

        root.right = insert(arr,root.val+1,max,index);

        return root;
    }

    public static void main(String[] args) {
      int a[]={8,5,1,7,10,12};
        bstFromPreorder(a);
    }


}
