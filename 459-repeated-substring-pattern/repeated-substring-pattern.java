class Solution {
    public boolean repeatedSubstringPattern(String s) {
      int n =s.length();
      for(int i =n/2; i>=1; i--){
        if(n%i ==0){
           String substr=s.substring(0,i);
           StringBuilder newstr=new StringBuilder(); 
           for(int j=0;j<n/i;j++)
              newstr.append(substr);

           if(newstr.toString().equals(s))
           return true;
        }
      }  
      return false;
    }
}