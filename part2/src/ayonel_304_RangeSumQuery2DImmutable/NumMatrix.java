package ayonel_304_RangeSumQuery2DImmutable;



/**
 * @author ayonel
 * @create 2017-07-24 22:59
 * @blog https://ayonel.me
 * 解题思路：先用动归构造一个数组，该数组i,j位置表示从矩形的最左上角开始到i,j之间矩形的和
 * 然后求和的时候： 右下角+左上角(row1-1,col1-1)-右上角(row1-1,col2)-左下角(row2-1, col1);
 **/
public class NumMatrix {
    private int[][] sumMatrix;
    private boolean isNullMatrix = false;
    public NumMatrix(int[][] matrix) {
        isNullMatrix = false;
        int m = matrix.length;
        if (m == 0) {
            isNullMatrix = true;
            return;
        }
        int n = matrix[0].length;
        sumMatrix = new int[m][n];
        sumMatrix[0][0] = matrix[0][0];
        for (int i = 1; i < m; i++) {
            sumMatrix[i][0] = sumMatrix[i-1][0]+matrix[i][0];
        }
        for (int i = 1; i < n; i++) {
            sumMatrix[0][i] = sumMatrix[0][i-1]+matrix[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                sumMatrix[i][j] = sumMatrix[i-1][j]+sumMatrix[i][j-1]-sumMatrix[i-1][j-1]+matrix[i][j];
            }
        }

    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if (isNullMatrix) return 0;
        int rightDown = sumMatrix[row2][col2];
        int leftUp = (row1 == 0 || col1 == 0) ? 0 : sumMatrix[row1-1][col1-1];

        int rightUp =  (row1 == 0) ? 0 : sumMatrix[row1-1][col2];
        int leftDown =  (col1 == 0) ? 0 : sumMatrix[row2][col1-1];

        return rightDown-rightUp-leftDown+leftUp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,1,1},{2,2,2},{3,3,3}};
        NumMatrix numMatrix = new NumMatrix(matrix);
        int res = numMatrix.sumRegion(1,1,2,1);
        System.out.println();
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */