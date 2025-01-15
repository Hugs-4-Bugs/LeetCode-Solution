class Solution {
    public int minimizeXor(int num1, int num2) {
        // Count of set bits in num2
        int num2SetBits = Integer.bitCount(num2); 
        int result = 0;
        int setBitCount = 0;

        // Try to turn off bits in num1 and match with num2's set bits
        for (int i = 31; i >= 0; i--) {
            // Check if the current bit in num1 is 1
            if (((num1 >> i) & 1) == 1) {
                // If we still need more set bits, we can set this bit
                if (setBitCount < num2SetBits) {
                    result |= (1 << i);  // Set the current bit in result
                    setBitCount++;
                }
            }
        }

        // If we haven't yet set all the required set bits, set them from the least significant bit
        for (int i = 0; i < 32; i++) {
            if (setBitCount < num2SetBits && ((result >> i) & 1) == 0) {
                result |= (1 << i);  // Set the current bit in result
                setBitCount++;
            }
        }

        return result;
    }
}









// // OR

// class Solution {
//     public int minimizeXor(int num1, int num2) {
//         // Count of set bits in num2
//         int num2SetBits = Integer.bitCount(num2);
        
//         // Count of set bits in num1
//         int num1SetBits = Integer.bitCount(num1);
        
//         int result = 0;
        
//         // If num2's set bits are more than num1's, we need to set additional bits
//         if (num2SetBits > num1SetBits) {
//             // First, set all bits that are already set in num1
//             result = num1;
            
//             // Then set additional bits from least significant positions
//             for (int i = 0; i < 32 && Integer.bitCount(result) < num2SetBits; i++) {
//                 if ((result & (1 << i)) == 0) {
//                     result |= (1 << i);
//                 }
//             }
//         } 
//         // If num2's set bits are less than or equal to num1's
//         else {
//             // Set the most significant set bits of num1
//             for (int i = 31; i >= 0 && Integer.bitCount(result) < num2SetBits; i--) {
//                 if ((num1 & (1 << i)) != 0) {
//                     result |= (1 << i);
//                 }
//             }
            
//             // If we still haven't set enough bits, set the least significant bits
//             for (int i = 0; i < 32 && Integer.bitCount(result) < num2SetBits; i++) {
//                 if ((result & (1 << i)) == 0) {
//                     result |= (1 << i);
//                 }
//             }
//         }
        
//         return result;
//     }
// }
