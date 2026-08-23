class Solution {
    public int countPrimes(int n) {
        if (n < 2) return 0;
        boolean[]  camposites= new boolean [n];

         for(int i = 2; i*i<n; i++){
            if(camposites[i] == false){

                for(int j=i*i; j<n; j+=i){
                    camposites[j]= true;
                }
            }
         }
         int count=0;
         for(int i=2; i<n; i++){
            if (camposites[i] == false) count++;      
        }
        return count;
    }
}