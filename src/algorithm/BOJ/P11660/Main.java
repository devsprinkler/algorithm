package algorithm.BOJ.P11660;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");

            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            int[][] table = new int[n + 1][n + 1];
            for (int i = 1; i <= n; i++) {
                str = br.readLine().split(" ");
                for (int j = 1; j <= n; j++) {
                    table[i][j] = table[i][j - 1] + table[i - 1][j] - table[i - 1][j - 1] + Integer.parseInt(str[j - 1]);
                }
            }
            StringBuilder sb = new StringBuilder();
            int[] op = new int[4];
            for (int i = 0; i < m; i++) {
                str = br.readLine().split(" ");
                for (int j = 0; j < 4; j++) {
                    op[j] = Integer.parseInt(str[j]);
                }
                sb.append(table[op[2]][op[3]] - table[op[0] - 1][op[3]] - table[op[2]][op[1] - 1] + table[op[0] - 1][op[1] - 1]).append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
