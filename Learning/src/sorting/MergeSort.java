package sorting;

/**
 * Created by shubhamsharma on 4/6/2015.
 */
public class MergeSort {
    private int[] finalSortedArray;
    private int[] helperInputArray;
    private int lengthOfInputArray;

    public void sort(int[] values) {
        this.finalSortedArray = values;
        lengthOfInputArray = values.length;
        this.helperInputArray = new int[lengthOfInputArray];
        mergesort(0, lengthOfInputArray - 1);
    }

    private void mergesort(int low, int high) {
        // check if low is smaller then high, if not then the array is sorted
        // breaking condition in recursion
        if (low < high) {
            // Get the index of the element which is in the middle
            int middle = low + (high - low) / 2;
            // Sort the left side of the array
            mergesort(low, middle);
            // Sort the right side of the array
            mergesort(middle + 1, high);
            // Combine them both
            merge(low, middle, high);
        }
    }

    private void merge(int low, int middle, int high) {

        // Copy both parts into the helperInputArray array
        for (int i = low; i <= high; i++) {
            helperInputArray[i] = finalSortedArray[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;
        // Copy the smallest values from either the left or the right side back
        // to the original array
        while (i <= middle && j <= high) {
            if (helperInputArray[i] <= helperInputArray[j]) {
                finalSortedArray[k] = helperInputArray[i];
                i++;
            } else {
                finalSortedArray[k] = helperInputArray[j];
                j++;
            }
            k++;
        }
        // Copy the rest of the left side of the array into the target array
        while (i <= middle) {
            finalSortedArray[k] = helperInputArray[i];
            k++;
            i++;
        }
        while (j <= high) {
            finalSortedArray[k] = helperInputArray[j];
            k++;
            j++;
        }

    }

    public static void main(String[] a)
    {
        int[] input ={12,-5,22,32,0,4,66};
        MergeSort m = new MergeSort();
        m.sort(input);
        for(int i=0;i<m.finalSortedArray.length;i++)
        {
            System.out.print(m.finalSortedArray[i] + " ");
        }
    }
}

