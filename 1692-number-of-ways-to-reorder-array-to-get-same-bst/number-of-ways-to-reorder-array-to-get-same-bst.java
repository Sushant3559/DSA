
import java.util.*;

class Solution {
    static final int MOD = 1_000_000_007;
    long[][] comb;

    public int numOfWays(int[] nums) {
        int n = nums.length;
        comb = new long[n + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            comb[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                if (j == i) {
                    comb[i][j] = 1;
                } else {
                    comb[i][j] =
                        (comb[i - 1][j - 1] + comb[i - 1][j]) % MOD;
                }
            }
        }

        return (int) ((solve(nums) - 1 + MOD) % MOD);
    }

    private long solve(int[] nums) {
        int n = nums.length;
        if (n <= 2) return 1;

        List<Integer> left = new ArrayList<>();
        List<Integer> right = new ArrayList<>();

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[0]) {
                left.add(nums[i]);
            } else {
                right.add(nums[i]);
            }
        }

        int[] l = new int[left.size()];
        int[] r = new int[right.size()];

        for (int i = 0; i < left.size(); i++)
            l[i] = left.get(i);

        for (int i = 0; i < right.size(); i++)
            r[i] = right.get(i);

        long ways = comb[n - 1][left.size()];
        ways = ways * solve(l) % MOD;
        ways = ways * solve(r) % MOD;

        return ways;
    }
}
