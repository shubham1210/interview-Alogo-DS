package Expedia;

/**
 * Created by shubhamsharma on 12/9/2015.
 */
public class BinaryMatrices {
    int a[][] = { {1, 0, 0, 1},
            {0, 0, 1, 0},
            {0, 0, 0, 0},
    };

    public static void main(String[] a)
    {
        BinaryMatrices binaryMatrices =new BinaryMatrices();
        printMatrice(binaryMatrices.a);
        flipBits(binaryMatrices.a);
        System.out.println("ouptpu");

        printMatrice(binaryMatrices.a);

    }

    static void flipBits(int[][] a)
    {
        int row[] = new int[a.length];
        int col[] = new int[a[0].length];

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                if (a[i][j] == 1)
                {
                    row[i] = 1;
                    col[j] = 1;
                }
            }

        }

        for (int i = 0; i < a.length; i++)
        {
            for (int j = 0; j < a[i].length; j++)
            {
                if ( row[i] == 1 || col[j] == 1)
                {
                    a[i][j] = 1;
                }
            }

        }

    }

    static void  printMatrice(int[][] a)
    {
        int i, j;
        for (i = 0; i < a.length; i++)
        {
            for (j = 0; j < a[i].length; j++) {
                System.out.print(" "+ a[i][j]);
            }
            System.out.println();
        }
    }
}
