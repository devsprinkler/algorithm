package algorithm.DBI.P5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            int[][] map = new int[n][m];
            int[][] visited = new int[n][m];
            visited[0][0] = 1;
            for (int i = 0; i < n; i++) {
                String b = br.readLine();
                char[] charArr = b.toCharArray();
                for (int j = 0; j < m; j++) {
                    map[i][j] = charArr[j] - '0';
                }
            }

            LinkedList<int[]> queue = new LinkedList<>();
            queue.offer(new int[] {0, 0});
            while(!queue.isEmpty()) {
                int[] pos = queue.poll();
                int row = pos[0], col = pos[1];
                if (row == n - 1 && col == m - 1) {
                    break;
                }

                if (row > 0 && map[row - 1][col] == 1 && visited[row - 1][col] == 0) {
                    visited[row - 1][col] = visited[row][col] + 1;
                    queue.offer(new int[] {row - 1, col});
                }
                if (row < n - 1 && map[row + 1][col] == 1 && visited[row + 1][col] == 0) {
                    visited[row + 1][col] = visited[row][col] + 1;
                    queue.offer(new int[] {row + 1, col});
                }
                if (col > 0 && map[row][col - 1] == 1 && visited[row][col - 1] == 0) {
                    visited[row][col - 1] = visited[row][col] + 1;
                    queue.offer(new int[] {row, col - 1});
                }
                if (col < m - 1 && map[row][col + 1] == 1 && visited[row][col + 1] == 0) {
                    visited[row][col + 1] = visited[row][col] + 1;
                    queue.offer(new int[] {row, col + 1});
                }
            }
            System.out.println(visited[n - 1][m - 1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
