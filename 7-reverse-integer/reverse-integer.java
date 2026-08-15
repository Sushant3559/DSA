class Solution {
    public int reverse(int nums) {
    int flag = 1;
    if (nums < 0) {
    flag = -1;
    if (nums == Integer.MIN_VALUE)
     return 0;

      nums *= -1;
        }
         int result = 0;
         while (nums != 0) {
        int rem = nums % 10;
         if (result > Integer.MAX_VALUE / 10)
             return 0;
         result = result * 10 + rem;

            nums /= 10;
        }

        if (flag < 0)
            result *= -1;

        return result;
    }
}