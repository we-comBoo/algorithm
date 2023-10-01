package org.comboo.week2.mapsetqueue;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

/*
 * 18115번 카드 놓기: https://www.acmicpc.net/problem/18115
 */
public class S18115 {

    /**
     * 1. 수열 A를 거꾸로 탐색 (마지막에 사용한 기술부터)
     * 2. 기술을 사용하기 전 카드 상태 계산 (덱 사용)
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <= n; i++) {
            int elem = arr[i - 1];
            if (elem == 1) {
                deque.offerFirst(i);
            } else if (elem == 2) {
                Integer first = deque.pollFirst();
                deque.offerFirst(i);
                deque.offerFirst(first);
            } else {
                deque.offerLast(i);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (Integer i : deque) {
            sb.append(i).append(" ");
        }
        System.out.println(sb);
    }
}
