package linkedList;

import java.util.Hashtable;

/**
 * Created by shubhamsharma on 4/6/2015.
 */
public class LinkedList {
    Node head;

    public void appendTOLast(Node addNode)
    {
        Node node = this.head;

        while ( node.next!=null)
        {
            node = node.next;
        }
        node.next =addNode;
    }
    public void appendTOLast(int data)
    {
        Node node = this.head;

        while ( node.next!=null)
        {
            node = node.next;
        }
        node.next = new Node(data);
    }
    public LinkedList(int data) {
        this.head = new Node(data);
    }

    public String toString()
    {
        Node node = this.head;
        StringBuffer sb = new StringBuffer();
        while (node!=null)
        {
            sb.append(node.data+" --> ");
            node = node.next;
        }
        return sb.toString();
    }

    public boolean removeElement(int element)
    {
        Node node = this.head;
        if(node.data == element)this.head = this.head.next;
        while (node.next!=null)
        {
            if(node.next.data == element)
            {
                node.next = node.next.next;
                return true;
            }
            node = node.next;
        }

        return false;
    }

    public void removeDuplicateElement()
    {
        Hashtable hashtable = new Hashtable();
        Node node = this.head;
        Node previous = null;

        while(node!=null)
        {
            if(hashtable.containsKey(node.data))
            {
                previous.next = node.next;
            }else
            {
                hashtable.put(node.data,true);
                previous = node;
            }
            node = node.next;
        }

    }

    public int findNElementFromLast(int n)
    {
        Node fast = this.head;
        Node slow = this.head;
        int i=0;
        while(fast!=null)
        {

            if(i%n == 0)
                slow = slow.next;
            fast = fast.getNext();
            i++;
        }
        if(i<n)
            return -1;
        else
            return slow.data;
    }
    public int size()
    {
        int count=0;
        Node n =this.head;
        while (n!=null)
        {
            count++;
            n= n.getNext();
        }
        return count;
    }

    public LinkedList sumList(LinkedList l2)
    {
        Node firstHead = this.head;
        Node secondHead = l2.head;
        LinkedList finalSumList=null;
        int sum =0;
        while (firstHead!=null || secondHead!=null)
        {
            sum+=firstHead.data;
            sum+= secondHead.data;
            if(null == finalSumList)
            {
                finalSumList = new LinkedList(sum%10);
            }else
                finalSumList.appendTOLast(sum%10);
            sum/=10;
            firstHead = firstHead.getNext();
            secondHead = secondHead.getNext();
        }
        return finalSumList;
    }

    public boolean isCyclic()
    {
        Node fast = this.head.next;
        Node slow = this.head;
        while (fast.next!=null)
        {
            slow =slow.next;
            fast =fast.next.next;
            if(fast == slow)return true;
        }
        return false;
    }
    public static void main(String[] a)
    {
        LinkedList list = new LinkedList(0);
        Node  node =new Node(10);

        list.appendTOLast(node);
        list.appendTOLast(20);
        list.appendTOLast(40);
        //list.appendTOLast(node);
        //list.appendTOLast(80);
        System.out.println(list.isCyclic());
        System.out.println(list);
        list.removeDuplicateElement();
        System.out.println(list);
        System.out.println(list.findNElementFromLast(list.size()/2));
        LinkedList first = new LinkedList(3);
        first.appendTOLast(1);first.appendTOLast(5);
        LinkedList second = new LinkedList(5);
        second.appendTOLast(9);second.appendTOLast(2);
        System.out.println(first);
        System.out.println(second);

        System.out.println(first.sumList(second));

        System.out.println(list.isCyclic());


    }
}

class Node{

    Node next;
    int data;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}