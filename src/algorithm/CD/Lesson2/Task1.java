package algorithm.CD.Lesson2;

public class Task1 {
    public static int[] solution(int[] A, int K) {
        int N = A.length;
        if (N * K == 0) {
            return A;
        }
        int[] ans = new int[N];
        if (K > N) {
            K = K % N;
        }
        for (int i = 0; i + K < N; i++) {
            ans[i + K] = A[i];
        }
        for (int i = N - K; i < N; i++) {
            ans[i - N + K] = A[i];
        }
        return ans;
    }
    public static void main(String[] args) {
        int[] A = {3, 8, 9, 7, 6};
        int K = 3;
        int[] ans = solution(A, K);
        StringBuilder sb = new StringBuilder();
        for (int n: ans) {
            sb.append(n).append(" ");
        }
        System.out.println(sb);
    }
}
