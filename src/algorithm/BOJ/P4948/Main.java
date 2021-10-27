package algorithm.BOJ.P4948;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static boolean[] sifter(boolean[] arr, int max) {
        arr[0] =  arr[1] = false;
        for (int i = 2; i < max / 2; i++) {
            if (arr[i]) {
                for (int j = i+i; j <= max; j+=i) {
                    arr[j] = false;
                }
            }
        }
        if (arr[max/2]) {
            arr[max] = false;
        }
        return arr;
    }

    public static void main(String[] args) {
        final int MAX = 123456 * 2;
        boolean[] isPrime = new boolean[MAX+1];
        Arrays.fill(isPrime, true);

        isPrime = sifter(isPrime, MAX);

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            for (; ; ) {
                int n = Integer.parseInt(br.readLine());
                if (n == 0) break;
                int cnt = 0;
                for (int i = n + 1; i <= 2 * n; i++) {
                    if (isPrime[i]) {
                        cnt++;
                    }
                }
                sb.append(cnt).append("\n");
            }
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
