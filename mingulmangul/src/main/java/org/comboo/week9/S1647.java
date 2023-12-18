package org.comboo.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1647번 도시 분할 계획: https://www.acmicpc.net/problem/1647
 */
public class S1647 {

    private static int[] parent;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        if (n == 2) {
            System.out.println(0);
            return;
        }

        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.add(new Node(from, to, weight));
        }

        graph.sort(Comparator.comparingInt(o -> o.weight));
        int answer = 0;
        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }
        for (Node node : graph) {
            if (find(node.from) == find(node.to)) {
                continue;
            }
            union(node.from, node.to);
            answer += node.weight;
            n--;
            if (n == 2) {
                break;
            }
        }
        System.out.println(answer);
    }

    private static int find(int x) {
        if (parent[x] == x) {
            return x;
        }
        parent[x] = find(parent[x]);
        return parent[x];
    }

    private static void union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == a) {
            parent[pb] = pa;
        } else {
            parent[pa] = pb;
        }
    }

    public static class Node {
        public int from;
        public int to;
        public int weight;

        public Node(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}
