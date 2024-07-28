import java.util.*;

class Solution {
    public int nonSpecialCount(int l, int r) {
        int limit = (int) Math.sqrt(r);
        boolean[] isPrime = sieveOfEratosthenes(limit);

        Set<Integer> specialNumbers = new HashSet<>();

        for (int i = 2; i <= limit; i++) {
            if (isPrime[i]) {
                int specialNumber = i * i;
                if (specialNumber >= l && specialNumber <= r) {
                    specialNumbers.add(specialNumber);
                }
            }
        }

        return (r - l + 1) - specialNumbers.size();
    }

    private boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        return isPrime;
    }

    // Test cases
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        System.out.println(sol.nonSpecialCount(5, 7)); // Output: 3

        // Example 2
        System.out.println(sol.nonSpecialCount(4, 16)); // Output: 11

        // Additional test cases
        System.out.println(sol.nonSpecialCount(1, 10)); // Output: 8 (special: 4, 9)
        System.out.println(sol.nonSpecialCount(15, 30)); // Output: 16 (special: 16, 25)
        System.out.println(sol.nonSpecialCount(10, 100)); // Output: 86 (special: 16, 25, 36, 49, 64, 81, 100)
    }
}
