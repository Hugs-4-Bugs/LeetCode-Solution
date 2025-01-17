class Solution {
    public boolean doesValidArrayExist(int[] derived) {
        int n = derived.length;

        // try both possibilities for original[0]
        for (int initialval = 0; initialval <= 1; initialval++) {
            int[] original = new int[n]; // create the original array of size n
            original[0] = initialval; // initialize the first element of original

            // calculate the rest of the original array using derived
            for (int i = 0; i < n - 1; i++) {
                original[i + 1] = derived[i] ^ original[i]; // XOR to calculate next element
            }

            // check the wrap-around condition
            if (derived[n - 1] == (original[n - 1] ^ original[0])) {
                return true; // valid original array found, return true
            }
        }
        return false;  // no valid original array is found
    }
}




