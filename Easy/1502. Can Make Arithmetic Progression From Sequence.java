class Solution {
    public boolean canMakeArithmeticProgression(int[] A) {
      Arrays.sort(A);
      int diff = A[1] - A[0];
      for(int i=2; i<A.length; i++){
          if(A[i]-A[i-1] != diff){
              return false;
          }
      }
      return true;
    }
}
