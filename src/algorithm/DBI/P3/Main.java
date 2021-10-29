package algorithm.DBI.P3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Queue<Integer> queue = new LinkedList<>();
        try {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());

            queue.offer(n);
            int[] parent = new int[n + 1];
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                if (cur == 1) break;
                if (cur % k == 0 && parent[cur / k] == 0) {
                    parent[cur / k] = cur;
                    queue.offer(cur / k);
                }
                if (parent[cur - 1] == 0) {
                    parent[cur - 1] = cur;
                    queue.offer(cur - 1);
                }
            }
            int cnt = 0;
            for (int i = 1; i != n; i = parent[i], cnt++);
            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
