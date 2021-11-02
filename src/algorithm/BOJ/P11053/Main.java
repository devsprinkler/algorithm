package algorithm.BOJ.P11053;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] str = br.readLine().split(" ");
            int[] arr = new int[n];
            int[] len = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(str[i]);
                len[i] = Integer.MAX_VALUE;
            }
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (len[j] >= arr[i]) {
                        len[j] = arr[i];
                        break;
                    }
                }
            }
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                if (len[i] < Integer.MAX_VALUE && len[i] > 0)
                    cnt++;
            }
            System.out.println(cnt);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
