package algorithm.PG.P60063;

import java.util.LinkedList;

public class Main {
    public static int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        int[][] visited = new int[n][n];
        visited[0][0] = visited[0][1] = 1;
        LinkedList<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0,0,0,1,0,0});
        while(!queue.isEmpty()) {
            int ax = queue.peek()[0];
            int ay = queue.peek()[1];
            int bx = queue.peek()[2];
            int by = queue.peek()[3];
            int sec = queue.peek()[4];
            int vert = queue.poll()[5];
            if ((ax == n-1 && ay == n-1) || (bx == n-1 && by == n-1)) {
                answer = sec;
                break;
            }
            if (vert == 0) {
                if (ax+1 < n && bx+1 < n &&
                        board[ax+1][ay] == 0 && board[bx+1][by] == 0 &&
                        (visited[ax+1][ay] != 1 || visited[bx+1][by] != 1) &&
                        (visited[ax+1][ay] != 3 || visited[bx+1][by] != 3)) {
                    visited[ax+1][ay] = visited[ax+1][ay] == 0 ? 1 : visited[ax+1][ay] == 2 ? 3 : visited[ax+1][ay];
                    visited[bx+1][by] = visited[bx+1][by] == 0 ? 1 : visited[bx+1][by] == 2 ? 3 : visited[bx+1][by];
                    queue.offer(new int[] {ax+1, ay, bx+1, by, sec+1, 0});
                }
                if (ax-1 >= 0 && bx-1 >= 0 &&
                        board[ax-1][ay] == 0 && board[bx-1][by] == 0 &&
                        (visited[ax-1][ay] != 1 || visited[bx-1][by] != 1) &&
                        (visited[ax-1][ay] != 3 || visited[bx-1][by] != 3)) {
                    visited[ax-1][ay] = visited[ax-1][ay] == 0 ? 1 : visited[ax-1][ay] == 2 ? 3 : visited[ax-1][ay];
                    visited[bx-1][by] = visited[bx-1][by] == 0 ? 1 : visited[bx-1][by] == 2 ? 3 : visited[bx-1][by];
                    queue.offer(new int[] {ax-1, ay, bx-1, by, sec+1, 0});
                }
                if (ay+1 < n && by+1 < n &&
                        board[ax][ay+1] == 0 && board[bx][by+1] == 0 &&
                        (visited[ax][ay+1] != 1 || visited[bx][by+1] != 1) &&
                        (visited[ax][ay+1] != 3 || visited[bx][by+1] != 3)) {
                    visited[ax][ay+1] = visited[ax][ay+1] == 0 ? 1 : visited[ax][ay+1] == 2 ? 3 : visited[ax][ay+1];
                    visited[bx][by+1] = visited[ax][by+1] == 0 ? 1 : visited[bx][by+1] == 2 ? 3 : visited[bx][by+1];
                    queue.offer(new int[] {ax, ay+1, bx, by+1, sec+1, 0});
                }
                if (ay-1 >= 0 && by-1 >= 0 &&
                        board[ax][ay-1] == 0 && board[bx][by-1] == 0 &&
                        (visited[ax][ay-1] != vert+1 || visited[bx][by-1] != vert+1) &&
                        (visited[ax][ay-1] != 3 || visited[bx][by-1] != 3)) {
                    visited[ax][ay-1] = visited[ax][ay-1] == 0 ? 1 : visited[ax][ay-1] == 2 ? 3 : visited[ax][ay-1];
                    visited[bx][by-1] = visited[ax][by-1] == 0 ? 1 : visited[bx][by-1] == 2 ? 3 : visited[bx][by-1];
                    queue.offer(new int[] {ax, ay-1, bx, by-1, sec+1, 0});
                }
                if (ax-1 >= 0 && bx-1 >= 0 &&
                        board[ax-1][ay] == 0 && board[bx-1][by] == 0) {
                    if ((visited[ax][ay] != 2 || visited[ax-1][ay] != 2) &&
                            (visited[ax][ay] != 3 || visited[ax-1][ay] != 3)) {
                        visited[ax][ay] = 3;
                        visited[ax-1][ay] = visited[ax-1][ay] == 0 ? 2 : visited[ax-1][ay] == 1 ? 3 : visited[ax-1][ay];
                        queue.offer(new int[] {ax, ay, ax-1, by, sec+1, 1});
                    }
                    if ((visited[bx-1][by] != 2 || visited[bx][by] != 2) &&
                            (visited[bx-1][by] != 3 || visited[bx][by] != 3)) {
                        visited[bx][by] = 3;
                        visited[bx-1][by] = visited[bx-1][by] == 0 ? 2 : visited[bx-1][by] == 1 ? 3 : visited[bx-1][by];
                        queue.offer(new int[] {bx, by, bx-1, by, sec+1, 1});
                    }
                }
                if (ax+1 < n && bx+1 < n &&
                        board[ax+1][ay] == 0 && board[bx+1][by] == 0) {
                    if ((visited[ax][ay] != 2 || visited[ax+1][ay] != 2) &&
                            (visited[ax][ay] != 3 || visited[ax+1][ay] != 3)) {
                        visited[ax][ay] = 3;
                        visited[ax+1][ay] = visited[ax+1][ay] == 0 ? 2 : visited[ax+1][ay] == 1 ? 3 : visited[ax+1][ay];
                        queue.offer(new int[] {ax, ay, ax+1, ay, sec+1, 1});
                    }
                    if ((visited[bx+1][by] != 2 || visited[bx][by] != 2) &&
                            (visited[bx+1][by] != 3 || visited[bx][by] != 3)) {
                        visited[bx][by] = 3;
                        visited[bx+1][by] = visited[bx+1][by] == 0 ? 2 : visited[bx+1][by] == 1 ? 3 : visited[bx+1][by];
                        queue.offer(new int[] {bx, by, bx+1, by, sec+1, 1});
                    }
                }
            } else {
                if (ax+1 < n && bx+1 < n &&
                        board[ax+1][ay] == 0 && board[bx+1][by] == 0 &&
                        (visited[ax+1][ay] != 2 || visited[bx+1][by] != 2) &&
                        (visited[ax+1][ay] != 3 || visited[bx+1][by] != 3)) {
                    visited[ax+1][ay] = visited[ax+1][ay] == 0 ? 2 : visited[ax+1][ay] == 1 ? 3 : visited[ax+1][ay];
                    visited[bx+1][by] = visited[bx+1][by] == 0 ? 2 : visited[bx+1][by] == 1 ? 3 : visited[bx+1][by];
                    queue.offer(new int[] {ax+1, ay, bx+1, by, sec+1, vert});
                }
                if (ax-1 >= 0 && bx-1 >= 0 &&
                        board[ax-1][ay] == 0 && board[bx-1][by] == 0 &&
                        (visited[ax-1][ay] != 2 || visited[bx-1][by] != 2) &&
                        (visited[ax-1][ay] != 3 || visited[bx-1][by] != 3)) {
                    visited[ax-1][ay] = visited[ax-1][ay] == 0 ? 2 : visited[ax-1][ay] == 1 ? 3 : visited[ax-1][ay];
                    visited[bx-1][by] = visited[bx-1][by] == 0 ? 2 : visited[bx-1][by] == 1 ? 3 : visited[bx-1][by];
                    queue.offer(new int[] {ax-1, ay, bx-1, by, sec+1, vert});
                }
                if (ay+1 < n && by+1 < n &&
                        board[ax][ay+1] == 0 && board[bx][by+1] == 0 &&
                        (visited[ax][ay+1] != 2 || visited[bx][by+1] != 2) &&
                        (visited[ax][ay+1] != 3 || visited[bx][by+1] != 3)) {
                    visited[ax][ay+1] = visited[ax][ay+1] == 0 ? 2 : visited[ax][ay+1] == 1 ? 3 : visited[ax][ay+1];
                    visited[bx][by+1] = visited[bx][by+1] == 0 ? 2 : visited[bx][by+1] == 1 ? 3 : visited[bx][by+1];
                    queue.offer(new int[] {ax, ay+1, bx, by+1, sec+1, vert});
                }
                if (ay-1 >= 0 && by-1 >= 0 &&
                        board[ax][ay-1] == 0 && board[bx][by-1] == 0 &&
                        (visited[ax][ay-1] != 2 || visited[bx][by-1] != 2) &&
                        (visited[ax][ay-1] != 3 || visited[bx][by-1] != 3)) {
                    visited[ax][ay-1] = visited[ax][ay-1] == 0 ? 2 : visited[ax][ay-1] == 1 ? 3 : visited[ax][ay-1];
                    visited[bx][by-1] = visited[bx][by-1] == 0 ? 2 : visited[bx][by-1] == 1 ? 3 : visited[bx][by-1];
                    queue.offer(new int[] {ax, ay-1, bx, by-1, sec+1, vert});
                }
                if (ay+1 < n && by+1 < n &&
                        board[ax][ay+1] == 0 && board[bx][by+1] == 0) {
                    if ((visited[ax][ay] != 1 || visited[ax][ay+1] != 1) &&
                            (visited[ax][ay] != 3 || visited[ax][ay+1] != 3)) {
                        visited[ax][ay] = 3;
                        visited[ax][ay+1] = visited[ax+1][ay] == 0 ? 1 : visited[ax+1][ay] == 2 ? 3 : visited[ax+1][ay];
                        queue.offer(new int[] {ax, ay, ax, ay+1, sec+1, 0});
                    }
                    if ((visited[bx][ay+1] != 1 || visited[bx][by] != 1) &&
                            (visited[bx][by+1] != 3 || visited[bx][by] != 3)) {
                        visited[bx][by] = 3;
                        visited[bx][by+1] = visited[bx][by+1] == 0 ? 1 : visited[bx][by+1] == 2 ? 3 : visited[bx][by+1];
                        queue.offer(new int[] {bx, by, bx, by+1, sec+1, 0});
                    }
                }
                if (ay-1 >= 0 && by-1 >= 0 &&
                        board[ax][ay-1] == 0 && board[bx][by-1] == 0) {
                    if ((visited[ax][ay] != 2 || visited[ax][ay-1] != 2) &&
                            (visited[ax][ay] != 3 || visited[ax][ay-1] != 3)) {
                        visited[ax][ay] = 3;
                        visited[ax][ay-1] = visited[ax][ay-1] == 0 ? 1 : visited[ax][ay-1] == 2 ? 3 : visited[ax][ay-1];
                        queue.offer(new int[] {ax, ay, ax, ay-1, sec+1, 0});
                    }
                    if ((visited[bx][by-1] != 2 || visited[bx][by] != 2) &&
                            (visited[bx][by-1] != 3 || visited[bx][by] != 3)) {
                        visited[bx][by] = 3;
                        visited[bx][by-1] = visited[bx][by-1] == 0 ? 1 : visited[bx][by-1] == 2 ? 3 : visited[bx][by-1];
                        queue.offer(new int[] {bx, by, bx, by-1, sec+1, 0});
                    }
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        //int[][] board = {{0, 0, 0, 1, 1}, {0, 0, 0, 1, 0},{0, 1, 0, 1, 1},{1, 1, 0, 0, 1},{0, 0, 0, 0, 0}};
        int[][] board = {{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0},{0,0,0,0,0}};
        System.out.println(solution(board));
    }
}
