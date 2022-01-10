package algorithm.BOJ.P17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int[] pop;
    public static boolean[][] connect;
    public static boolean[] visited;
    public static int n;
    public static int c = 0, d = 0;
    public static void dfs(int pos, boolean first) {
        if (first) c += pop[pos];
        else d += pop[pos];
        for (int i = 1; i <= n; i++) {
            if (connect[pos][i] && !visited[i]) {
                visited[i] = true;
                dfs(i, first);
            }
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            n = Integer.parseInt(br.readLine());
            pop = new int[n+1];
            String[] str = br.readLine().split(" ");
            pop[0] = 0;
            for (int i = 0; i < n; i++) {
                pop[i+1] = Integer.parseInt(str[i]);
            }
            connect = new boolean[n+1][n+1];
            visited = new boolean[n+1];
            for (int i = 1; i <= n; i++) {
                str = br.readLine().split(" ");
                connect[i][i] = true;
                for (int j = 1; j < str.length; j++) {
                    int c = Integer.parseInt(str[j]);
                    connect[i][c] = true;
                }
            }

            int cnt = 0;
            for (int i = 1; i <= n; i++) {
                for (int j = i; j <= n; j++) {
                    if (connect[i][j] && !visited[j]) {
                        cnt++;
                        visited[j] = true;
                        dfs(j, cnt == 1);
                    }
                }
            }

            if (cnt == 1) {
                int min = Integer.MAX_VALUE;
                for (int i = 1; i <= n/2; i++) {
                    for (int j = 1; j <= n; j++) {
                        for (int k = 1; k <= n; k++) {
                            
                        }
                    }
                }
                System.out.println(min);
            } else if (cnt == 2) {
                System.out.println(Math.abs(c - d));
            } else {
                System.out.println(-1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
