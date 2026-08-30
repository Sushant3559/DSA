class Solution {
    public static int nCr(int n ,int r)
    {
        r=Math.min(r,n-r);
        long res =1;
        for(int i= 1;i<=r;i++)
        res=(res*(n-i+1))/i;
        return (int)res;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> arr = new LinkedList<>();

        for(int i=0; i<numRows; i++){
            List<Integer> row = new LinkedList<>();
          
            for(int j=0; j<=i;j++)
            row.add(nCr(i,j));
            arr.add(row);
        }
        
          return arr;
    }
}