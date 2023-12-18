package org.comboo.week7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/**
 * 백준 16401번 과자 나눠주기: https://www.acmicpc.net/problem/16401
 * - 이분탐색
 * - 과자 길이
 * 	- 최소: 가장 긴 과자 길이 / M
 * 	- 최대: 가장 긴 과자 길이
 * - 탐색
 *  - 과자 길이 l -> 내림차순으로 모든 과자 탐색 & M개의 과자를 만들 수 있는지 확인
 */
public class S16401 {

	public static void solution() throws IOException {
		// 입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		Integer[] snacks = new Integer[n];
		int totalSnackLength = 0;
		for (int i = 0; i < n; i++) {
			int l = Integer.parseInt(st.nextToken());
			snacks[i] = l;
			totalSnackLength += l;
		}

		// 연산
		Arrays.sort(snacks, Comparator.reverseOrder()); // 내림차순 정렬
		int minLen = snacks[0] / m;
		int maxLen = snacks[0];

		while (minLen <= maxLen) {
			int mid = (minLen + maxLen) / 2;

			// m명에게 나눠줄 수 있는지 확인
			if (mid == 0) {
				maxLen = 0;
				break;
			}
			boolean isValid = check(snacks, m, mid);

			// 탐색 위치 이동
			if (isValid) {
				minLen = mid + 1;
			} else {
				maxLen = mid - 1;
			}
		}
		System.out.println(maxLen);
	}

	private static boolean check(Integer[] snacks, int m, int l) {
		int curM = 0;
		for (Integer snack : snacks) {
			curM += (snack / l);
			if (curM >= m) {
				return true;
			}
		}
		return false;
	}
}
