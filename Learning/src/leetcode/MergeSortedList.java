package leetcode;



public class MergeSortedList {

  public static class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
  public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

    ListNode node = new ListNode(-1);
    ListNode ans = node;

    while(l1!=null || l2!=null){

      if(l1!=null && l2!=null){

        if(l1.val < l2.val)
        {
          ans.next = new ListNode(l1.val);
          ans = ans.next;
          l1 = l1.next;
        }else{
          ans.next = new ListNode(l2.val);
          ans = ans.next;
          l2 = l2.next;
        }
      }else if(l1!=null)
      {
        ans.next = new ListNode(l1.val);
        ans = ans.next;
        l1 = l1.next;
      }else if(l2!=null){
        ans.next = new ListNode(l2.val);
        ans = ans.next;
        l2 = l2.next;
      }
    }

    return node.next;
  }

  public static void main(String[] args) {
    ListNode first = new ListNode(1,new ListNode(2,new ListNode(4)));
    ListNode second = new ListNode(1,new ListNode(2,new ListNode(4)));

    mergeTwoLists(first,second);
  }
}
