package algorithm.BOJ.P2805;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            int[] trees = new int[n];

            str = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                trees[i] = Integer.parseInt(str[i]);
            }
            Arrays.sort(trees);
            int max = trees[n - 1];
            int min = 0;
            int threshold;
            int ans = 0;
            while(min <= max) {
                threshold = (max + min) / 2;
                int high = n-1;
                int mid = (n-1)/2;
                int low = 0;
                while(low <= high) {
                    mid = (high + low) / 2;
                    if (trees[mid] < threshold) {
                        low = mid + 1;
                    } else if (trees[mid] > threshold) {
                        high = mid - 1;
                    } else {
                        break;
                    }
                }
                long sum = 0;
                for (int i = Math.max(mid, low); i < n; i++) {
                    sum += trees[i] - threshold;
                }
                if (sum < m) {
                    max = threshold - 1;
                } else if (sum > m) {
                    min = threshold + 1;
                    ans = Math.max(ans, threshold);
                } else {
                    ans = Math.max(ans, threshold);
                    break;
                }
            }
            System.out.println(ans);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
