class Solution {
    private static final int MOD = 1000000007;
    private int[] f = new int[100005], g = new int[100005], h = new int[100005], a = new int[100005];
    private int n;

    private int add(int x, int y) {
        return (x + y >= MOD) ? (x + y - MOD) : (x + y);
    }

    private int mul(int x, int y) {
        return (int) ((1L * x * y) % MOD);
    }

    public int sumOfGoodSubsequences(int[] nums) {
        n = nums.length;
        System.arraycopy(nums, 0, a, 1, n);
        
        // Initialize the array f with zeros
        f = new int[100005];
        
        for (int i = 1; i <= n; i++) {
            g[i] = add(1, f[a[i] + 1]);
            if (a[i] >= 1) {
                g[i] = add(g[i], f[a[i] - 1]);
            }
            f[a[i]] = add(f[a[i]], g[i]);
        }
        
        // Re-initialize the array f with zeros
        f = new int[100005];
        
        for (int i = n; i >= 1; i--) {
            h[i] = add(1, f[a[i] + 1]);
            if (a[i] >= 1) {
                h[i] = add(h[i], f[a[i] - 1]);
            }
            f[a[i]] = add(f[a[i]], h[i]);
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = add(ans, mul(a[i], mul(g[i], h[i])));
        }
        return ans;
    }
}
