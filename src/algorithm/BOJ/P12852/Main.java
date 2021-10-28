package algorithm.BOJ.P12852;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        final int MAX = 1000000;
        Queue<Integer> queue = new LinkedList<>();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] parent = new int[MAX+1];
        queue.offer(n);
        while(!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == 1) {
                break;
            }

            if (cur % 3 == 0 && parent[cur / 3] == 0) {
                parent[cur / 3] = cur;
                queue.offer(cur / 3);
            }

            if (cur % 2 == 0 && parent[cur / 2] == 0) {
                parent[cur / 2] = cur;
                queue.offer(cur / 2);
            }

            if (parent[cur - 1] == 0) {
                parent[cur - 1] = cur;
                queue.offer(cur - 1);
            }
        }

        int cnt = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 1; i > 0; i = parent[i], cnt++) {
            stack.push(i);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(cnt - 1).append("\n");
        while(!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
        System.out.println(sb);
    }
}
