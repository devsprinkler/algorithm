package algorithm.BOJ.P1463;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] visited = new int[n + 1];
            LinkedList<Integer> queue = new LinkedList<>();
            visited[n] = 0;
            queue.offer(n);
            while(!queue.isEmpty()) {
                int cur = queue.poll();
                if (cur == 1) break;
                if (cur % 3 == 0 && visited[cur / 3] == 0) {
                    visited[cur / 3] = visited[cur] + 1;
                    queue.offer(cur / 3);
                }
                if (cur % 2 == 0 && visited[cur / 2] == 0) {
                    visited[cur / 2] = visited[cur] + 1;
                    queue.offer(cur / 2);
                }
                if (visited[cur - 1] == 0) {
                    visited[cur - 1] = visited[cur] + 1;
                    queue.offer(cur - 1);
                }
            }
            System.out.println(visited[1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
