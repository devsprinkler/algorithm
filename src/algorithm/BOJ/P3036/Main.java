package algorithm.BOJ.P3036;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static int getGcd(int a, int b) {
        if (a%b == 0) return b;
        return getGcd(b, a%b);
    }

    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        try {
            String str = br.readLine();
            final int n = Integer.parseInt(str);
            str = br.readLine();
            br.close();
            String[] strArr = str.split(" ");
            final int a = Integer.parseInt(strArr[0]);
            int b = 0, gcd = 0;
            for (int i = 1; i < n; i++) {
                b = Integer.parseInt(strArr[i]);
                gcd = getGcd(a, b);
                sb.append(a/gcd).append("/").append(b/gcd).append("\n");
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
