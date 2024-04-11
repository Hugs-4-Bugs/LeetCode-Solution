// import java.util.Stack;

// class Solution {
//     public String removeKdigits(String num, int k) {
//         Stack<Character> stack = new Stack<>();
        
//         for (char digit : num.toCharArray()) {
//             while (!stack.isEmpty() && k > 0 && stack.peek() > digit) {
//                 stack.pop();
//                 k--;
//             }
//             stack.push(digit);
//         }
        
//         // If k > 0, remove remaining digits from the end
//         while (k > 0 && !stack.isEmpty()) {
//             stack.pop();
//             k--;
//         }
        
//         // Build the result string
//         StringBuilder sb = new StringBuilder();
//         while (!stack.isEmpty()) {
//             sb.append(stack.pop());
//         }
//         sb.reverse();
        
//         // Remove leading zeros
//         while (sb.length() > 1 && sb.charAt(0) == '0') {
//             sb.deleteCharAt(0);
//         }
        
//         return sb.length() == 0 ? "0" : sb.toString();
//     }
// }










//  Greedy approach
class Solution {
    public String removeKdigits(String num, int k) {
        int n = num.length();
        if (k == n) return "0"; // If all digits are removed
        
        StringBuilder sb = new StringBuilder();
        int i = 0;
        
        // Greedily remove digits that are greater than the next one
        while (i < n) {
            while (k > 0 && sb.length() > 0 && num.charAt(i) < sb.charAt(sb.length() - 1)) {
                sb.deleteCharAt(sb.length() - 1); // Remove the last character
                k--;
            }
            sb.append(num.charAt(i));
            i++;
        }
        
        // Handle the case where k > 0 but digits are already in increasing order
        while (k > 0) {
            sb.deleteCharAt(sb.length() - 1);
            k--;
        }
        
        // Remove leading zeros
        while (sb.length() > 1 && sb.charAt(0) == '0') {
            sb.deleteCharAt(0);
        }
        
        return sb.toString();
    }
}
