/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;

class MatrixMismatchException extends Exception {
    public MatrixMismatchException(String message) {
        super(message);
    }
}

public class Problem2_MatrixMultiplication {

    public static int[][] multiplyMatrices(int[][] A, int[][] B)
            throws MatrixMismatchException {

        int rowsA = A.length;
        int colsA = A[0].length;
        int rowsB = B.length;
        int colsB = B[0].length;

        
        if (colsA != rowsB) {
            throw new MatrixMismatchException(
                "Matrix multiplication not possible: columns of Matrix A ("
                + colsA + ") must equal rows of Matrix B (" + rowsB + ")."
            );
        }

        
        int[][] result = new int[rowsA][colsB];

        
        for (int i = 0; i < rowsA; i++) {
            for (int j = 0; j < colsB; j++) {
                for (int k = 0; k < colsA; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        try {
            System.out.print("Enter rows and cols for Matrix A: ");
            int rA = sc.nextInt();
            int cA = sc.nextInt();

            int[][] A = new int[rA][cA];

            System.out.println("Enter elements of Matrix A:");
            for (int i = 0; i < rA; i++) {
                for (int j = 0; j < cA; j++) {
                    A[i][j] = sc.nextInt();
                }
            }

            System.out.print("Enter rows and cols for Matrix B: ");
            int rB = sc.nextInt();
            int cB = sc.nextInt();

            int[][] B = new int[rB][cB];

            System.out.println("Enter elements of Matrix B:");
            for (int i = 0; i < rB; i++) {
                for (int j = 0; j < cB; j++) {
                    B[i][j] = sc.nextInt();
                }
            }

            int[][] result = multiplyMatrices(A, B);

            System.out.println("Resulting Matrix:");
            for (int[] row : result) {
                System.out.println(Arrays.toString(row));
            }

        } catch (MatrixMismatchException e) {
            System.out.println("Error: " + e.getMessage());

        } finally {
            sc.close();
        }
    }
}
