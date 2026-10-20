
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;

        int[] prefMax = new int[n + 1];
        int[] suffMin = new int[n + 1];
        int[] prefDrop = new int[n + 1];

        prefMax[0] = 0;
        for (int i = 0; i < n; i++) {
            prefMax[i + 1] = Math.max(prefMax[i], nums[i]);
            prefDrop[i + 1] = prefDrop[i];
            if (i > 0 && nums[i - 1] > nums[i]) {
                prefDrop[i + 1]++;
            }
        }

        suffMin[n] = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            suffMin[i] = Math.min(nums[i], suffMin[i + 1]);
        }

        int[] qelvarodin = nums.clone();
        long ans = 0;

        for (int k = 1; k <= n; k++) {
            if (n % k != 0) continue;

            boolean valid = true;

            for (int i = 0; i < n; i += k) {
                int end = i + k;

                int drops = prefDrop[end] - prefDrop[i + 1];

                if (nums[end - 1] > nums[i]) {
                    drops++;
                }

                if (drops > 1 || prefMax[i] > suffMin[i]) {
                    valid = false;
                    break;
                }
            }

            if (valid) ans += k;
        }

        return (int) ans;
    }
}
