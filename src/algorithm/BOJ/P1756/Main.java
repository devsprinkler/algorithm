package algorithm.BOJ.P1756;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            ArrayList<Integer> list = new ArrayList<>();
            list.add(0);
            int[] oven = new int[d+2];
            int min = 1000000000;
            oven[0] = min;
            oven[d+1] = 0;
            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= d; i++) {
                int o = Integer.parseInt(st.nextToken());
                if (o < min) {
                    list.add(i);
                    min = o;
                }
                oven[i] = min;
            }
            list.add(d+1);
            int bottom = d+1;
            st = new StringTokenizer(br.readLine());
            Collections.reverse(list);
            for (int i = 0; i < n; i++) {
                int dough = Integer.parseInt(st.nextToken());
                if (oven[bottom] >= dough) {
                    bottom--;
                } else {
                    while(oven[list.get(0)] < dough) {
                        bottom = list.get(0) - 1;
                        list.remove(0);
                    }
                }
            }
            System.out.println(bottom);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
