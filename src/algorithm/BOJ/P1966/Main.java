package algorithm.BOJ.P1966;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int t = Integer.parseInt(br.readLine());
            StringBuilder sb = new StringBuilder();
            while (t-- > 0) {
                String[] str = br.readLine().split(" ");
                int n = Integer.parseInt(str[0]);
                int m = Integer.parseInt(str[1]);
                int[] docs = new int[n];
                int[] numOfDocs = new int[10];
                LinkedList<Integer> queue = new LinkedList<>();

                str = br.readLine().split(" ");
                for (int i = 0; i < n; i++) {
                    docs[i] = Integer.parseInt(str[i]);
                    numOfDocs[docs[i]]++;
                    queue.offer(i);
                }

                int biggest = 9;
                for(; numOfDocs[biggest] == 0; biggest--);
                int cnt = 0;
                while(!queue.isEmpty()) {
                    int idx = queue.poll();
                    if (biggest == docs[idx]) {
                        cnt++;
                        if (--numOfDocs[biggest] == 0) {
                            for(; biggest > 1 && numOfDocs[biggest] == 0; biggest--);
                        }
                        if (idx == m) {
                            break;
                        }
                    } else {
                        queue.offer(idx);
                    }
                }
                sb.append(cnt).append("\n");
            }
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
