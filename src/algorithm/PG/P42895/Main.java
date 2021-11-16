package algorithm.PG.P42895;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int N = 5;
        int number = 26;

        final int max = 32001;
        int[] arr = new int[max];
        Arrays.fill(arr, 9);
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        for (int i = 0; i <= 9; i++) {
            list.add(new ArrayList<>());
        }

        arr[N] = 1;
        list.get(1).add(N);
        arr[N * 11] = 2;
        list.get(2).add(N * 11);
        arr[N * 111] = 3;
        list.get(3).add(N * 111);
        arr[N * 1111] = 4;
        list.get(4).add(N * 1111);
        if (N < 3) {
            arr[N * 11111] = 5;
            list.get(5).add(N * 11111);
        }

        for (int i = 1; i <= 7; i++) {
            for (int j = 1; j <= i; j++) {
                if (i + j > 8) break;
                for (int x : list.get(i)) {
                    for (int y : list.get(j)) {
                        int sum = x + y;
                        int sub = x - y > 0 ? x - y : y - x;
                        int mul = x * y;
                        int div = x / y >= 1 ? x / y : y / x;
                        if (sum < max && arr[sum] > i + j) {
                            list.get(i + j).add(sum);
                            arr[sum] = i + j;
                        }
                        if (sub != 0 && arr[sub] > i + j) {
                            list.get(i + j).add(sub);
                            arr[sub] = i + j;
                        }
                        if (mul < max && arr[mul] > i + j) {
                            list.get(i + j).add(mul);
                            arr[mul] = i + j;
                        }
                        if (arr[div] > i + j) {
                            list.get(i + j).add(div);
                            arr[div] = i + j;
                        }
                    }
                }
            }
        }

        if (arr[number] == 9) arr[number] = -1;
        System.out.println(arr[number]);
    }
}
