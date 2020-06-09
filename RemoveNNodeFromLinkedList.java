package leetcode;
/*https://leetcode.com/problems/remove-nth-node-from-end-of-list/
* */
public class RemoveNNodeFromLinkedList {
    
      public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
   }
    
    public static ListNode removeNthFromEnd(ListNode head, int n) {


        ListNode wrapperNode =  new ListNode(-1,head);
        ListNode fast = wrapperNode;
        ListNode slow =wrapperNode;
        int fastSpeed=n+1;
        while(fastSpeed!=0 && fast!=null)
        {
            fast = fast.next;
            fastSpeed--;
        }
        while(fast!=null){
            slow= slow.next;
            fast = fast.next;
        }
        //just because we have made 1 node extra at start and we also move 1 node extra for fast thats why slow will never be at last item
        slow.next=slow.next.next;

        return wrapperNode.next;
    }



    public static void main(String[] args) {
        ListNode root = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        //ListNode root = new ListNode(1);
        removeNthFromEnd(root,1);
        while(root!=null)
        {
            System.out.print(root.val+" ");
            root = root.next;
        }

    }
}
