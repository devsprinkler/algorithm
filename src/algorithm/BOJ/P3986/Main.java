package algorithm.BOJ.P3986;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(br.readLine());
            String[] words = new String[n];
            int count = 0;
            Stack<Character> stack = new Stack<>();
            char[] word;
            for (int i = 0; i < n; i++) {
                words[i] = br.readLine();
                stack.clear();
                word = words[i].toCharArray();
                for (int j = 0; j < word.length; j++) {
                    if (word[j] == 'A') {
                        if (!stack.isEmpty() && stack.peek() == 'A') {
                            stack.pop();
                        } else {
                            stack.push('A');
                        }
                    } else {
                        if (!stack.isEmpty() && stack.peek() == 'B') {
                            stack.pop();
                        } else {
                            stack.push('B');
                        }
                    }
                }
                if (stack.isEmpty()) {
                    count++;
                }
            }
            System.out.println(count);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }
}
