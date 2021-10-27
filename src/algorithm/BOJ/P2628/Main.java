package algorithm.BOJ.P2628;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        try {
            String str = br.readLine();
            String[] strArr = str.split(" ");
            int rowLength = Integer.parseInt(strArr[0]);
            int columnLength = Integer.parseInt(strArr[1]);

            str = br.readLine();
            int n = Integer.parseInt(str);
            int[] rowInterval = new int[n];
            int[] columnInterval = new int[n];

            int r = 0;
            int c = 0;
            for (int i = 0; i < n; i++) {
                str = br.readLine();
                strArr = str.split(" ");
                if (strArr[0].equals("0")) {
                    columnInterval[c++] = Integer.parseInt(strArr[1]);
                } else {
                    rowInterval[r++] = Integer.parseInt(strArr[1]);
                }
            }

            columnInterval = Arrays.copyOf(columnInterval, c);
            rowInterval = Arrays.copyOf(rowInterval, r);
            Arrays.sort(columnInterval);
            Arrays.sort(rowInterval);

            int rowMax = rowLength, columnMax = columnLength;
            if (r > 0) {
                rowMax = rowInterval[0];
            }
            if (c > 0) {
                columnMax = columnInterval[0];
            }
            for (int i = 1; i < r; i++) {
                int interval = rowInterval[i] - rowInterval[i - 1];
                if (rowMax < interval) {
                    rowMax = interval;
                }
            }
            if (r > 0 && rowLength - rowInterval[r - 1] > rowMax) {
                rowMax = rowLength - rowInterval[r - 1];
            }

            for (int i = 1; i < c; i++) {
                int interval = columnInterval[i] - columnInterval[i - 1];
                if (columnMax < interval) {
                    columnMax = interval;
                }
            }
            if (c > 0 && columnLength - columnInterval[c - 1] > columnMax) {
                columnMax = columnLength - columnInterval[c - 1];
            }

            System.out.println(rowMax * columnMax);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
