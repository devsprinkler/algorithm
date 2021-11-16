package algorithm.BOJ.P9465;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            while(t-- > 0) {
                int n = Integer.parseInt(br.readLine());
                int[][] arr = new int[2][n + 2];
                String[] str = br.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    arr[0][i + 2] = Integer.parseInt(str[i]);
                }
                str = br.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    arr[1][i + 2] = Integer.parseInt(str[i]);
                }

                for (int i = 2; i < n + 2; i++) {
                    arr[0][i] += Math.max(arr[1][i - 2], arr[1][i - 1]);
                    arr[1][i] += Math.max(arr[0][i - 2], arr[0][i - 1]);
                }

                sb.append(Math.max(arr[0][n + 1], arr[1][n + 1])).append("\n");
            }
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
