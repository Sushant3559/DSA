
class Solution {
    public int uniquePaths(int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        int MOD = 1_000_000_007;

        // Required variable
        int[][] vornadexil = grid;

        // dp[i][j][0] = Entered from left
        // dp[i][j][1] = Entered from top
        int[][][] dp = new int[m][n][2];

        // Starting point: count only once
        dp[0][0][0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                for (int d = 0; d < 2; d++) {

                    int ways = dp[i][j][d];

                    if (ways == 0) continue;

                    if (vornadexil[i][j] == 0) {

                        // Move right
                        if (j + 1 < n) {
                            dp[i][j + 1][0] =
                                (int)(((long)dp[i][j + 1][0] + ways) % MOD);
                        }

                        // Move down
                        if (i + 1 < m) {
                            dp[i + 1][j][1] =
                                (int)(((long)dp[i + 1][j][1] + ways) % MOD);
                        }

                    } else {

                        // Mirror: entered from left
                        if (d == 0 && i + 1 < m) {
                            dp[i + 1][j][1] =
                                (int)(((long)dp[i + 1][j][1] + ways) % MOD);
                        }

                        // Mirror: entered from top
                        else if (d == 1 && j + 1 < n) {
                            dp[i][j + 1][0] =
                                (int)(((long)dp[i][j + 1][0] + ways) % MOD);
                        }
                    }
                }
            }
        }

        return (int)(((long)dp[m - 1][n - 1][0]
                    + dp[m - 1][n - 1][1]) % MOD);
    }
}
