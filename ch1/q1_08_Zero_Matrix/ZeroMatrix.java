package ch1.q1_08_Zero_Matrix;

import java.util.Arrays;

public class ZeroMatrix {

  public static void print2D(int mat[][]) { 
    // Loop through all rows 
    for (int i = 0; i < mat.length; i++) {
      // Loop through all elements of current row 
      for (int j = 0; j < mat[i].length; j++) 
      System.out.print(mat[i][j] + " ");

      System.out.println("");
    }
  }

  public static int[][] nullifyRow(int row, int[][] matrix) {
    for (int j = 0; j < matrix[row].length; j++) {
      matrix[row][j] = 0;
    }
    return matrix;
  }

  public static int[][] nullifyCol(int col, int[][] matrix) {
    for (int i = 0; i < matrix.length; i++ ) {
      matrix[i][col]= 0;
    }
    return matrix;
  }

  public static int[][] zeroMatrix(int[][] matrix) {
    boolean[] rowZeros = new boolean[matrix.length];
    boolean[] columnZeros = new boolean[matrix[0].length];

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          rowZeros[i] = true;
          columnZeros[j] = true;
        }
      }
    }

    for (int i = 0; i < matrix.length; i++) {
      if (rowZeros[i]) matrix = nullifyRow(i, matrix);
      if (columnZeros[i]) matrix = nullifyCol(i, matrix);
    }

    return matrix;
  }

  public static void main(String[] args) {
    int[][] matrix1 = {
      {1, 1, 1, 0},
      {0, 1, 1, 1},
      {1, 1, 1, 1},
      {1, 1, 1, 1}
    };

    int[][] zeroedmatrix1 = {
      {0, 0, 0, 0},
      {0, 0, 0, 0},
      {0, 1, 1, 0},
      {0, 1, 1, 0}
    };

    int[][] result1 = zeroMatrix(matrix1);
    
    boolean match = Arrays.deepEquals(zeroedmatrix1, result1);
    // System.out.println(zeroedmatrix1.equals(zeroedmatrix1));

    print2D(result1);
    System.out.println(
      "match?: " + match
    );

  }
}