package algorithm.BOJ.P16928;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static int[] snake = new int[101];
    public static int[] visit = new int[101];

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n + m; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                snake[x] = y;
            }

            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            visit[1] = 0;

            while(!queue.isEmpty()) {
                int cur = queue.poll();
                for (int i = 1; i <= 6; i++) {
                    if (cur + i > 100) break;
                    if (snake[cur + i] == 0 && visit[cur + i] == 0) {
                        visit[cur + i]  = visit[cur] + 1;
                        queue.offer(cur + i);
                    } else if (snake[cur + i] != 0 && visit[snake[cur + i]] == 0) {
                        visit[cur + i] = visit[cur] + 1;
                        visit[snake[cur + i]] = visit[cur] + 1;
                        queue.offer(snake[cur + i]);
                    }
                }
            }
            System.out.println(visit[100]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
