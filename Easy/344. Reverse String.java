// Approach 1: Swapping method

// class Solution {
//     public void reverseString(char[] s) {
//         int left = 0;
//         int right = s.length - 1;
        
//         while (left < right) {
//             // Swap the characters at left and right pointers
//             char temp = s[left];
//             s[left] = s[right];
//             s[right] = temp;
            
//             // Move the pointers towards the center
//             left++;
//             right--;
//         }
//     }
// }


















// Approach 2: Recursion



// class Solution {
//     public void reverseString(char[] s) {
//         reverseHelper(s, 0, s.length - 1);
//     }
    
//     private void reverseHelper(char[] s, int left, int right) {
//         if (left >= right) {
//             return;
//         }
        
//         // Swap the characters at left and right pointers
//         char temp = s[left];
//         s[left] = s[right];
//         s[right] = temp;
        
//         // Recur for the next pair
//         reverseHelper(s, left + 1, right - 1);
//     }
// }


















// Approach 3: Iterative Reversal Using Stack-Like Behavior


// class Solution {
//     public void reverseString(char[] s) {
//         int n = s.length;
//         char[] stack = new char[n];
        
//         // Push all characters to the stack
//         for (int i = 0; i < n; i++) {
//             stack[i] = s[i];
//         }
        
//         // Pop characters from the stack in reverse order
//         for (int i = 0; i < n; i++) {
//             s[i] = stack[n - 1 - i];
//         }
//     }
// }



















// Approach 4: Iterating from last index of array


class Solution {
    public void reverseString(char[] s) {
        int n = s.length;
        char[] reversed = new char[n];
        
        // Iterate from the end of the array to the beginning
        for (int i = 0; i < n; i++) {
            reversed[i] = s[n - 1 - i];
        }
        
        // Copy the reversed array back to the original array
        for (int i = 0; i < n; i++) {
            s[i] = reversed[i];
        }
    }
}
