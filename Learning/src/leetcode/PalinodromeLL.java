package leetcode;

public class PalinodromeLL {

    static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val =val;
        }
    }

    public static boolean isPalindrome(ListNode head) {

        if(head == null || head.next==null)
            return true;

        //find list center
        ListNode fast = head;
        ListNode slow = head;

        while(fast.next!=null && fast.next.next!=null){
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode secondHead = slow.next;
        slow.next = null;

        //reverse second part of the list
        ListNode p1 = null;
        ListNode p2 = secondHead;

        while(p2!=null){
            ListNode temp = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = temp;
        }


        //compare two sublists now
        ListNode p = (p2==null?p1:p2);
        ListNode q = head;
        while(p!=null){
            if(p.val != q.val)
                return false;

            p = p.next;
            q = q.next;

        }

        return true;
    }
    public static void main(String[] args){
        ListNode node  = new ListNode(1);
        node.next = new ListNode(2);
       /* node.next.next = new ListNode('a');
        node.next.next.next = new ListNode('c');
        node.next.next.next.next = new ListNode('a');
        node.next.next.next.next.next = new ListNode('b');
        node.next.next.next.next.next.next = new ListNode('a');*/


        System.out.println("is Palindorme :- "+
                isPalindrome(node));
    }
}
