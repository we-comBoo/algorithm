package org.comboo.week1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

/*
 * 1946번 신입 사원 : https://www.acmicpc.net/problem/1946
 * 코드 개선
 *  - 동석차가 없기 때문에 순위를 인덱스로 사용 가능!!
 *   => 정렬할 필요가 없어져서 시간 단축^^ (3272ms -> 876ms)
 */
public class S1946 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] score = inputScore(br, n);
            System.out.println(recruit(score));
        }
    }

    private static int[] inputScore(BufferedReader br, int n) throws IOException {
        int[] score = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int idx = Integer.parseInt(st.nextToken()) - 1;
            int value = Integer.parseInt(st.nextToken());
            score[idx] = value;
        }
        return score;
    }

    private static int recruit(int[] score) {
        int pick = 1;
        int lastRank = score[0];

        for (int i = 1; i < score.length; i++) {
            if (score[i] < lastRank) {
                pick++;
                lastRank = score[i];
            }
            if (lastRank == 1) {
                break;
            }
        }
        return pick;
    }
}
