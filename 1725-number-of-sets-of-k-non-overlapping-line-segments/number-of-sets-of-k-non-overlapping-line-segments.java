class Solution {
    public int numberOfSets(int n, int k) {
        int MOD = 1_000_000_007;

        long[][] dp = new long[n][k + 1];
        long[][] prefix = new long[n][k + 1];

        // 0 segments banane ka 1 way
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
            prefix[i][0] = i + 1;
        }

        for (int i = 1; i < n; i++) {

            for (int j = 1; j <= k; j++) {

                // Previous point tak ke ways
                dp[i][j] = dp[i - 1][j];

                // New segment create/extend karna
                dp[i][j] += prefix[i - 1][j - 1];

                dp[i][j] %= MOD;

                // Prefix sum
                prefix[i][j] = prefix[i - 1][j] + dp[i][j];
                prefix[i][j] %= MOD;
            }
        }

        return (int) dp[n - 1][k];
    }
}