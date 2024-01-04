package org.comboo.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 1774번 우주신과의 교감: https://www.acmicpc.net/problem/1774
 */
public class S1774 {

    private static int[] parent;
    private static double[][] nodes;

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        nodes = new double[n + 1][2];
        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());
            nodes[i][0] = Double.parseDouble(st.nextToken());
            nodes[i][1] = Double.parseDouble(st.nextToken());
        }

        List<Edge> edges = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            for (int j = i + 1; j <= n; j++) {
                double dist = calcDist(i, j);
                edges.add(new Edge(i, j, dist));
            }
        }
        Collections.sort(edges);

        int count = 0;
        double answer = 0;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (find(a) != find(b)) {
                union(a, b);
                count++;
            }
        }

        for (Edge edge : edges) {
            if (count >= n - 1) {
                break;
            }
            if (find(edge.a) == find(edge.b)) {
                continue;
            }
            union(edge.a, edge.b);
            count++;
            answer += edge.dist;
        }

        System.out.printf("%.2f%n", answer);
    }

    private static double calcDist(int a, int b) {
        return Math.sqrt(Math.pow(nodes[a][0] - nodes[b][0], 2) + Math.pow(nodes[a][1] - nodes[b][1], 2));
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
        parent[pb] = pa;
    }

    private static class Edge implements Comparable<Edge> {
        public int a;
        public int b;
        public double dist;

        public Edge(int a, int b, double dist) {
            this.a = a;
            this.b = b;
            this.dist = dist;
        }

        @Override
        public int compareTo(Edge o) {
            return Double.compare(this.dist, o.dist);
        }
    }
}
