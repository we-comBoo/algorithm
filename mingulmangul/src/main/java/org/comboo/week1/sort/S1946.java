package org.comboo.week1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

/*
 * 1946번 신입 사원 : https://www.acmicpc.net/problem/1946
 */
public class S1946 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[][] score = inputScore(br, n);
            System.out.println(recruit(score));
        }
    }

    private static int[][] inputScore(BufferedReader br, int n) throws IOException {
        int[][] score = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
        }
        return score;
    }

    private static int recruit(int[][] score) {
        Arrays.sort(score, Comparator.comparingInt(e -> e[0]));

        int pick = 1;
        int lastRank = score[0][1];

        for (int i = 1; i < score.length; i++) {
            if (score[i][1] < lastRank) {
                pick++;
                lastRank = score[i][1];
            }
            if (lastRank == 1) {
                break;
            }
        }
        return pick;
    }
}
