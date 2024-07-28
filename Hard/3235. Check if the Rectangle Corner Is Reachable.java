import java.util.*;

public class Solution {
    public boolean canReachCorner(int X, int Y, int[][] circles) {
        int n = circles.length;
        List<Integer> L = new ArrayList<>();
        List<Integer> R = new ArrayList<>();
        List<Integer> D = new ArrayList<>();
        List<Integer> U = new ArrayList<>();
        boolean[] markL = new boolean[n];
        boolean[] markR = new boolean[n];
        boolean[] markD = new boolean[n];
        boolean[] markU = new boolean[n];
        boolean[] mark = new boolean[n];
        for (int i = 0; i < n; i++) {
            int x = circles[i][0];
            int y = circles[i][1];
            int r = circles[i][2];
            int cnt = 0;
            if (x - r <= 0) {
                cnt += 1;
                markL[i] = true;
                L.add(i);
            }
            if (x + r >= X) {
                cnt += 1;
                markR[i] = true;
                R.add(i);
            }
            if (y - r <= 0) {
                cnt += 1;
                markD[i] = true;
                D.add(i);
            }
            if (y + r >= Y) {
                cnt += 1;
                markU[i] = true;
                U.add(i);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for (int v : L) {
            mark = new boolean[n];
            q.add(v);
            mark[v] = true;
            while (!q.isEmpty()) {
                v = q.poll();
                if (markR[v] || markD[v]) {
                    return false;
                }
                for (int i = 0; i < n; i++) {
                    int x1 = circles[v][0];
                    int y1 = circles[v][1];
                    int r1 = circles[v][2];
                    int x2 = circles[i][0];
                    int y2 = circles[i][1];
                    int r2 = circles[i][2];
                    if (!mark[i] && conflict(x1, y1, r1, x2, y2, r2)) {
                        q.add(i);
                        mark[i] = true;
                    }
                }
            }
        }
        for (int v : U) {
            mark = new boolean[n];
            q.add(v);
            mark[v] = true;
            while (!q.isEmpty()) {
                v = q.poll();
                if (markR[v] || markD[v]) {
                    return false;
                }
                for (int i = 0; i < n; i++) {
                    int x1 = circles[v][0];
                    int y1 = circles[v][1];
                    int r1 = circles[v][2];
                    int x2 = circles[i][0];
                    int y2 = circles[i][1];
                    int r2 = circles[i][2];
                    if (!mark[i] && conflict(x1, y1, r1, x2, y2, r2)) {
                        q.add(i);
                        mark[i] = true;
                    }
                }
            }
        }
        return true;
    }

    public boolean conflict(int x1, int y1, int r1, int x2, int y2, int r2) {
        return (Math.abs(x1 - x2) * Math.abs(x1 - x2) + Math.abs(y1 - y2) * Math.abs(y1 - y2) <= (r1 + r2) * (r1 + r2));
    }
}
