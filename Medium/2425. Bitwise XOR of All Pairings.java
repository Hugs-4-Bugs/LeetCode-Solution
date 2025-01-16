class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {

        
       int xor1 =0, xor2 = 0;

        for(int i=0; i<nums1.length; i++){
            xor1 ^= nums1[i];
        }

        for(int i=0; i<nums2.length; i++){
            xor2 ^= nums2[i];
        }


        int result = 0;
        if(nums2.length % 2 == 1){
            result ^= xor1;
        }

        if(nums1.length % 2 == 1){
            result ^= xor2;
        }

        return result; 
    }
}




/**
##### Problem Explanation:

You have two arrays nums1 and nums2. Each element in nums1 is paired with every element in nums2, and for each pairing, you compute the bitwise XOR of those two numbers.
Now, you need to XOR all the numbers in the result of these pairings and return the final result.

##### What is bitwise XOR?
The bitwise XOR (exclusive OR) is an operation that compares bits of two numbers:

If both bits are the same (0 & 0 or 1 & 1), the result is 0.
If the bits are different (0 & 1 or 1 & 0), the result is 1.


##### For example:

5 ^ 3 means:
5 in binary is 101
3 in binary is 011
XORing the bits: 101 ^ 011 = 110 (which is 6 in decimal).

##### Steps to Solve:
You need to pair each element of nums1 with every element of nums2 and calculate the XOR for each pair.
Then, you need to XOR all those results together to get the final answer.


**Example 1:**
Input:

nums1 = [2, 1, 3]
nums2 = [10, 2, 5, 0]
Let's see all the pairings and their XOR results:

2 ^ 10 = 8
2 ^ 2 = 0
2 ^ 5 = 7
2 ^ 0 = 2
1 ^ 10 = 11
1 ^ 2 = 3
1 ^ 5 = 4
1 ^ 0 = 1
3 ^ 10 = 9
3 ^ 2 = 1
3 ^ 5 = 6
3 ^ 0 = 3
So, the nums3 array is: [8, 0, 7, 2, 11, 3, 4, 1, 9, 1, 6, 3].

Now, XOR all these numbers together:
8 ^ 0 ^ 7 ^ 2 ^ 11 ^ 3 ^ 4 ^ 1 ^ 9 ^ 1 ^ 6 ^ 3 = 13.

Output: 13






**Example 2:**
Input:

nums1 = [1, 2]
nums2 = [3, 4]
Let's see the pairings and their XOR results:

1 ^ 3 = 2    
1 ^ 4 = 5
2 ^ 3 = 1
2 ^ 4 = 6
So, the nums3 array is: [2, 5, 1, 6].

Now, XOR all these numbers together:
2 ^ 5 ^ 1 ^ 6 = 0.
Output: 0

8 bit binary representation:
0   000
1   001
2   010
3   011
4   100
5   101
6   110
7   111



 ### How its working
 
 **2 ^ 10 = 8**
 
First, let's convert 2 and 10 to binary:

2 in binary: 00000010
10 in binary: 00001010
Now, perform the XOR operation bit by bit:

Compare each corresponding pair of bits:

Here’s the corrected alignment for the table:

| Bit of 2 | Bit of 10 | XOR Result |
|----------|-----------|------------|
| 0        | 0         | 0          |
| 0        | 0         | 0          |
| 0        | 0         | 0          |
| 0        | 0         | 0          |
| 0        | 1         | 1          |
| 0        | 0         | 0          |
| 1        | 1         | 0          |
| 0        | 0         | 0          |


So, the result of 2 ^ 10 in binary is 00010000, which is 8 in decimal.


*Q.  how u know its 8 decimal ?
Ans: 
The binary `00001000` equals 8 in decimal because the `1` is in the \(2^3\) place (8), and all other bits are 0.*


*Q. Binary of 2 is 010 then why u putted extra five 0 before tell me the reason? *
Ans:
In binary, we typically use 8 bits (1 byte) to represent numbers for easier comparison, especially in programming. So, even though 2 is 10 in binary, we pad it with extra zeros to make it 00000010. This ensures each number has the same length when performing bitwise operations.


### Approach:

**Step 1:**  
Initialize two variables `xor1` and `xor2` with the initial value `0`.

**Step 2:**  
Iterate over both arrays `nums1` and `nums2`. For each index `i`:
- XOR the value of `nums1[i]` with `xor1` and update `xor1`.
- XOR the value of `nums2[i]` with `xor2` and update `xor2`.

**Step 3:**  
Initialize a new variable `result` and set its initial value to `0`. This will store the final XOR value.

**Step 4:**  
Check the parity (odd or even) of the array lengths:
- If `nums2.length % 2 == 1`, XOR `xor1` with `result` and update `result`.
- If `nums1.length % 2 == 1`, XOR `xor2` with `result` and update `result`.

**Step 5:**  
Return the value of result as the final XOR value.




#### Pseudo code

```
  int xor1 = 0, xor2 = 0;
	
 // XOR all elements of nums1 and nums2
         for (int i = 0----->nums.length) {
             xor ^= nums[i];
         }
```



```
// and now talculate the final XOR based on the parity (odd/even) of the array lengths
        int result = 0;
        if (nums2.length % 2 == 1) {
            result ^= xor1;
        }
        if (nums1.length % 2 == 1) {
            result ^= xor2;
        }
```
*/
