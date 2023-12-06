package org.comboo.week7;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * 백준 17266번 어두운 굴다리: https://www.acmicpc.net/problem/17266
 * - 이진탐색
 * - 가로등 높이
 * 	 - 최소: max(첫 가로등 위치, 굴다리 길이 - 마지막 가로등 위치)
 * 	 - 최대: 굴다리 길이 / 2 + 1
 */
public class S17266 {

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine()); // 굴다리 길이
		int m = Integer.parseInt(br.readLine()); // 가로등 개수
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] lamps = new int[m]; // 가로등 위치
		int maxDiff = 0;
		for (int i = 0; i < m; i++) {
			lamps[i] = Integer.parseInt(st.nextToken());
			if (i == 0) {
				maxDiff = lamps[i];
				continue;
			}
			int diff = (lamps[i] - lamps[i - 1] + 1) / 2;
			if (diff > maxDiff) {
				maxDiff = diff;
			}
		}
		int diff = n - lamps[m - 1];
		if (diff > maxDiff) {
			maxDiff = diff;
		}
		System.out.println(maxDiff);
	}
}
