package algorithm.BOJ.P2193;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            int length = Integer.parseInt(br.readLine());
            long[] fibonacci = new long[length + 1];
            fibonacci[1] = 1;
            for (int i = 2; i <= length; i++) {
                fibonacci[i] = fibonacci[i - 1] + fibonacci[i - 2];
            }
            System.out.println(fibonacci[length]);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
