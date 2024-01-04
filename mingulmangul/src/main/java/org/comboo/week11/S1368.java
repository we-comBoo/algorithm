package org.comboo.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 백준 1368번 물대기: https://www.acmicpc.net/problem/1368
 */
public class S1368 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        for (int i = 0; i < n; i++) {
            int cost = Integer.parseInt(br.readLine());
            pq.add(new Node(i, cost));
        }

        int[][] graph = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                graph[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        boolean[] visited = new boolean[n];

        while (!pq.isEmpty()) {
            Node node = pq.poll();
            if (visited[node.v]) {
                continue;
            }
            answer += node.cost;
            visited[node.v] = true;
            // 다음 노드 탐색
            for (int i = 0; i < n; i++) {
                if (i == node.v) {
                    continue;
                }
                pq.add(new Node(i, graph[node.v][i]));
            }
        }

        System.out.println(answer);
    }

    private static class Node {
        public int v;
        public int cost;

        public Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }
    }
}
