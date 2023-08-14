// Approach 1: Heap


class Solution {
  public int findKthLargest(int[] nums, int k) {
    Queue<Integer> minHeap = new PriorityQueue<>();

    for (final int num : nums) {
      minHeap.offer(num);
      while (minHeap.size() > k)
        minHeap.poll();
    }

    return minHeap.peek();
  }
}









// Approach 2: Quick Select

// class Solution {
//   public int findKthLargest(int[] nums, int k) {
//     return quickSelect(nums, 0, nums.length - 1, k);
//   }

//   private int quickSelect(int[] nums, int l, int r, int k) {
//     final int pivot = nums[r];

//     int nextSwapped = l;
//     for (int i = l; i < r; ++i)
//       if (nums[i] >= pivot)
//         swap(nums, nextSwapped++, i);
//     swap(nums, nextSwapped, r);

//     final int count = nextSwapped - l + 1; // # of nums >= pivot
//     if (count == k)
//       return nums[nextSwapped];
//     if (count > k)
//       return quickSelect(nums, l, nextSwapped - 1, k);
//     return quickSelect(nums, nextSwapped + 1, r, k - count);
//   }

//   private void swap(int[] nums, int i, int j) {
//     final int temp = nums[i];
//     nums[i] = nums[j];
//     nums[j] = temp;
//   }
// }









// Approach 3: Quick Select with random pivot

// class Solution {
//   public int findKthLargest(int[] nums, int k) {
//     return quickSelect(nums, 0, nums.length - 1, k);
//   }

//   private int quickSelect(int[] nums, int l, int r, int k) {
//     final int randIndex = new Random().nextInt(r - l + 1) + l;
//     swap(nums, randIndex, r);
//     final int pivot = nums[r];

//     int nextSwapped = l;
//     for (int i = l; i < r; ++i)
//       if (nums[i] >= pivot)
//         swap(nums, nextSwapped++, i);
//     swap(nums, nextSwapped, r);

//     final int count = nextSwapped - l + 1; // # of nums >= pivot
//     if (count == k)
//       return nums[nextSwapped];
//     if (count > k)
//       return quickSelect(nums, l, nextSwapped - 1, k);
//     return quickSelect(nums, nextSwapped + 1, r, k - count);
//   }

//   private void swap(int[] nums, int i, int j) {
//     final int temp = nums[i];
//     nums[i] = nums[j];
//     nums[j] = temp;
//   }
// }
