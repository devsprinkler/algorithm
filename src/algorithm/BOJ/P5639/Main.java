package algorithm.BOJ.P5639;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static class Node {
        int value;
        Node left;
        Node right;

        public Node(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }
    }
    static StringBuilder sb = new StringBuilder();
    public static void postorder(Node curNode) {
        if (curNode != null) {
            postorder(curNode.left);
            postorder(curNode.right);
            sb.append(curNode.value).append("\n");
        }
    }
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String str;
            Node header = new Node(Integer.parseInt(br.readLine()));
            while ((str = br.readLine()) != null && !str.equals("")) {
                Node curNode = header;
                int cur = Integer.parseInt(str);
                while (true) {
                    if (curNode.value < cur) {
                        if (curNode.right == null) {
                            curNode.right = new Node(cur);
                            break;
                        } else {
                            curNode = curNode.right;
                        }
                    } else {
                        if (curNode.left == null) {
                            curNode.left = new Node(cur);
                            break;
                        } else {
                            curNode = curNode.left;
                        }
                    }
                }
            }
            postorder(header);
            System.out.print(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
