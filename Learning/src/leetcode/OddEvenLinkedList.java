package leetcode;

public class OddEvenLinkedList {
    
      static public class ListNode {
          int val;
          ListNode next;
          ListNode() {}
          ListNode(int val) { this.val = val; }
          ListNode(int val, ListNode next) { this.val = val; this.next = next; }
      }

    public ListNode oddEvenList(ListNode head) {
          if(head==null || head.next==null) return head;
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenLink = head.next;
        while(odd!=null && odd.next!=null)
        {
            odd.next  = odd.next.next;
            if(odd.next!=null)
                odd = odd.next;
            if(even.next!=null)
            {
                even.next =  even.next.next;
                even = even.next;
            }
        }

        odd.next = evenLink;

        return head;
    }
    public static void main(String[] args) {
        ListNode root = new ListNode(1,new ListNode(2,new ListNode(3,new ListNode(4,new ListNode(5)))));
        OddEvenLinkedList  oddEvenLinkedList = new OddEvenLinkedList();
        oddEvenLinkedList.oddEvenList(root);
    }
}
