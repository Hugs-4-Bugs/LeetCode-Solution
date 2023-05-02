class Solution {
  public int[] intersect(int[] nums1, int[] nums2) {
//     if (nums1.length > nums2.length)
//       return intersect(nums2, nums1);
 
//     List<Integer> ans = new ArrayList<>();
//     Map<Integer, Integer> count = new HashMap<>();

//     for (final int num : nums1)
//       count.put(num, count.getOrDefault(num, 0) + 1);

//     for (final int num : nums2)
//       if (count.containsKey(num) && count.get(num) > 0) {
//         ans.add(num);
//         count.put(num, count.get(num) - 1);
//       }

//     return ans.stream().mapToInt(Integer::intValue).toArray();
//   }
// }






// OR WE CAN ALSO SOLVE THIS PROBLEM BY USING BELOW METHOD



int l1 = nums1.length;
        int l2 = nums2.length;
        int i = 0, j = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while( i < l1 && j < l2)
        {
            if(nums1[i] < nums2[j])
            {
                i++;
            }
            else if(nums1[i] > nums2[j])
            {
                j++;
            }
            else
            {
                nums1[k++] = nums1[i++];
                j++;
            }
        }
        return Arrays.copyOfRange(nums1,0,k);
    }
}
