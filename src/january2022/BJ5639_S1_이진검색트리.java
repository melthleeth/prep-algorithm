package january2022;

import java.io.*;
import java.util.*;

public class BJ5639_S1_이진검색트리 {
    static Node node;
    static int rootVal;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String input = br.readLine();
        node = new Node(Integer.parseInt(input), Integer.MIN_VALUE, Integer.MAX_VALUE); // node 초기화
        rootVal = node.val;

        while ((input = br.readLine()) != null && !input.isEmpty()) {
            int val = Integer.parseInt(input);
            System.out.println("### current = " + node.val);
            if (val < node.val) {
                while (node.left != null) {
                    node.left.parent = node;
                    node = node.left;
                }

                if (val < node.val) {
                    System.out.println("l) current: " + node.val + ", val = " + val);
                    node.left = new Node(val, node.min, node.val);
                    node.left.parent = node;
                } else {
                    System.out.println("r) current: " + node.val + ", val = " + val);
                    node.right = new Node(val, node.val, node.max);
                    node.right.parent = node;
                }
            } else {
                if (val > node.max) { // 거슬러 올라가는 경우
                    while (node.parent.right != null || val > node.max) {
                        node = node.parent;
                        if (node.val == rootVal) break;
                    }
                } else if (node.right != null) { // 내려가는 경우
                    node = node.right;
                }

                System.out.println("r) current: " + node.val + ", val = " + val);
                node.right = new Node(val, node.val, node.max);
                node.right.parent = node;

                if (node.val == rootVal && node.right != null)
                    node = node.right;
            }
        }
        while (node.val != rootVal)
            node = node.parent;

        postOrder(node);

        br.close();
    }

    public static void postOrder(Node current) {
        if (current == null) return;

        postOrder(current.left);
        postOrder(current.right);

        System.out.println(current.val);
    }

    static class Node {
        int val;
        int min;
        int max;
        Node parent;
        Node left;
        Node right;

        public Node(int val, int min, int max) {
            this.val = val;
            this.min = min;
            this.max = max;
            parent = left = right = null;
        }

    }
}
