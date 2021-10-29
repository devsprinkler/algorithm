package algorithm.DBI.P2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str);
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] min = new int[n];

            for (int i = 0; i < n; i++) {
                str = br.readLine();
                st = new StringTokenizer(str);
                int[] arr = new int[m];
                for (int j = 0; j < m; j++) {
                    arr[j] = Integer.parseInt(st.nextToken());
                }
                Arrays.sort(arr);
                min[i] = arr[0];
            }
            Arrays.sort(min);
            System.out.println(min[n - 1]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
