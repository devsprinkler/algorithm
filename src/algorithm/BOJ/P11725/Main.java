package algorithm.BOJ.P11725;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n  = Integer.parseInt(br.readLine());
            ArrayList<ArrayList<Integer>> conn = new ArrayList<>();
            for (int i = 1; i <= n; i++) {
                conn.add(new ArrayList<>());
            }

            for (int i = 0; i < n - 1; i++) {
                String[] input = br.readLine().split(" ");
                int a = Integer.parseInt(input[0]);
                int b = Integer.parseInt(input[1]);

                conn.get(a).add(b);
                conn.get(b).add(a);
            }
            int[] parent = new int[n + 1];
            parent[1] = 1;
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(1);
            while(!queue.isEmpty()) {
                int currentNode = queue.poll();
                for (int i = 0; i < conn.get(currentNode).size(); i ++) {
                    int connectedNode = conn.get(currentNode).get(i);
                    if (parent[connectedNode] == 0) {
                        parent[connectedNode] = currentNode;
                        queue.offer(connectedNode);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 2; i <= n; i++) {
                sb.append(parent[i]).append("\n");
            }
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
