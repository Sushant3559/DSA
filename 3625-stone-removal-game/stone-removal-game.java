
class Solution {
    public boolean canAliceWin(int n) {
        int turn = 10;
        int count = 0;

        while (n >= turn) {
            n -= turn;
            count++;
            turn--;
        }

        return count % 2 == 1;
    }
}
