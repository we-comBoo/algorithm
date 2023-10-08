package org.comboo.week3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.List;
import java.util.ArrayList;

/**
 * 11725번 트리의 부모 찾기 : https://www.acmicpc.net/problem/11725
 * - 그래프 구현 (인접 리스트)
 * - 그래프 완전 탐색 (DFS)
 *   - 현재 노드의 자식 노드의 부모 노드를 현재 노드로 설정
 *   - 다음 노드 탐색 (자식 노드)
 */
public class S11725 {

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		// 초기화
		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}

		// 그래프 입력
		for (int i = 0; i < n - 1; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph.get(a).add(b);
			graph.get(b).add(a);
		}

		// 그래프 탐색 (DFS)
		int[] answer = new int[n + 1];
		answer[1] = 1;
		dfs(1, graph, answer);

		// 그래프 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 2; i < n + 1; i++) {
			sb.append(answer[i]).append("\n");
		}
		System.out.println(sb);
	}

	private static void dfs(int parent, List<List<Integer>> graph, int[] answer) {
		List<Integer> childList = graph.get(parent);
		for (Integer child : childList) {
			if (answer[child] != 0) {    // 이미 방문한 노드
				continue;
			}
			answer[child] = parent;
			dfs(child, graph, answer);    // 다음 노드 탐색
		}
	}
}
