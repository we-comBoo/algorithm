package org.comboo.week4.backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class S17255 {

	private static String n;
	private static final Set<String> set = new HashSet<>();

	public static void makeNumber(String number, int left, int right) {
		if (left == 0 && right == n.length() - 1) {
			set.add(number);
			return;
		}

		if (left - 1 >= 0) {
			String nextNumber = n.charAt(left - 1) + number;
			makeNumber(number + nextNumber, left - 1, right);
		}
		if (right + 1 < n.length()) {
			String nextNumber = number + n.charAt(right + 1);
			makeNumber(number + nextNumber, left, right + 1);
		}
	}

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = br.readLine();
		for (int i = 0; i < n.length(); i++) {
			makeNumber(n.substring(i, i + 1), i, i);
		}
		System.out.println(set.size());
	}
}
