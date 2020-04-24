package ch1.q1_07_Rotate_Matrix;

public class RotateMatrix {


  public static void print2D(int mat[][]) { 
    // Loop through all rows 
    for (int i = 0; i < mat.length; i++) {
      // Loop through all elements of current row 
      for (int j = 0; j < mat[i].length; j++) 
      System.out.print(mat[i][j] + " ");

      System.out.println("");
    }
  }

  public static int[][] swapCords(int[][] matrix, int x, int y) {
    int temp = matrix[x][y];

    matrix[x][y] = matrix[y][matrix.length - 1 - x];
    System.out.println(x + ", " + y + " swapped to: " + y + ", " + (matrix.length - 1 - x) );
    matrix[y][matrix.length - x - 1] = temp;
    return matrix;
  }

  public static int[] next90(int[] coords, int length) {
    int[] newCoords = {coords[1], length - 1 - coords[0]};
    System.out.println("returns: " + newCoords[0] + ", " + newCoords[1]);
    return newCoords;
  }

  public static int[][] rotate(int[][] matrix) {
    for (int i = 0; i < matrix.length; i++) {
      for (int j = i; j < matrix.length - i - 1; j++) {
        // System.out.println(matrix[i][j]);
        // System.out.println(i + ", " + j);
        matrix = swapCords(matrix, i, j);
        int[] firstCoord = {i, j};
        int[] secondCoord = next90(firstCoord, matrix.length);
        int[] thirdCoord = next90(secondCoord, matrix.length);
        int[] fourthCoord = next90(thirdCoord, matrix.length);

        // System.out.println("-----------");
        // System.out.println(firstCoord);
        // System.out.println(secondCoord);
        // System.out.println(thirdCoord);

        matrix = swapCords(matrix, fourthCoord[0], fourthCoord[1]);
        matrix = swapCords(matrix, thirdCoord[0], thirdCoord[1]);
        print2D(matrix);
      }
    }
    return matrix;
  }

  public static void main(String[] args) {
    int[][] original = {
      {1, 2, 3},
      {4, 5, 6},
      {7, 8, 9}
    };

    print2D(original);
    int[][] rotatedMatrix = rotate(original);
    print2D(rotatedMatrix);
  }
}