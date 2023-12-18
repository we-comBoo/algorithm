package org.comboo.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 백준 21924번 도시 건설 : https://www.acmicpc.net/problem/21924
 */
public class S21924 {
    private static int[] parent;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        List<Node> graph = new ArrayList<>();
        long maximum = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            maximum += weight;
            graph.add(new Node(from, to, weight));
        }
        System.out.println(maximum);

        parent = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
        }

        graph.sort(Comparator.comparingInt(o -> o.weight));
        long minimum = 0;
        int count = 0;
        for (Node node : graph) {
            if (find(node.from) == find(node.to)) {
                continue;
            }
            System.out.println(node.from + " " + node.to + " " + node.weight);
            union(node.from, node.to);
            minimum += node.weight;
            if (++count == n - 1) {
                break;
            }
        }

        if (count < n - 1) {
            System.out.println(-1);
        } else {
            System.out.println(maximum - minimum);
        }
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
