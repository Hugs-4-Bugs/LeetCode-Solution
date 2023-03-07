// // Approach 1  Bucket and Binary Search

// a. Using character buckets to store all the indices for its occurence
// b. As we loop through each character of s, we do binary search on the buckets
// c. If the return index is greater than or equal to the bucket length, that means we cannot   
      //find a valid index for current character
// d. We save this index our key search for next character
// e. Time complexity O(m + nlogm)
// f. Space complexity O(m)


class Solution {
    public boolean isSubsequence(String s, String t) {
      int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
        
    }
}



// Approach 2 Two Pointers and Greedy
//a. We main a pointer of i and j for s and t respectively
//b. When we match a character from t, we move i pointer forward
//c. If i is able to reach the end, we know s is subsequence of t
//d. Time complexity O(m)
//e. Space complexity O(1)


class Solution {
    public boolean isSubsequence(String s, String t) {
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            prev = t.indexOf(s.charAt(i), prev + 1);
            if (prev == -1) return false;
        }
        return true;
    }
}




// Approach 3 Build-int IndexOf function
//a. Time complexity O(m)
//b. Space complexity O(1)


class Solution {
    public boolean isSubsequence(String s, String t) {
        List<Integer>[] bucket = new List[256];
        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (bucket[c] == null) bucket[c] = new ArrayList<>();
            bucket[c].add(i);
        }
        int prev = 0;
        for (char c : s.toCharArray()) {
            if (bucket[c] == null) return false;
            int j = Collections.binarySearch(bucket[c], prev);
            j = j < 0 ? -(j + 1) : j;
            if (j == bucket[c].size()) return false;
            prev = bucket[c].get(j) + 1;
        }
        return true;
    }
}
