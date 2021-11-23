package algorithm.BOJ.P2479;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static int bitCnt(int v){
        v = (v & 0x55555555) + ((v >> 1) & 0x55555555);
        v = (v & 0x33333333) + ((v >> 2) & 0x33333333);
        v = (v & 0x0f0f0f0f) + ((v >> 4) & 0x0f0f0f0f);
        v = (v & 0x00ff00ff) + ((v >> 8) & 0x00ff00ff);
        v = (v & 0x0000ffff) + ((v >> 16) & 0x0000ffff);
        return v;
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int k = Integer.parseInt(str[1]);
            int[] code = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                String in = br.readLine();
                code[i] = Integer.parseInt(in, 2);
            }
            str = br.readLine().split(" ");
            int a = Integer.parseInt(str[0]);
            int b = Integer.parseInt(str[1]);

            boolean[][] dist = new boolean[n + 1][n + 1];
            for (int i = 1; i < n; i++) {
                for (int j = i + 1; j <= n; j++) {
                    if (bitCnt(code[i]^code[j]) == 1) {
                        dist[i][j] = true;
                        dist[j][i] = true;
                    }
                }
            }

            int[] parent = new int[n + 1];
            LinkedList<Integer> queue = new LinkedList<>();
            queue.offer(b);
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                if (cur == a) break;
                for (int i = 1; i <= n; i++) {
                    if (parent[i] == 0) {
                        if (dist[cur][i]) {
                            parent[i] = cur;
                            queue.offer(i);
                        }
                    }
                }
            }
            if (parent[a] == 0) {
                System.out.println(-1);
                return;
            }

            StringBuilder sb = new StringBuilder();
            for (int i = a; i != b; i = parent[i]) {
                sb.append(i).append(" ");
            }
            sb.append(b);
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}