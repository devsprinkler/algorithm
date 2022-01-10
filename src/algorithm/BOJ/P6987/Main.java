package algorithm.BOJ.P6987;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static boolean backtrack(int[] leaderboard, int[] arr, int a, int b) {
        if (a == 5) {
            return possible(leaderboard, arr, a);
        }
        if (b > 5) {
            if (possible(leaderboard, arr, a)) {
                return backtrack(leaderboard, arr.clone(), a + 1, a + 2);
            }
            return false;
        }
        int[] newArr1 = arr.clone();
        newArr1[a*3]++;
        newArr1[b*3+2]++;
        if (backtrack(leaderboard, newArr1, a, b+1)) {
            return true;
        }
        int[] newArr2 = arr.clone();
        newArr2[a*3+1]++;
        newArr2[b*3+1]++;
        if (backtrack(leaderboard, newArr2, a, b+1)) {
            return true;
        }
        int[] newArr3 = arr.clone();
        newArr3[a*3+2]++;
        newArr3[b*3]++;
        return backtrack(leaderboard, newArr3, a, b+1);
    }
    public static boolean possible(int[] leaderboard, int[] arr, int a) {
        for (int i = 0; i < (a+1)*3; i++) {
            if (leaderboard[i] != arr[i]) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringBuilder sb = new StringBuilder();
            for (int t = 0; t < 4; t++) {
                String[] str = br.readLine().split(" ");
                int[] leaderboard = new int[18];
                for (int i = 0; i < 6; i++) {
                    leaderboard[i*3] = Integer.parseInt(str[i*3]);
                    leaderboard[i*3+1] = Integer.parseInt(str[i*3+1]);
                    leaderboard[i*3+2] = Integer.parseInt(str[i*3+2]);
                }
                boolean possible = backtrack(leaderboard, new int[18], 0, 1);
                sb.append(possible ? 1 : 0).append(" ");
            }
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
// 4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
// 5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
// 5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4

// 1 1 0 0