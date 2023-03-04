class Solution {
    public boolean isPalindrome(int x) {
        String xStr = Integer.toString(x);
        // Check if xStr is equal to its reverse
        return xStr.equals(new StringBuilder(xStr).reverse().toString());
    }
}
