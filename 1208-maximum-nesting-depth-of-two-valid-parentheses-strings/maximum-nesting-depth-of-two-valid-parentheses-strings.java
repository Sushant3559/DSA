class Solution {
    public int[] maxDepthAfterSplit(String s) {
        int cur =0;
        int res[] = new int[s.length()];
        for(int i=0; i<s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                cur++;
                res[i] = cur%2;

            } else{
                res[i] = cur %2;
                cur--;
            }
        }
        return res;
    }
}