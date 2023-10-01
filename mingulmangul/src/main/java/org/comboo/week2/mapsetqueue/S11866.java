package org.comboo.week2.mapsetqueue;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.LinkedList;
import java.util.Queue;

/*
 * 11866번 요세푸스 문제 0: https://www.acmicpc.net/problem/11866
 *
 */
public class S11866 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            q.add(i);
        }

        StringBuilder sb = new StringBuilder("<");
        while (true) {
            for (int i = 0; i < k - 1; i++) {
                Integer number = q.poll();
                q.add(number);
            }
            sb.append(q.poll());
            if (q.isEmpty()) {
                sb.append(">");
                break;
            }
            sb.append(", ");
        }
        System.out.println(sb);
    }
}
