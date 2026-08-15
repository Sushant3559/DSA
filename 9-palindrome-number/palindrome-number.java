class Solution {
    public boolean isPalindrome(int x) {
        if(x<0)
        {
            return false;
        }
       int No = x;
       int revNo=0;

       int temp = No;
       while(temp != 0)
       {
         int rem= temp%10;
           revNo = revNo * 10 + rem;

         temp=temp / 10;
        }

        if(No == revNo)
        {
            return true;
        }
        else
        {
            return false;
        }
    
    }
}