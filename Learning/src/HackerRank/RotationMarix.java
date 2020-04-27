package HackerRank;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;


/**
 * Created by shubhamsharma on 2020-02-03.
 */
public class RotationMarix {


    // Complete the matrixRotation function below.
    static void matrixRotation(List<List<Integer>> matrix, int r) {


        while (r > 0) {
            int row = matrix.size()-1;
            int col = matrix.get(0).size()-1;
            int i = 0;
            int j = 0;
            while (row >= 1 || col >= 1) {
                rotation(i, j, row, col, matrix);
                row = row - 1;
                col = col - 1;
                i++;
                j++;
            }
            r--;

        }

        printarray(matrix);

    }


    static  void printarray(List<List<Integer>> matrix)
    {
        for (int i2 = 0; i2 < matrix.size(); ++i2) {
            for (int j2 = 0; j2 < matrix.get(i2).size(); j2++)
                System.out.print(matrix.get(i2).get(j2) + " ");

            System.out.println("");
        }
    }


    static void rotation(int i, int j, int row, int col, List<List<Integer>> matrix) {
        int prev = -1;
        int curr = -1;
        int i1 = i;
        int j1 = j;
        System.out.println("first = i1 = "+i1 + " first j1 = "+j1);
        prev = matrix.get(i1).get(j1);

        for (; i1 < row - 1; i1++) {
            curr = matrix.get(i1+1).get(0);
            matrix.get(i1 + 1).set(0, prev);
            prev =curr;

        }
        i1=row;
        System.out.println("after row 1 i1 = "+i1 + "  j1 = "+j1);
        prev =  matrix.get(i1).get(0);
        matrix.get(i1).set(j1,curr);
        printarray(matrix);

        List<Integer> toWorkOn = matrix.get(i1);
        for (; j1 < col - 1; j1++) {
            curr = toWorkOn.get(j1+1);
            toWorkOn.set(j1 + 1, prev);
            prev =curr;

        }
        j1 =col;
        System.out.println("after col movement 2 i1 = "+i1 + "  j1 = "+j1);

        prev =  matrix.get(i1).get(j1);
        matrix.get(i1).set(j1,curr);
        printarray(matrix);

        for (; i1 > 1; i1--) {
            curr = matrix.get(i1-1).get(j1);
            matrix.get(i1 - 1).set(j1,prev);
            prev =curr;

        }
        i1=i;

        System.out.println("after row movement 3 i1 = "+i1 + "  j1 = "+j1);


        prev =  matrix.get(i1).get(j1);
        matrix.get(i1).set(j1,curr);
        printarray(matrix);

        toWorkOn = matrix.get(i1);
        for (; j1 > 0; j1--) {
            //temp = toWorkOn.get(j1-1);
            curr = toWorkOn.get(j1-1);

            toWorkOn.set(j1 - 1, prev);
            prev =curr;

        }
        System.out.println("after col movement 4 i1 = "+i1 + "  j1 = "+j1);
        printarray(matrix);


    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] mnr = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int m = Integer.parseInt(mnr[0]);

        int n = Integer.parseInt(mnr[1]);

        int r = Integer.parseInt(mnr[2]);

        List<List<Integer>> matrix = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            String[] matrixRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> matrixRowItems = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int matrixItem = Integer.parseInt(matrixRowTempItems[j]);
                matrixRowItems.add(matrixItem);
            }

            matrix.add(matrixRowItems);
        }

        matrixRotation(matrix, r);

        bufferedReader.close();
    }
}


