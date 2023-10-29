package org.comboo.week4.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 15811번 복면산: https://www.acmicpc.net/problem/15811
 * - 백트래킹
 * - 각 알파벳에 0~9의 숫자를 차례대로 선택 -> 계산식이 성립하는지 확인
 */
public class S15811 {

	private static final int[] numbers = new int[26];
	private static final boolean[] isUsed = new boolean[10];
	private static String expression;
	private static boolean flag;

	public static boolean isValid() {
		String[] words = expression.split(" ");
		int[] values = new int[3];
		for (int i = 0; i < words.length; i++) {
			int number = 0;
			for (int j = 0; j < words[i].length(); j++) {
				int alphabet = words[i].charAt(j) - 'A';
				number = (number * 10) + numbers[alphabet];
			}
			values[i] = number;
		}
		return values[0] + values[1] == values[2];
	}

	public static void backtracking(int index) {
		if (index == expression.length()) {
			// 계산
			flag = isValid();
			return;
		}

		int alphabet = expression.charAt(index) - 'A';
		if (alphabet < 0 || numbers[alphabet] > 0) {
			backtracking(index + 1);
			return;
		}

		for (int i = 0; i < 10; i++) {
			if (isUsed[i]) {
				continue;
			}

			numbers[alphabet] = i;
			isUsed[i] = true;

			backtracking(index + 1);

			if (flag) {
				return;
			}

			isUsed[i] = false;
			numbers[alphabet] = 0;
		}
	}

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		expression = br.readLine();
		backtracking(0);
		if (flag) {
			System.out.println("YES");
			return;
		}
		System.out.println("NO");
	}
}
