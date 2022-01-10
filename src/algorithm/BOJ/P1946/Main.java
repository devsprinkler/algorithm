package algorithm.BOJ.P1946;

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
                int[] arr = new int[n+1];
                for (int i = 0; i < n; i++) {
                    String[] str = br.readLine().split(" ");
                    int a = Integer.parseInt(str[0]);
                    int b = Integer.parseInt(str[1]);
                    arr[a] = b;
                }
                int max = arr[1];
                int cnt = 1;
                for (int i = 2; max > 1; i++) {
                    if (arr[i] < max) {
                        max = arr[i];
                        cnt++;
                    }
                }
                sb.append(cnt).append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
