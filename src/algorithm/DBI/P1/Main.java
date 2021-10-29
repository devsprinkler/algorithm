package algorithm.DBI.P1;

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
            int k = Integer.parseInt(st.nextToken());

            str = br.readLine();
            st = new StringTokenizer(str);

            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            Arrays.sort(arr);

            System.out.println(arr[n-1] * (m/k*k) + arr[n-2] * (m%k));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
