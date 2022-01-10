package algorithm.BOJ.P17141;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
    public static ArrayList<int[]> combinations;
    public static void getCombination(int n, int r, int[] arr, int t, int i) {
        if (r == 0) {
            combinations.add(arr);
        } else if (t < n) {
            arr[i] = t;
            getCombination(n, r-1, arr.clone(), t+1, i+1);
            getCombination(n, r, arr.clone(), t+1, i);
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);

            int[][] map = new int[n][n];
            ArrayList<int[]> virus = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                str = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(str[j]);
                    if (map[i][j] == 2) {
                        virus.add(new int[] {i, j});
                    }
                }
            }
            combinations = new ArrayList<>();
            getCombination(virus.size(), m, new int[m], 0, 0);
            LinkedList<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][n];
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < combinations.size(); i++) {
                for (int j = 0; j < n; j++) {
                    Arrays.fill(visited[j], false);
                }
                queue.clear();
                for (int c : combinations.get(i)) {
                    int[] pos = virus.get(c);
                    visited[pos[0]][pos[1]] = true;
                    queue.offer(pos);
                }
                int cnt = 0;
                while(!queue.isEmpty()&&cnt<ans) {
                    cnt++;
                    int limit = queue.size();
                    for (int j = 0; j < limit; j++) {
                        int[] cur = queue.poll();
                        int row = cur[0];
                        int col = cur[1];
                        if (row < n-1 && !visited[row+1][col] && map[row+1][col] != 1) {
                            visited[row+1][col] = true;
                            queue.offer(new int[] {row+1, col});
                        }
                        if (row > 0 && !visited[row-1][col] && map[row-1][col] != 1) {
                            visited[row-1][col] = true;
                            queue.offer(new int[] {row-1, col});
                        }
                        if (col < n-1 && !visited[row][col+1] && map[row][col+1] != 1) {
                            visited[row][col+1] = true;
                            queue.offer(new int[] {row, col+1});
                        }
                        if (col > 0 && !visited[row][col-1] && map[row][col-1] != 1) {
                            visited[row][col-1] = true;
                            queue.offer(new int[] {row, col-1});
                        }
                    }
                }

                for (int j = 0; j < n; j++) {
                    for (int k = 0; k < n; k++) {
                        if (!visited[j][k] && map[j][k] != 1) {
                            cnt = -1;
                            j = n;
                            break;
                        }
                    }
                }
                if (cnt != -1) {
                    ans = Math.min(ans, cnt);
                }
            }
            if (ans == Integer.MAX_VALUE) System.out.println(-1);
            else System.out.println(ans - 1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}