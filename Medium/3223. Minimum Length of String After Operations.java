class Solution {
    public int minimumLength(String s) {
        int[] charFrequency = new int[26];
        int totalLength = 0;
        for (char c : s.toCharArray()) {
            charFrequency[c - 'a']++;
        }
        for (int frequency : charFrequency) {
            if (frequency == 0) continue;
            if (frequency % 2 == 0) {
                totalLength += 2;
            } else {
                totalLength += 1;
            }
        }
        return totalLength;
    }
}







// THIS CODE WILL GIVE TIME LIMIT EXCEED ERROR:


// class Solution {
//     public int minimumLength(String s) {

//         StringBuilder sb = new StringBuilder(s);

//         // loop until no valid pair can be removed
//         boolean changed = true; 
//         while(changed) {
//             // flag to check if any changes happened in this iteration
//             changed = false;  

//             // iterate over the string (start from index 1 to length-2 for valid left and right)
//             for(int i = 1; i < sb.length() - 1; i++) {
//                 char currChar = sb.charAt(i);

//                 // check if there is a character to the left that matches the current character
//                 boolean hasLeft = false;
//                 for(int left = i - 1; left >= 0; left--) {
//                     if(sb.charAt(left) == currChar) {
//                         hasLeft = true;
//                         break; // found a match to left, no need to check further
//                     }
//                 }

//                 // check if there is a character to the right that matches the current character
//                 boolean hasRight = false;
//                 for(int right = i + 1; right < sb.length(); right++) {
//                     if(sb.charAt(right) == currChar) {
//                         hasRight = true;
//                         break; // found a match to right, no need to check further
//                     }
//                 }

//                 // if both left and right match, we can remove characters
//                 if(hasLeft && hasRight) {
//                     int leftIdx = -1, rightIdx = -1;

//                     // find the closest match to the left
//                     for(int left = i - 1; left >= 0; left--) {
//                         if(sb.charAt(left) == currChar) {
//                             leftIdx = left;
//                             break; // found a match to left, no need to check further
//                         }
//                     }

//                     // find the closest match to the right
//                     for(int right = i + 1; right < sb.length(); right++) {
//                         if(sb.charAt(right) == currChar) {
//                             rightIdx = right;
//                             break; // found a match to right, no need to check further
//                         }
//                     }

//                     sb.deleteCharAt(leftIdx);
//                     sb.deleteCharAt(rightIdx - 1);

//                     // changed flag to indicate that a change had been made
//                     changed = true;
//                     break; // break out of loop to restart the process
//                 }
//             }
//         }
//         return sb.length();
//     }
// }


