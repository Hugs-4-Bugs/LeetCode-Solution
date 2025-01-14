class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] C = new int[n];

        // to check which number have been seen in A & B
        boolean[] seen = new boolean[n + 1];

        int commonCount = 0;

        for(int i = 0; i < n; i++){
            if(seen[A[i]]){
                commonCount++;
            } else {
                seen[A[i]] = true;
            }
            if(seen[B[i]]){
                commonCount++;
            } else {
                seen[B[i]] = true;
            }
            C[i] = commonCount;
        }
        return C;
        
    }
}
