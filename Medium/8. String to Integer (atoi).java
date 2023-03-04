class Solution {
    public int myAtoi(String s) {
        int result=0;    // helper variables
        int i=0;
        int sign=1;
    
        while(i<s.length()&&s.charAt(i)==' ')i++;  //ignore leading white space
        if(i==s.length())return 0;
        if(s.charAt(i)=='-'||s.charAt(i)=='+')          //check if number positve or negative
        {
            sign=s.charAt(i)=='-'?-1:1;
            i++;
        }
        // now iterate across digits if any
    // should only be in range 0-9
        while(i<s.length()&&(s.charAt(i)>='0'&&s.charAt(i)<='9'))  //traverse string till nondigit not found or string ends
        {
            int digit=(s.charAt(i)-'0')*sign;
            if(sign==1 && (result>Integer.MAX_VALUE/10 || (result==Integer.MAX_VALUE/10 && digit>Integer.MAX_VALUE%10))) return Integer.MAX_VALUE; //check for overflow
            if(sign==-1 &&(result<Integer.MIN_VALUE/10 || (result==Integer.MIN_VALUE/10 && digit<Integer.MIN_VALUE%10))) return Integer.MIN_VALUE; //check for underflow
            
            result=result*10+digit; // update result
            i++;
        }
    
    return result;
    }
}
