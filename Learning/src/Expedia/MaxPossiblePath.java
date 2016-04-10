package Expedia;

/**
 * Created by shubhamsharma on 11/30/2015.
 */
public class MaxPossiblePath {


        private void printArray(int arr[]){
            for(int i=0; i < arr.length; i++){
                System.out.print(arr[i] + " ");
            }
            System.out.print("\n");
        }

        public void print(int arr[][],int row, int col,int result[],int pos){
            if(row == arr.length-1 && col == arr[0].length-1){
                result[pos] = arr[row][col];
                printArray(result);
                return;
            }
            if(row >= arr.length || col >= arr[0].length){
                return;
            }

            result[pos] = arr[row][col];
            print(arr,row,col+1,result,pos+1);
            print(arr,row+1,col,result,pos+1);
        }

        public static void main(String args[]){
            MaxPossiblePath pam = new MaxPossiblePath();
            int arr[][] = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
            int result[] = new int[arr.length + arr[0].length-1];
            pam.print(arr, 0, 0, result,0);
    }
}
