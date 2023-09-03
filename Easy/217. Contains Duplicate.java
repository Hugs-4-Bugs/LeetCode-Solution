class Solution {
  public boolean containsDuplicate(int[] nums) {
    Set<Integer> seen = new HashSet<>();

    for (final int num : nums)
      if (!seen.add(num))
        return true;

    return false;
  }
}



// Approach 1: Brute force --> declare two variable i and j , i for idx 0 and compare j with another idx values if any value of j will match with i then return true otherwise return false

// Approach 2: Sorting --> sort the array and then  compare idx 0 element with idx 1, and idx 2 with idx 1, idx 3 element with idx 2 element and so on.... if any element will match then return true otherwise return false

// Approach 3: HashMap method --> count the frequency of the element if frequency of any element will be more than 1 times then return true otherwise return false.
