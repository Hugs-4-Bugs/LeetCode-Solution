class Solution {
    public boolean checkValidString(String s) {
        int minOpen = 0;
        int maxOpen = 0;
        
        for (char ch : s.toCharArray()) {
            if (ch == '(') {
                minOpen++;
                maxOpen++;
            } else if (ch == ')') {
                minOpen = Math.max(minOpen - 1, 0);
                maxOpen--;
                if (maxOpen < 0) {
                    return false; // More closing parentheses than opening ones
                }
            } else { // wildcard '*'
                minOpen = Math.max(minOpen - 1, 0); // Treat '*' as ')'
                maxOpen++; // Treat '*' as '('
            }
        }
        
        return minOpen == 0;
    }
}





/**
In this modified code:

'minOpen' keeps track of the minimum number of open parentheses that could match every closing parenthesis encountered so far.
'maxOpen' keeps track of the maximum number of open parentheses that could match every closing parenthesis encountered so far.
When encountering a '*', we adjust both minOpen and maxOpen accordingly to consider it as any of the possible options: '(' or ')' or an empty string.
At the end, we return true if 'minOpen' is 0, indicating that all parentheses are matched, and false otherwise. */
