class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left=0;
        int right=0;
        int [] arr = new int[256];
        int maxLength =0;
        while(right<s.length())
        {
            char currentChar= s.charAt(right);
            int currentCharAscii= (int) currentChar;

            arr[currentCharAscii] =  arr[currentCharAscii] + 1;

            while(arr[currentCharAscii] > 1)
            {
                char leftChar= s.charAt(left);
                int leftCharAscii=(int)leftChar;

                arr[leftCharAscii]=arr[leftCharAscii]-1;

                left++;
            }
            {
                int currentWindowSize=right-left+1;
                if(currentWindowSize> maxLength)
                {
                    maxLength=currentWindowSize;
                }
                right++;
            }
           

        }   
         return maxLength;
    }

}    

    
