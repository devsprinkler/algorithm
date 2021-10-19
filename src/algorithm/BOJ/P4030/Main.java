package algorithm.BOJ.P4030;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) {
        InputStream in = System.in;
        BufferedReader br = new BufferedReader(new InputStreamReader(in));
        StringBuilder sb = new StringBuilder();

        try {
            for (int i = 1; ; i++) {
                String[] line = br.readLine().split(" ");
                int a = Integer.parseInt(line[0]);
                int b = Integer.parseInt(line[1]);
                int cnt = 0;
                if (a == 0) break;
                for( int j=1; j*j<b; j++ ){
                    if(j * j <= a ) continue;
                    int x = (j * j - 1) * 2, y = (int) Math.sqrt(x);
                    if( y * (y + 1) == x ) cnt++;
                }
                sb.append("Case ").append(i).append(": ").append(cnt).append("\n");
            }
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
