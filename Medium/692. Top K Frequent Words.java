// // Approach 1: Bucket Sort
// // Time: O(n)
// // Space: O(n)



class Solution {
  public List<String> topKFrequent(String[] words, int k) {
    final int n = words.length;
    List<String> ans = new ArrayList<>();
    List<String>[] bucket = new List[n + 1];
    Map<String, Integer> count = new HashMap<>();

    for (final String word : words)
      count.merge(word, 1, Integer::sum);

    for (final String word : count.keySet()) {
      final int freq = count.get(word);
      if (bucket[freq] == null)
        bucket[freq] = new ArrayList<>();
      bucket[freq].add(word);
    }

    for (int freq = n; freq > 0; --freq)
      if (bucket[freq] != null) {
        Collections.sort(bucket[freq]);
        for (final String word : bucket[freq]) {
          ans.add(word);
          if (ans.size() == k)
            return ans;
        }
      }

    throw new IllegalArgumentException();
  }
}




// // Approach 2: Follow up
// // Time: O(nlogk)
// // Space: O(nlogk)



// class T {
//   public String word;
//   public int freq;
//   public T(String word, int freq) {
//     this.word = word;
//     this.freq = freq;
//   }
// }

// class Solution {
//   public List<String> topKFrequent(String[] words, int k) {
//     List<String> ans = new ArrayList<>();
//     Map<String, Integer> count = new HashMap<>();
//     // Words w/ higher frequency and lower alphabetical order are in the bottom
//     // Of the heap, because we'll pop words w/ lower frequency and higher
//     // Alphabetical order if the heap's size > k

//     Queue<T> heap = new PriorityQueue<>(
//         (a, b) -> a.freq == b.freq ? b.word.compareTo(a.word) : a.freq - b.freq);

//     for (final String word : words)
//       count.merge(word, 1, Integer::sum);

//     for (final String word : count.keySet()) {
//       heap.offer(new T(word, count.get(word)));
//       if (heap.size() > k)
//         heap.poll();
//     }

//     while (!heap.isEmpty())
//       ans.add(heap.poll().word);

//     Collections.reverse(ans);
//     return ans;
//   }
// }
