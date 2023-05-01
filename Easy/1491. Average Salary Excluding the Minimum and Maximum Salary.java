class Solution {
    public double average(int[] salary) {
        int min = Math.min(salary[0], salary[1]);
        int max = Math.max(salary[0], salary[1]);
        int sum = 0;
        int n = salary.length;
        for (int i = 2; i < n; i++) {
            int v = salary[i];
            if (v < min) {
                sum += min;
                min = v;
            } else if (v > max) {
                sum += max;
                max = v;
            } else {
                sum += v;
            }
        }
        return ((double) sum) / ((double) n - 2);
    }
}
