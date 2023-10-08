package org.comboo.week3.dfsbfs;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;

/**
 * 카카오프렌즈 컬러링북: https://school.programmers.co.kr/learn/courses/30/lessons/1829
 * - 그림을 전체 탐색
 * - 현재 칸이 0이 아니면,
 *   - 영역 개수 1 증가
 *   - 해당 영역을 완전 탐색 (BFS)
 *     - 모든 칸을 0으로 변경
 *     - 영역 내 칸의 개수 계산 (→ 최댓값 갱신)
 */
public class ColoringBook {

	public static void solution() {
		int m = 6;
		int n = 4;
		int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};
		int[] answer = new ColoringBook().solution(m, n, picture);
		System.out.println(Arrays.toString(answer));
	}

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (picture[i][j] > 0) {
					numberOfArea++;
					int size = calcSizeOfArea(i, j, m, n, picture);
					maxSizeOfOneArea = Math.max(size, maxSizeOfOneArea);
				}
			}
		}

		return new int[] {numberOfArea, maxSizeOfOneArea};
	}

	private int calcSizeOfArea(int i, int j, int m, int n, int[][] picture) {
		int[] dx = {0, 0, 1, -1};
		int[] dy = {1, -1, 0, 0};
		Queue<Pair> q = new LinkedList<>();

		int color = picture[i][j];
		int size = 1;
		picture[i][j] = 0;
		q.offer(new Pair(i, j));

		while (!q.isEmpty()) {
			Pair pair = q.poll();
			for (int k = 0; k < 4; k++) {
				int nx = pair.x + dx[k];
				int ny = pair.y + dy[k];

				if (nx >= 0 && nx < m && ny >= 0 && ny < n && picture[nx][ny] == color) {
					size++;
					picture[nx][ny] = 0;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		return size;
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
