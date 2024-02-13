// package Tic-Tac-Toe Game;
import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        System.out.print("Enter the value of n : ");
        int n = read.nextInt();
        char[][] board = new char[n][n];
        
        // Taking input of the player names
        System.out.println("Enter the name of player 1");
        String p1 = read.next();
        System.out.println("Enter the name of player 2");
        String p2 = read.next();

        // Initializing the tic tac toe board with some values
        initializeBoard(board);
        displayBoard(board);
        
        boolean turn = true; // turn true for player 1 
        int count0fMoves = 0;
        char sym;
        while (true){
            while(true){
                if (turn){
                    System.out.println(p1 + ", please make your move --> ");
                }
                else {
                    System.out.println(p2 + ", please make your move --> ");
                }
                if (turn){
                    sym = 'X';
                }
                else {
                    sym = 'O';
                }
                System.out.print("Row Index Input : ");
                int r = read.nextInt();
                System.out.print("Column Index Input : ");
                int c = read.nextInt();

                // Check if the index input is valid
                if (!isValidInput(board, r, c)){
                    System.out.println("Invalid Move !");
                }
                else if (isCellOccupied(board, r, c)){
                    System.out.println("Sorry ! Your opponent has already made this move !");
                    System.out.println("Please input another valid input...");
                }
                else {
                    board[r][c] = sym;
                    count0fMoves++;
                    break;
                }
            }
            displayBoard(board);
            // Check for any winning conditions
            if (checkRowWinningCondition(board, sym)){
                if (turn){
                    System.out.println(p1 + " WINS : " + sym);
                }
                else {
                    System.out.println(p2 + " WINS : " + sym);
                }
                break;
            }
            else if (checkVerticalWinningCondition(board, sym)){
                if (turn){
                    System.out.println(p1 + " WINS : " + sym);
                }
                else {
                    System.out.println(p2 + " WINS : " + sym);
                }
                break;
            }
            else if (checkDiagonalSymmetry(board, sym)){
                if (turn){
                    System.out.println(p1 + " WINS : " + sym);
                }
                else {
                    System.out.println(p2 + " WINS : " + sym);
                }
                break;
            }
            else if (count0fMoves == n*n){
                System.err.println("GAME DRAW !");
                break;
            }
            turn = !turn;
        }
    }
    public static void initializeBoard(char[][] matrix){
        int n = matrix.length;
        for (int j=0; j<n; j++ ){
            for (int k=0; k<n; k++ ){
                matrix[j][k] = '-';
            }
        }
    }
    public static void displayBoard(char[][] matrix){
        int size = matrix.length;
        for (int j=0; j<size; j++ ){
            for (int k=0; k<size; k++ ){
                System.out.print(matrix[j][k] + " ");
            }
            System.out.println();
        }
    }
    public static boolean isValidInput(char[][] matrix, int r, int c){
        int n = matrix.length;
        if (r < 0 || r >= n){
            return false;
        }
        if (c < 0 || c >= n){
            return false;
        }
        return true;
    }
    public static boolean isCellOccupied(char[][] matrix, int r, int c){
        if (matrix[r][c] == '-'){
            return false;
        }
        return true;
    }
    public static boolean checkRowWinningCondition(char[][] matrix, char target){
        for (int j=0; j<matrix.length; j++ ){
            boolean check = true;
            for (int k=0; k<matrix[0].length; k++ ){
                if (matrix[j][k] != target){
                    check = false;
                    break;
                }
            }
            if (check){
                return true;
            }
        }
        return false;
    }
    public static boolean checkVerticalWinningCondition(char[][] matrix, char target){
        for (int j=0; j<matrix.length; j++ ){
            boolean check = true;
            for (int k=0; k<matrix[0].length; k++ ){
                if (matrix[k][j] != target){
                    check = false;
                    break;
                }
            }
            if (check){
                return true;
            }
        }
        return false;
    }
    public static boolean checkDiagonalSymmetry(char[][] matrix, char target){
        int n = matrix.length;
        int j = 0;
        int k = 0;
        boolean temp = true;
        while (j < n && k < n){
            if (matrix[j][k] != target){
                temp = false;
                break;
            }
            j++;
            k++;
        }
        if (temp){
            return true;
        }
        j = 0;
        k = (n-1);
        temp  = true;
        while (j < n && k >= 0){
            if (matrix[j][k] != target){
                temp = false;
                break;
            }
            j++;
            k--;
        }
        if (temp){
            return true;
        }
        return false;
    }
}
