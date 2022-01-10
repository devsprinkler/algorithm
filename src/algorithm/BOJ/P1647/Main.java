package algorithm.BOJ.P1647;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] parent;
    static class Road implements Comparable<Road> {
        int start, end, cost;

        public Road(int start, int end, int cost) {
            this.start = start;
            this.end = end;
            this.cost = cost;
        }

        @Override
        public int compareTo(Road o) {
            return Integer.compare(this.cost, o.cost);
        }
    }
    static void weightedUnion(int i, int j) {
        int t = parent[i] + parent[j];
        if (parent[i] > parent[j]) {
            parent[i] = j;
            parent[j] = t;
        } else {
            parent[j] = i;
            parent[i] = t;
        }
    }
    static int collapsingFind(int x) {
        if (parent[x] < 0) {
            return x;
        }
        return parent[x] = collapsingFind(parent[x]);
    }
    public static void main(String[] args) {
        try {
            BufferedReader br =
                    new BufferedReader(new InputStreamReader(System.in));
            String[] str = br.readLine().split(" ");
            int n = Integer.parseInt(str[0]);
            int m = Integer.parseInt(str[1]);
            Road[] roads = new Road[m];
            parent = new int[n+1];
            Arrays.fill(parent, -1);
            for (int i = 0; i < m; i++) {
                str = br.readLine().split(" ");
                roads[i] = new Road(Integer.parseInt(str[0]),
                        Integer.parseInt(str[1]), Integer.parseInt(str[2]));
            }
            Arrays.sort(roads);
            int cost = 0;
            for (int i = 0; i < m; i++) {
                int a = collapsingFind(roads[i].start);
                int b = collapsingFind(roads[i].end);
                if (a != b) {
                    cost += roads[i].cost;
                    weightedUnion(a, b);
                }
                if (Math.min(parent[a], parent[b]) == -n) {
                    System.out.println(cost-roads[i].cost);
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

// 7 12
// 1 2 3
// 1 3 2
// 3 2 1
// 2 5 2
// 3 4 4
// 7 3 6
// 5 1 5
// 1 6 2
// 6 4 1
// 6 5 3
// 4 5 3
// 6 7 4

// 8