
public class MatrixMultiplication {

    public static void printMatrix(int[][] ansMatrix) {
        for (int[] row : ansMatrix) {
            for (int col : row) {
                System.out.print(col + "  ");
            }
            System.out.println();
        }
    }

    public static int[][] multiplicationMatrix(int[][] x, int[][] y) {
        int m = x.length;// for total rows in matrix 1
        int K = x[0].length;// for use column in 1 and rows in 2
        int s = y[0].length;// columns in 2

        int ans[][] = new int[m][s];//Storing answer

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < s; j++) {
                ans[i][j] = 0;
                for (int k = 0; k < K; k++) {
                    ans[i][j] += x[i][k] * y[k][j];
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] x = {
            {4, 5},
            {2, 6}
        };

        int[][] y = {
            {2, 1},
            {4, 2}
        };

        int[][] result = multiplicationMatrix(x, y);
        System.out.println("multiplication:");
        printMatrix(result);
    }
}
