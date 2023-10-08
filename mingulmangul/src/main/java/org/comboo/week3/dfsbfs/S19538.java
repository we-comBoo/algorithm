package org.comboo.week3.dfsbfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * 19538번 루머: https://www.acmicpc.net/problem/19538
 * - S = 루머를 믿는 집단
 * - for each p in S
 *   - p의 주변인 관계 탐색
 *   - p의 주변인은 자신의 주변인 중 절반 이상이 루머를 믿는 경우, 루머를 믿음
 */
public class S19538 {

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());

		int[] results = new int[n + 1];  // 루머를 믿기 시작한 시간
		Arrays.fill(results, -1);
		List<List<Integer>> network = new ArrayList<>();  // 주변인 관계 (인접 리스트)
		for (int i = 0; i <= n; i++) {
			network.add(new ArrayList<>());
		}

		// 주변인 관계 입력
		for (int person1 = 1; person1 <= n; person1++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int person2;
			while ((person2 = Integer.parseInt(st.nextToken())) != 0) {
				network.get(person1).add(person2);
				network.get(person2).add(person1);
			}
		}

		// 루머를 믿을 때까지 남은 사람 수
		int[] remain = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			remain[i] = (network.get(i).size() + 1) / 2;
		}

		// 최초 유포자 입력
		Queue<Integer> q = new LinkedList<>();
		int m = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 0; i < m; i++) {
			int distributor = Integer.parseInt(st.nextToken());
			results[distributor] = 0;
			remain[distributor] = 0;
			q.offer(distributor);
		}

		// 루머 유포
		while (!q.isEmpty()) {
			Integer distributor = q.poll();
			List<Integer> around = network.get(distributor);
			for (Integer person : around) {
				if (--remain[person] == 0) {  // 루머를 믿음
					results[person] = results[distributor] + 1;
					q.offer(person);
				}
			}
		}

		// 출력
		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			sb.append(results[i]).append(" ");
		}
		System.out.println(sb);
	}
}
