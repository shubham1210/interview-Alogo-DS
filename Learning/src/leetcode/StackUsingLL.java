package leetcode;

/**
 * Created by shubhamsharma on 2020-03-11.
 */
public class StackUsingLL {


    // A linked list node
    private class Node {

        int data; // integer data
        Node link; // reference variavle Node type
    }
    // create globle top reference variable
    Node top;
    // Constructor
    StackUsingLL()
    {
        this.top = null;
    }

    public void push(int x)
    {
        Node temp = new Node();
        temp.data =x;
        temp.link =top;
        top = temp;
    }

    public void pop()
    {
        if (top==null)
        {
            System.out.print("\nStack Underflow");
            return;
        }

        top = top.link;
    }

    public int peek()
    {
        if (top==null)
        {
            System.out.print("\nStack Underflow");
            return -1;
        }

        return top.data;
    }

    public void display()
    {
        // check for stack underflow
        if (top == null) {
            System.out.printf("\nStack Underflow");
            return;
        }
        else {
            Node temp = top;
            while (temp != null) {

                // print node data
                System.out.printf("%d->", temp.data);

                // assign temp link to temp
                temp = temp.link;
            }
        }
    }

    public static void main(String[] args)
    {
        // create Object of Implementing class
        StackUsingLL obj = new StackUsingLL();
        // insert Stack value
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);

        // print Stack elements
        obj.display();

        // pritn Top element of Stack
        System.out.printf("\nTop element is %d\n", obj.peek());

        // Delete top element of Stack
        obj.pop();
        obj.pop();

        // pritn Stack elements
        obj.display();

        // print Top element of Stack
        System.out.printf("\nTop element is %d\n", obj.peek());
    }
}
