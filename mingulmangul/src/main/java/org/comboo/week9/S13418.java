package org.comboo.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 13418번 학교 탐방하기 : https://www.acmicpc.net/problem/13418
 */
public class S13418 {

    private static int[] parent;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        parent = new int[n + 1];

        int upCount = 0;
        List<Node> graph = new ArrayList<>();
        for (int i = 0; i < m + 1; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int type = Integer.parseInt(st.nextToken());
            if (i == 0) {
                upCount = 1 - type;
                continue;
            }
            graph.add(new Node(from, to, type));
        }

        graph.sort(Comparator.comparingInt(node -> node.type));
        initParent(n);
        int maximum = calcUpCount(n, graph) + upCount;
        maximum *= maximum;

        Collections.reverse(graph);
        initParent(n);
        int minimum = calcUpCount(n, graph) + upCount;
        minimum *= minimum;

        System.out.println(maximum - minimum);
    }

    private static int calcUpCount(int n, List<Node> graph) {
        int upCount = 0;
        int edgeCount = 0;
        for (Node node : graph) {
            if (find(node.from) == find(node.to)) {
                continue;
            }
            union(node.from, node.to);
            upCount += 1 - node.type;
            if (++edgeCount == n - 1) {
                break;
            }
        }
        return upCount;
    }

    private static void initParent(int n) {
        for (int i = 1; i < n + 1; i++) {
            parent[i] = i;
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

        if (pb == b) {
            parent[pa] = pb;
        } else {
            parent[pb] = pa;
        }
    }

    private static class Node {
        public int from;
        public int to;
        public int type;

        public Node(int from, int to, int type) {
            this.from = from;
            this.to = to;
            this.type = type;
        }
    }
}
