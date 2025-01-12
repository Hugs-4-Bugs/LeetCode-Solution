// class Solution {
//     public boolean canBeValid(String s, String locked) {
//         int n = s.length();
//         if(n%2!=0) return false;
//         Stack<Integer> stack = new Stack<>();
//         Stack<Integer> unlocked = new Stack<>();
//         for(int i=0;i<n;i++){
//             char ch = s.charAt(i);
//             char state = locked.charAt(i);
//             if(state == '0'){
//                 unlocked.push(i);
//             }else if(ch == '('){
//                 stack.push(i);
//             }else{ // locked and closing
//                 if(!stack.isEmpty()){
//                     stack.pop();
//                 }else{
//                     if(!unlocked.isEmpty()){
//                         unlocked.pop();
//                     }else{
//                         return false;
//                     }
//                 }
//             }
//         }

//         while(!stack.isEmpty() && !unlocked.isEmpty() && stack.peek() < unlocked.peek()){
//             stack.pop();
//             unlocked.pop();
//         }
//         return (stack.isEmpty());
//     }
// }




//  Approach 1: Two-Pass Balance Check

// class Solution {
//     public boolean canBeValid(String inputString, String lockStatus) {
//         if (inputString.length() % 2 != 0) 
//             return false;

//         int balanceCount = 0;
//         for (int i = 0; i < inputString.length(); i++) {
//             if (lockStatus.charAt(i) == '0' || inputString.charAt(i) == '(') 
//                 balanceCount++;
//             else 
//                 balanceCount--;
//             if (balanceCount < 0) 
//                 return false;
//         }

//         balanceCount = 0;
//         for (int i = inputString.length() - 1; i >= 0; i--) {
//             if (lockStatus.charAt(i) == '0' || inputString.charAt(i) == ')') 
//                 balanceCount++;
//             else 
//                 balanceCount--;
//             if (balanceCount < 0) 
//                 return false;
//         }

//         return true;
//     }
// }




// 🔍 Approach 2: Greedy Approach

// class Solution {
//     public boolean canBeValid(String s, String locked) {
//         if (s.length() % 2 != 0) 
//             return false;

//         int openCount = 0, closeCount = 0;
//         for (int i = 0; i < s.length(); i++) {
//             if (locked.charAt(i) == '0' || s.charAt(i) == '(') 
//                 openCount++;
//             else 
//                 openCount--;
//             if (openCount < 0) 
//                 return false;
//         }

//         openCount = 0;
//         for (int i = s.length() - 1; i >= 0; i--) {
//             if (locked.charAt(i) == '0' || s.charAt(i) == ')') 
//                 closeCount++;
//             else 
//                 closeCount--;
//             if (closeCount < 0) 
//                 return false;
//         }

//         return true;
//     }
// }





// 🔍 Approach 3: Single-Pass Validation with Dynamic Balance

class Solution {
    public boolean canBeValid(String parentheses, String status) {
        int length = parentheses.length();
        if (length % 2 != 0) return false;
        int minBalance = 0, maxBalance = 0;
        for (int i = 0; i < length; i++) {
            boolean isOpening = parentheses.charAt(i) == '(';
            boolean isUnlocked = status.charAt(i) == '0';
            minBalance += (!isOpening || isUnlocked) ? -1 : 1;
            maxBalance += (isOpening || isUnlocked) ? 1 : -1;
            if (maxBalance < 0) return false;
            minBalance = Math.max(minBalance, 0);
        }
        return minBalance == 0;
    }
}
