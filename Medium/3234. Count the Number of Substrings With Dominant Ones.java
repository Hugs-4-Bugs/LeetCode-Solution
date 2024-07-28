import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public int numberOfSubstrings(String s) {
        int n = s.length();
        Deque<Integer> v = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                v.addLast(i);
            }
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            while (!v.isEmpty() && v.peekFirst() < i) {
                v.pollFirst();
            }
            int prev = i - 1;
            int cnt1 = 0;
            int cnt0 = 0;
            for (int x : v) {
                if (x - prev - 1 >= Math.max(0, cnt0 * cnt0 - cnt1)) {
                    ans += x - prev - 1 - Math.max(0, cnt0 * cnt0 - cnt1);
                    if (Math.max(0, cnt0 * cnt0 - cnt1) != 0) {
                        ans += 1;
                    }
                }
                cnt1 += x - prev - 1;
                prev = x;
                cnt0 += 1;
                if (cnt0 * cnt0 <= cnt1) {
                    ans += 1;
                }
                if (cnt0 * cnt0 > cnt1 + n - x - 1) {
                    break;
                }
                prev = x;
            }
            if (n - prev - 1 >= Math.max(0, cnt0 * cnt0 - cnt1)) {
                ans += n - prev - 1 - Math.max(0, cnt0 * cnt0 - cnt1);
                if (Math.max(0, cnt0 * cnt0 - cnt1) != 0) {
                    ans += 1;
                }
            }
        }
        return ans;
    }
}
