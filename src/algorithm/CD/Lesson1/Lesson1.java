package algorithm.CD.Lesson1;

public class Lesson1 {
    public static void main(String[] args) {
        int N = 9;
        int max = 0;
        int cnt = 0;
        while(N > 0) {
            if (N % 2 == 0) {
                cnt++;
            } else {
                max = Math.max(max, cnt);
                cnt = 0;
            }
            N = N >> 1;
        }
        System.out.println(max);
    }
}
