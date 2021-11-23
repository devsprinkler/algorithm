package algorithm.BOJ.P17471;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            int[] pop = new int[n+1];
            String[] str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                pop[i+1] = Integer.parseInt(str[i]);
            }
            boolean[][] connect = new boolean[n+1][n+1];
            for (int i = 0; i < n; i++) {
                str = br.readLine().split(" ");
                for (int j = 1; j < str.length; j++) {
                    int c = Integer.parseInt(str[j]);
                    connect[i][c] = true;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
