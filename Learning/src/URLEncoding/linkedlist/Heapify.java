package URLEncoding.linkedlist;

import java.io.*;

import java.util.*;

public class Heapify {


    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        int noOfTestCases = scan.nextInt();

        Integer arrHeap[] = new Integer[noOfTestCases + 1];

        int last = 0;

        for (int i = 0; i <= noOfTestCases; i++)

        {

            String input = scan.nextLine();

            if (input.trim().equals("")) continue;

            String inputString[] = input.split(" ");

            int operation = Integer.parseInt(inputString[0]);

            switch (operation) {
                case 1: {
                    long startTime = System.currentTimeMillis();

                    arrHeap[last] = Integer.parseInt(inputString[1]);
                    if(arrHeap[last]==-981246)
                    {
                        boolean k =true;
                    }
                    last++;
                    heapify(arrHeap, last, last - 1);

                    /*for(int i1=0;i1<arrHeap.length;i1++)
                    {
                        System.out.print(arrHeap[i1]+" ");
                    }
                    System.out.println();*/
                    System.out.println("Time taken in saving");
                    System.out.println(System.currentTimeMillis()-startTime);
                }
                break;
                case 2: {
                    long startTime = System.currentTimeMillis();

                    List<Integer> list = new ArrayList<Integer>();
                    list.addAll(Arrays.asList(arrHeap));
                    int pos = list.indexOf(Integer.parseInt(inputString[1]));
                    list.remove(pos);
                    //System.out.println(list);
                    //arrHeap = list.toArray();
                    int j = 0;
                    for (Object o : list.toArray()) {
                        Integer s = (Integer) o;
                        arrHeap[j] = s;
                        j++;
                    }

                    last--;

                    heapifyDel(arrHeap, last, 0);
                    /*for(int i1=0;i1<arrHeap.length;i1++)
                    {
                        System.out.print(arrHeap[i1]+" ");
                    }
                    System.out.println();*/
                    System.out.println("Time taken in del");
                    System.out.println(System.currentTimeMillis()-startTime);

                }
                break;
                case 3: {
                    if (last > 0) {
                        System.out.println(arrHeap[0]);
                    }
                }
                break;
            }
        }
    }


    static void heapifyDel(Integer arr[], int n, int i)

    {
        int smallest = i; // Initialize smallest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < n && arr[l] < arr[smallest])
            smallest = l;
        // If right child is larger than smallest so far
        if (r < n && arr[r] < arr[smallest])
            smallest = r;
        // If smallest is not root

        if (smallest != i) {

            int swap = arr[i];
            arr[i] = arr[smallest];
            arr[smallest] = swap;
            // Recursively heapify the affected sub-tree
            heapify(arr, n, smallest);
        }
    }

    static void heapify(Integer[] arr, int size, int nodePosition)

    {
        int parent = (nodePosition - 1) / 2;
            if (arr[nodePosition] < arr[parent]) {
                int temp = arr[parent];
                arr[parent] = arr[nodePosition];
                arr[nodePosition] = temp;
                heapify(arr, size, parent);

        }
    }


}



