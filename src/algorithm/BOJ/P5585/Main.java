package algorithm.BOJ.P5585;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MAX = 1000;
        int n = MAX - sc.nextInt();
        int res = 0;

        res += n / 500;
        n %= 500;
        res += n / 100;
        n %= 100;
        res += n / 50;
        n %= 50;
        res += n / 10;
        n %= 10;
        res += n / 5;
        n %= 5;
        res += n;

        System.out.println(res);
    }
}
