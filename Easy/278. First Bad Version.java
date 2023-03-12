// /* The isBadVersion API is defined in the parent class VersionControl.
//       boolean isBadVersion(int version); */

// public class Solution extends VersionControl {
//     public int firstBadVersion(int n) {
//         int low=1,high=n,mid;
//         int ans=-1;
//         while(low<=high)
//         {
//             mid = low + ((high - low)/2 );
//             if(isBadVersion(mid))
//             {
//                 high=mid-1;
//                 ans=mid;
//             }
//             else
//                 low=mid+1;
//         }
//         return ans;

        
//     }
// }




  

//   We can also write this code as 👇



public class Solution extends VersionControl {
  public int firstBadVersion(int n) {
    int l = 1;
    int r = n;

    while (l < r) {
      final int m = l + (r - l) / 2;
      if (isBadVersion(m))
        r = m;
      else
        l = m + 1;
    }

    return l;
  }
}
