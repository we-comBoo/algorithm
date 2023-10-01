package org.comboo.week2.mapsetqueue;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * 17299번 오등큰수: https://www.acmicpc.net/problem/17299
 */
public class S17299 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] count = new int[1000001];
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(st.nextToken());
            count[number]++;
            arr[i] = number;
        }

        String[] answer = new String[n];
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int next = arr[i];
            while (!stack.isEmpty()) {
                int topIdx = stack.peek();
                int top = arr[topIdx];
                if (count[top] >= count[next]) {
                    break;
                }
                answer[topIdx] = Integer.toString(next);
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            answer[idx] = "-1";
        }
        System.out.println(String.join(" ", answer));
    }
}
