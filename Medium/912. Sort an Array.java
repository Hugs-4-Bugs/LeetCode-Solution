//Approach 1: Merge Sort
//Time: O(nlogn)
//Space: O(n) 


class Solution {
  public int[] sortArray(int[] nums) {
    mergeSort(nums, 0, nums.length - 1);
    return nums;
  }

  private void mergeSort(int[] A, int l, int r) {
    if (l >= r)
      return;

    final int m = (l + r) / 2;
    mergeSort(A, l, m);
    mergeSort(A, m + 1, r);
    merge(A, l, m, r);
  }

  private void merge(int[] A, int l, int m, int r) {
    int[] sorted = new int[r - l + 1];
    int k = 0;     // sorted's index
    int i = l;     // left's index
    int j = m + 1; // right's index

    while (i <= m && j <= r)
      if (A[i] < A[j])
        sorted[k++] = A[i++];
      else
        sorted[k++] = A[j++];

    // Put possible remaining left part to the sorted array
    while (i <= m)
      sorted[k++] = A[i++];

    // Put possible remaining right part to the sorted array
    while (j <= r)
      sorted[k++] = A[j++];

    System.arraycopy(sorted, 0, A, l, sorted.length);
  }
}





// Approach 2: Heap Sort
//Time: O(nlogn)
//Space: O(n) 



// class Solution {
//   public int[] sortArray(int[] nums) {
//     heapSort(nums);
//     return nums;
//   }

//   private void heapSort(int[] A) {
//     buildMaxHeap(A);
//     int heapSize = A.length;
//     for (int i = A.length - 1; i > 0; --i) {
//       swap(A, i, 0);
//       --heapSize;
//       maxHeapify(A, 0, heapSize);
//     }
//   }

//   private void buildMaxHeap(int[] A) {
//     for (int i = A.length / 2; i >= 0; --i)
//       maxHeapify(A, i, A.length);
//   }

//   private void maxHeapify(int[] A, int i, int heapSize) {
//     final int l = 2 * i + 1;
//     final int r = 2 * i + 2;
//     int largest = i;
//     if (l < heapSize && A[largest] < A[l])
//       largest = l;
//     if (r < heapSize && A[largest] < A[r])
//       largest = r;
//     if (largest != i) {
//       swap(A, largest, i);
//       maxHeapify(A, largest, heapSize);
//     }
//   }

//   private void swap(int[] A, int i, int j) {
//     final int temp = A[i];
//     A[i] = A[j];
//     A[j] = temp;
//   }
// }





// //Approach 3: Quick Sort
// //Time: O(nlogn)
// //Space: O(n) 





// class Solution {
//   public int[] sortArray(int[] nums) {
//     quickSort(nums, 0, nums.length - 1);
//     return nums;
//   }

//   private void quickSort(int[] A, int l, int r) {
//     if (l >= r)
//       return;

//     final int m = partition(A, l, r);
//     quickSort(A, l, m - 1);
//     quickSort(A, m + 1, r);
//   }

//   private int partition(int[] A, int l, int r) {
//     final int randIndex = new Random().nextInt(r - l + 1) + l;
//     swap(A, randIndex, r);
//     final int pivot = A[r];
//     int nextSwapped = l;
//     for (int i = l; i < r; ++i)
//       if (A[i] <= pivot)
//         swap(A, nextSwapped++, i);
//     swap(A, nextSwapped, r);
//     return nextSwapped;
//   }

//   private void swap(int[] A, int i, int j) {
//     final int temp = A[i];
//     A[i] = A[j];
//     A[j] = temp;
//   }
// }
