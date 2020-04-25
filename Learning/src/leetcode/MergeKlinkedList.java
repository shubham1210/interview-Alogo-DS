package leetcode;

import java.util.*;

public class MergeKlinkedList {
     public static class ListNode {
      int val;
      ListNode next;
    ListNode(int x) { val = x; }
  }

    public static ListNode mergeKListsSlow(ListNode[] lists) {
        List<Integer> list = new ArrayList<>();

        ListNode result = null;
        ListNode finalResult = result;
        int len = lists.length;

        if(len>=0)
        {
            int i=0;
            while(i<len)
            {
                ListNode n = lists[i++];
                while(n!=null)
                {
                    list.add(new Integer(n.val));n=n.next;
                }
            }
        }
        Collections.sort(list);
        Iterator<Integer> itr2 = list.iterator();
        while (itr2.hasNext())
        {
            if(result==null)
            {
                result =  new ListNode(itr2.next());
                finalResult = result;
            }else{
                result.next = new ListNode(itr2.next());
                result = result.next;
            }
        }

        return finalResult;
    }

    public static ListNode mergeKLists(ListNode[] lists) {
        Comparator<Integer> cmp;
        cmp = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1-o2;
            }
        };

        //List<Integer> list = new ArrayList<>();
        Queue<Integer> priorityQueue = new PriorityQueue<Integer>(cmp);

        ListNode result = null;
        ListNode finalResult = result;
        int len = lists.length;

        if(len>=0)
        {
            int i=0;
            while(i<len)
            {
                ListNode n = lists[i++];
                while(n!=null)
                {
                    priorityQueue.add(n.val);n=n.next;
                }
            }
        }
        while (!priorityQueue.isEmpty())
        {
            if(result==null)
            {
                result =  new ListNode(priorityQueue.poll());
                finalResult = result;
            }else{
                result.next =  new ListNode(priorityQueue.poll());
                result = result.next;
            }
        }

        return finalResult;
    }

    public static void main(String[] args) {
        /*ListNode  n1 = new ListNode(1);n1.next =  new ListNode(4);n1.next.next  =  new ListNode(5);
        ListNode  n2 = new ListNode(1);n2.next =  new ListNode(3);n2.next.next  =  new ListNode(4);
        ListNode  n3 = new ListNode(2);n3.next =  new ListNode(6);*/

        ListNode  n1 = new ListNode(-2);n1.next =  new ListNode(-1);n1.next.next  =  new ListNode(-1);n1.next.next.next  =  new ListNode(-1);
        ListNode  n2 =null;


        ListNode[] lists = new ListNode[2];
        lists[0]= n1;lists[1]= n2;

        mergeKLists(lists);
    }
}
