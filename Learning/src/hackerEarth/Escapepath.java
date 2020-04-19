package hackerEarth;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * INPUT
 * 1
 * 1 2
 * 8
 * ########
 * OUTPUT 3
 */
public class Escapepath {
    public static void main(String args[]) throws Exception {


        //BufferedReader
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int noOfTestCases = Integer.parseInt(br.readLine());                // Reading input from STDIN
        String r1r2 = br.readLine();
        String[] r1r2Arr = r1r2.split(" ");

        int r1 = Integer.parseInt(r1r2Arr[0]);
        int r2 = Integer.parseInt(r1r2Arr[1]);
        int sizeOfCells = Integer.parseInt(br.readLine());
        String cellsOcu = br.readLine();


        // Write your code here
        float ratio = (float) r1 / r2;

        int i = 1;
        int totalPrime = 0;
        int moves = 0;
        while (i <= sizeOfCells) {
            totalPrime =primeCount(i);
            float A = (float) totalPrime / i;
            if (A >= ratio && totalPrime > 2 && i + totalPrime - 1 < cellsOcu.length() && cellsOcu.charAt(i + totalPrime - 1) != '*') {
                i = i + totalPrime;
                moves ++;
            } else if (i + 2 - 1 < cellsOcu.length() && cellsOcu.charAt(i + 2 - 1) != '*') {
                i += 2;
                moves ++;
            } else if (i + 1 - 1 < cellsOcu.length() && cellsOcu.charAt(i + 1 - 1) != '*') {
                i++;
                moves += 1;
            } else {
                break;
            }

        }

        if (i < sizeOfCells) {
            System.out.println("No Way!");
        } else
            System.out.println(moves);


    }

    static int primeCount(int n) {

        if(n<2) return 0;
        int count =0;boolean isPrime =true;
        while (n>=2){
            for (int i = 2; i < n; i++) {
                if (n % i == 0) {
                    isPrime= false;
                    break;
                }
            }
            if(isPrime)count++;
            isPrime=true;
            n--;
        }
        return count;
    }

}
