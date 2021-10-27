package algorithm.BOJ.P17951;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k, n;
        try {
            String str = br.readLine();
            String[] strArr = str.split(" ");
            n = Integer.parseInt(strArr[0]);
            k = Integer.parseInt(strArr[1]);

            int groupLength =  n / k;
            String str2 = br.readLine();
            String[] strArr2 = str2.split(" ");
            TreeSet<Integer> set = new TreeSet<>();

            int sum = 0;
            int cnt = 0;
            for (int i = 0; i < n; i++) {
                sum += Integer.parseInt(strArr2[i]);
                if (++cnt == groupLength) {
                    set.add(sum);
                    sum = 0;
                    cnt = 0;
                }
            }
            if (cnt > 0) {
                set.add(sum);
            }

            System.out.println(set.first());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
