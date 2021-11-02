package algorithm.BOJ.P2824;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static BigInteger getGcd(BigInteger a, BigInteger b) {
        if (b.compareTo(BigInteger.ZERO) == 0) return a;
        return getGcd(b, a.remainder(b));
    }

    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            BigInteger[] arrA = new BigInteger[n];
            for (int i = 0; i < n; i++) {
                arrA[i] = new BigInteger(st.nextToken());
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            BigInteger[] arrB = new BigInteger[m];
            for (int i = 0; i < m; i++) {
                arrB[i] = new BigInteger(st.nextToken());
            }

            BigInteger a = new BigInteger("1");
            for (int i = 0; i < n; i++) {
                a = a.multiply(arrA[i]);
            }

            BigInteger b = new BigInteger("1");
            for (int i = 0; i < m; i++) {
                b = b.multiply(arrB[i]);
            }

            BigInteger res;
            if (a.compareTo(b) > 0) {
                 res = getGcd(a, b);
            } else {
                res = getGcd(b, a);
            }

            String str = res.toString();
            if (str.length() > 9) {
                System.out.println(str.substring(str.length() - 9));
            } else {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
