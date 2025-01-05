import java.util.*;

class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int maxLen = 0;

        for (int i = 0; i < n; i++) {
            int prod = 1;
            int gcd = 0;
            long lcm = 1;

            for (int j = i; j < n; j++) {
                prod *= nums[j];
                gcd = gcd(gcd, nums[j]);
                lcm = lcm(lcm, nums[j], gcd(gcd, nums[j]));

                if (prod == gcd * lcm) {
                    maxLen = Math.max(maxLen, j - i + 1);
                } else {
                    break;
                }
            }
        }

        return maxLen;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    private long lcm(long a, long b, int gcd) {
        return (a / gcd) * b;
    }

    public long calculateScore(String s) {
        int n = s.length();
        long score = 0;
        Map<Character, Deque<Integer>> mirrorMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            char mirrored = mirror(s.charAt(i));
            if (mirrorMap.containsKey(mirrored) && !mirrorMap.get(mirrored).isEmpty()) {
                int j = mirrorMap.get(mirrored).pollLast();
                score += i - j;
            } else {
                mirrorMap.putIfAbsent(s.charAt(i), new ArrayDeque<>());
                mirrorMap.get(s.charAt(i)).add(i);
            }
        }

        return score;
    }

    private char mirror(char c) {
        return (char) ('a' + ('z' - c));
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.maxLength(new int[]{1, 2, 1, 2, 1, 1, 1}));  // Output: 5
        System.out.println(sol.maxLength(new int[]{2, 3, 4, 5, 6}));  // Output: 3
        System.out.println(sol.maxLength(new int[]{1, 2, 3, 1, 4, 5, 1}));  // Output: 5

        System.out.println(sol.calculateScore("aczzx"));  // Output: 5
        System.out.println(sol.calculateScore("abcdef"));  // Output: 0
    }
}
