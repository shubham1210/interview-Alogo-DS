package BinaryTree;

import java.util.Arrays;
import java.util.List;

/**
 * Created by shubhamsharma on 4/6/2015.
 */
public class TreeNodeTest {
    private static final Integer[] SIMPLE_INPUT = {2, 1, 2, 7, 4, 9};
    private static final Integer[] SIMPLE_OUTPUT = {1, 2, 4, 7, 9};
    private static final Integer[] SIMPLE_INPUT2 = {10, 7, 12, 5, 6, 15,13,17,8,6,4,5};
    private static final Integer[] SIMPLE_OUTPUT2 = {4,5,6,7,8,10,12,13,15,17};
    private static final Integer[] ZERO_INPUT = {};


    public static void main(String[] a )
    {
        List<Integer> inputs = Arrays.asList(SIMPLE_INPUT);
        List<Integer> expectedOutputs = Arrays.asList(SIMPLE_OUTPUT);

        TreeSort treeSort = new TreeSort(inputs);
        List<Integer> outputs = treeSort.getSortedIntegers();
        System.out.println(outputs);
    }
}
