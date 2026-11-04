
import java.util.*;

class Solution {

    TreeMap<Integer, Integer> left = new TreeMap<>();
    TreeMap<Integer, Integer> right = new TreeMap<>();

    int leftSize = 0, rightSize = 0;
    long leftSum = 0, rightSum = 0;

    void addLeft(int v) {
        left.put(v, left.getOrDefault(v, 0) + 1);
        leftSize++;
        leftSum += v;
    }

    void addRight(int v) {
        right.put(v, right.getOrDefault(v, 0) + 1);
        rightSize++;
        rightSum += v;
    }

    void removeLeft(int v) {
        int c = left.get(v);
        if (c == 1) left.remove(v);
        else left.put(v, c - 1);

        leftSize--;
        leftSum -= v;
    }

    void removeRight(int v) {
        int c = right.get(v);
        if (c == 1) right.remove(v);
        else right.put(v, c - 1);

        rightSize--;
        rightSum -= v;
    }

    void add(int v) {
        if (left.isEmpty() || v <= left.lastKey())
            addLeft(v);
        else
            addRight(v);

        balance();
    }

    void remove(int v) {
        if (left.containsKey(v))
            removeLeft(v);
        else
            removeRight(v);

        balance();
    }

    void balance() {
        while (leftSize > rightSize + 1) {
            int v = left.lastKey();
            removeLeft(v);
            addRight(v);
        }

        while (leftSize < rightSize) {
            int v = right.firstKey();
            removeRight(v);
            addLeft(v);
        }
    }

    long getCost() {
        long median = left.lastKey();

        return median * leftSize - leftSum
             + rightSum - median * rightSize;
    }

    public long minOperations(int[] nums, int x, int k) {

        int n = nums.length;
        long[] cost = new long[n - x + 1];

        // Sliding Window
        for (int i = 0; i < n; i++) {

            add(nums[i]);

            if (i >= x)
                remove(nums[i - x]);

            if (i >= x - 1)
                cost[i - x + 1] = getCost();
        }

        // Dynamic Programming
        long INF = Long.MAX_VALUE / 4;

        long[] prev = new long[n + 1];
        Arrays.fill(prev, 0);

        for (int j = 1; j <= k; j++) {

            long[] curr = new long[n + 1];
            Arrays.fill(curr, INF);

            for (int i = 1; i <= n; i++) {

                // Skip current element
                curr[i] = curr[i - 1];

                // Select a window of size x
                if (i >= x && prev[i - x] != INF) {
                    curr[i] = Math.min(
                        curr[i],
                        prev[i - x] + cost[i - x]
                    );
                }
            }

            prev = curr;
        }

        return prev[n];
    }
}
