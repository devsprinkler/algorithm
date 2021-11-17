package algorithm.PG.P17678;

import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        int n = 16;
        int t = 60;
        int m = 2;
        String[] timetable = {"23:59"};
        int[] crew = new int[timetable.length];
        for (int i = 0; i < timetable.length; i++) {
            String[] str = timetable[i].split(":");
            crew[i] = Integer.parseInt(str[0]) * 60 + Integer.parseInt(str[1]);
        }
        Arrays.sort(crew);
        LinkedList<Integer> queue = new LinkedList<>();
        for (int i = 0; i < crew.length; i++) {
            queue.offer(crew[i]);
        }

        int max = n * m;
        int nextBus = 540;
        int ans = nextBus;

        int seq = 1;
        int cnt = 0;
        while(!queue.isEmpty()) {
            int cur = queue.peek();
            if (cur > nextBus || cnt == m) {
                if (seq == n) {
                    break;
                }
                max -= m;
                nextBus += t;
                cnt = 0;
                seq++;
            } else {
                queue.poll();
                cnt++;
            }
            if (cnt >= max) {
                ans = cur - 1;
                break;
            }
        }

        if (cnt < max) {
            ans = nextBus;
        }
        if (ans == 1440) {
            ans--;
        }

        int hour = (ans - (ans % 60) ) / 60;
        int minute = ans % 60;
        System.out.println(String.format("%02d:%02d", hour, minute));
    }
}
