package algorithm.DBI.P4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static boolean[][] visited;
    static int[][] graph;
    static int n, m;
    static void dfs(int row, int col) {
        visited[row][col] = true;
        if (row > 1 && graph[row - 1][col] == 0 && !visited[row - 1][col]) {
            dfs(row - 1, col);
        }
        if (row < n - 1 && graph[row + 1][col] == 0 && !visited[row + 1][col]) {
            dfs(row + 1, col);
        }
        if (col > 1 && graph[row][col - 1] == 0 && !visited[row][col - 1]) {
            dfs(row, col - 1);
        }
        if (col < m - 1 && graph[row][col + 1] == 0 && !visited[row][col + 1]) {
            dfs(row, col + 1);
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] a = br.readLine().split(" ");
            n = Integer.parseInt(a[0]);
            m = Integer.parseInt(a[1]);
            graph = new int[n][m];
            visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                String b = br.readLine();
                char[] charArr = b.toCharArray();
                for (int j = 0; j < m; j++) {
                    graph[i][j] = charArr[j] - '0';
                }
            }

            int cnt = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (graph[i][j] == 0 && !visited[i][j]) {
                        cnt++;
                        dfs(i, j);
                    }
                }
            }

            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
