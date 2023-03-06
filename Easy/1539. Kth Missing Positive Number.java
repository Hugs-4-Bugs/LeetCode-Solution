



// // //Approach 1 : Binary Search



// // class Solution {
// //     public int findKthPositive(int[] arr, int k) {
// //         int n = arr.length;
// //         int left = 0, right = n - 1;
// //         while (left <= right) {
// //             int mid = left + (right - left) / 2;
// //             int missing = arr[mid] - mid - 1;
// //             if (missing < k) {
// //                 left = mid + 1;
// //             } else {
// //                 right = mid - 1;
// //             }
// //         }
// //         return left + k;
// //     }
// // }







// //Approach 2 :- Using HashSet


class Solution {
    public int findKthPositive(int[] arr, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : arr) {
            set.add(num);
        }
        int i = 1;
        while (true) {
            if (!set.contains(i)) {
                k--;
                if (k == 0) {
                    return i;
                }
            }
            i++;
        }
    }
}



