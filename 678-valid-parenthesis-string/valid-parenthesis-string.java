class Solution {
    public boolean checkValidString(String s) {
       Stack<Integer> extraOpenBrackets = new Stack<>();
        Stack<Integer> aestrick =new Stack<>();
        for(int i =0; i<s.length();i++){
            char ch = s.charAt(i);
            if(ch=='('){
               extraOpenBrackets.push(i); 
            }else if (ch=='*'){
                aestrick.push(i);

            }else{
                //closing
                if(!extraOpenBrackets.isEmpty()){
                   extraOpenBrackets.pop();

                }
               
                else if(!aestrick.isEmpty()){
                    aestrick.pop();
                }else{
                    return false;
                }
            }
        }
        while(!extraOpenBrackets.isEmpty()){
            if(aestrick.isEmpty()){
                return false;
            }
            int openIndex= extraOpenBrackets.pop();
             int closeIndex= aestrick.pop();
            
            if(openIndex>closeIndex){
               return false; 
            }
        }
        return extraOpenBrackets.isEmpty();
    }
}