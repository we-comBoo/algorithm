package org.comboo.week1.sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/*
 * 좌표 정렬하기 2: https://www.acmicpc.net/problem/11651
 */
public class S11651 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (e1, e2) -> {
            if (e1[1] == e2[1]) {
                return e1[0] - e2[0];
            }
            return e1[1] - e2[1];
        });

        StringBuilder sb = new StringBuilder();
        for (int[] e : arr) {
            sb.append(e[0] + " " + e[1] + "\n");
        }
        System.out.println(sb);
    }
}
