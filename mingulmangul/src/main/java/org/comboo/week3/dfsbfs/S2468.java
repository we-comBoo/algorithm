package org.comboo.week3.dfsbfs;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 2468번 안전 영역: https://www.acmicpc.net/problem/2468
 * - 안전한 영역의 최대 개수 <- 1 (아무 지역도 물에 잠기지 않는 경우)
 * - 물에 잠기는 높이 <- 1 ~ 99 (최대 높이가 100이므로)
 *   - 해당 높이에 대해 전체 지역 탐색
 *     - 현재 지역이 안전하면, 연결된 영역 완전 탐색 (BFS)
 *       - 탐색한 지역 방문 체크
 *       - 안전한 영역 개수 1 증가
 *   - 안전한 영역 개수가 0이면 반복 종료
 *   - 안전한 영역의 최대 개수 갱신
 */
public class S2468 {

	public static void solution() throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int[][] area = new int[n][n];
		for (int i = 0; i < n; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int j = 0; j < n; j++) {
				area[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int maxCountOfSafeArea = 1;
		for (int height = 1; height < 100; height++) {
			int count = calcCountOfSafeArea(height, n, area);
			if (count == 0) {
				break;
			}
			if (maxCountOfSafeArea < count) {
				maxCountOfSafeArea = count;
			}
		}
		System.out.println(maxCountOfSafeArea);
	}

	private static int calcCountOfSafeArea(int height, int n, int[][] area) {
		int count = 0;
		boolean[][] visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (area[i][j] > height && !visited[i][j]) {
					Queue<Pair> q = new LinkedList<>();
					visited[i][j] = true;
					q.offer(new Pair(i, j));
					bfs(height, n, area, visited, q);
					count++;
				}
			}
		}
		return count;
	}

	private static void bfs(int height, int n, int[][] area, boolean[][] visited, Queue<Pair> q) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};

		while (!q.isEmpty()) {
			Pair pair = q.poll();

			for (int i = 0; i < 4; i++) {
				int nx = pair.x + dx[i];
				int ny = pair.y + dy[i];

				if (nx >= 0 && nx < n && ny >= 0 && ny < n && area[nx][ny] > height && !visited[nx][ny]) {
					visited[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
	}

	private static class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}
}
