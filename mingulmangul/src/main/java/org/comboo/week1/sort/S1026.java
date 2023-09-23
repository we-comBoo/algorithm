package org.comboo.week1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

/*
 * 1026번 보물 : https://www.acmicpc.net/problem/1026
 */
public class S1026 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Integer[] A = readArray(N, br.readLine());
        Integer[] B = readArray(N, br.readLine());

        Arrays.sort(A);
        Arrays.sort(B, Collections.reverseOrder());

        int S = 0;
        for (int i = 0; i < N; i++) {
            S += A[i] * B[i];
        }
        System.out.println(S);
    }

    private static Integer[] readArray(int N, String str) {
        StringTokenizer st = new StringTokenizer(str);
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        return arr;
    }
}
