package leetcode;

import java.util.HashSet;

/**
 * Created by shubhamsharma on 2020-06-14.
 * https://leetcode.com/problems/valid-sudoku/
 */
public class ValidSuduko {

    public static boolean isValidSudokuSlow(char[][] board) {

        HashSet<String> set = new HashSet<String>();
        for(int i=0;i<9; i++){
            for(int j=0;j<9; j++){
                if(board[i][j]=='.') continue;
                if(set.add(board[i][j]+"-row-"+i) ==false
                        || set.add(board[i][j]+"-col-"+j) == false
                        || set.add(board[i][j]+"-block-"+ i/3 +" - " + j/3) == false)
                    return false;

            }

        }
        return true;

    }

    /*
    what i have missed in initial the size of matrix is alawys 9 that means complexity will alwyas be constnat for all test cases almost.
    so we can go for loop iterations because size is not going up.
    */
    public static boolean isValidSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return true;
        }
        // only col iterations.
        for (int i = 0; i < 9; i++) {
            boolean[] used = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (used[board[i][j] - '1']) { // this will place '3' char at 3 index.
                        return false;
                    }
                    used[board[i][j] - '1'] = true;
                }
            }
        }
        // only row iterations.
        for (int i = 0; i < 9; i++) {
            boolean[] used = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[j][i] != '.') { // board[j][i] this is for row iterations.
                    if (used[board[j][i] - '1']) {
                        return false;
                    }
                    used[board[j][i] - '1'] = true;
                }
            }
        }

        //block iterations.
        for (int i = 0; i < 9; i = i + 3) {
            for (int j = 0; j < 9; j = j + 3) {

                boolean[] used = new boolean[9];
                for (int k = i; k < i + 3; k++) { // row for block
                    for (int l = j; l < j + 3; l++) { // col for block

                        if (board[k][l] != '.') {
                            if (used[board[k][l] - '1']) {
                                return false;
                            }
                            used[board[k][l] - '1'] = true;
                        }

                    }
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
         char[][] suduko = {{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};


        System.out.println(isValidSudoku(suduko));

    }
}
