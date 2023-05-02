class Solution {
    public int arraySign(int[] nums) {
          return Arrays.stream(nums).reduce(1, (a, b) -> Integer.compare(a * b, 0));
    }
}
