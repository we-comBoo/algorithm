package org.comboo.week7;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * 백준 17503번 맥주 축제: https://www.acmicpc.net/problem/17503
 */
public class S17503 {

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		Beer[] beers = new Beer[k];
		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int v = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			beers[i] = new Beer(v, c);
		}

		Arrays.sort(beers, (o1, o2) -> {
			if (o1.c == o2.c) {
				return o2.v - o1.v; // 선호도 내림차순
			}
			return o1.c - o2.c; // 도수 오름차순
		});

		System.out.println(calcLevel(beers, n, m));
	}

	private static int calcLevel(Beer[] beers, int n, int m) {
		PriorityQueue<Integer> preferPQ = new PriorityQueue<>();
		int prefer = 0;

		for (Beer beer : beers) {
			prefer += beer.v;
			preferPQ.add(beer.v);

			if (preferPQ.size() > n) {
				Integer polled = preferPQ.poll();
				prefer -= polled;
			}

			if (preferPQ.size() == n && prefer >= m) {
				return beer.c;
			}
		}
		return -1;
	}

	public static class Beer {
		int v;
		int c;

		public Beer(int v, int c) {
			this.v = v;
			this.c = c;
		}
	}
}
