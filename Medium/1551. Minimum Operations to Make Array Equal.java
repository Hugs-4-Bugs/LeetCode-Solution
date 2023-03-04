class Solution {
    public int minOperations(int n) {
        
    // int sum = n * (n + 1);
    // if (sum % 2 != 0) {
    //     // if sum is odd, we can't make all elements equal
    //     return -1;
    // }
    // int target = sum / 2;
    // int operations = 0;
    // for (int i = 0; i < n; i++) {
    //     int diff = target - (2 * i + 1);
    //     if (diff < 0) {
    //         // we can't make all elements equal
    //         return -1;
    //     }
    //     operations += diff / n;
    // }
    // return operations;
    
    
    int sum =0;
        for(int i=0; i<n/2; i++)
            sum += n-(2*i)-1;
        return sum;
    }
}
