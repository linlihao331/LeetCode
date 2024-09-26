class Solution {
    public int uniquePaths(int m, int n) {
    //你需要将矩阵的第一行和第一列全部初始化为 1，因为在第一行和第一列中，到达任何一个单元格的唯一方式只有一种，要么一直向右走（对于第一行），要么一直向下走（对于第一列）。
        int[][] map = new int[m][n];

        for(int i = 0; i < m; i++){
            map[i][0] = 1;
        }
        for(int i = 0; i < n; i++){
            map[0][i] = 1;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                map[i][j] = map[i-1][j]+map[i][j-1];
            }
        }
        return map[m-1][n-1];

    }
}
