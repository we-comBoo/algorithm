package org.comboo.week3.dfsbfs;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 1012번 유기농 배추: https://www.acmicpc.net/problem/1012
 */
public class S1012 {

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int testCase = Integer.parseInt(br.readLine());

		for (int t = 0; t < testCase; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int n = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());

			boolean[][] field = new boolean[n][m];
			for (int i = 0; i < k; i++) {
				st = new StringTokenizer(br.readLine());
				int x = Integer.parseInt(st.nextToken());
				int y = Integer.parseInt(st.nextToken());
				field[y][x] = true;
			}

			if (k == 1) {
				System.out.println(1);
				continue;
			}

			int answer = 0;
			Queue<Pair> q = new LinkedList<>();
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < m; j++) {
					if (field[i][j]) {
						field[i][j] = false;
						q.offer(new Pair(i, j));
						bfs(n, m, field, q);
						answer++;
					}
				}
			}
			System.out.println(answer);
		}
	}

	private static void bfs(int n, int m, boolean[][] field, Queue<Pair> q) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		while (!q.isEmpty()) {
			Pair pair = q.poll();

			for (int l = 0; l < 4; l++) {
				int nx = pair.x + dx[l];
				int ny = pair.y + dy[l];

				if (nx >= 0 && nx < n && ny >= 0 && ny < m && field[nx][ny]) {
					field[nx][ny] = false;
					q.offer(new Pair(nx, ny));
				}
			}
		}
	}

	private static class Pair {
		private int x;
		private int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
