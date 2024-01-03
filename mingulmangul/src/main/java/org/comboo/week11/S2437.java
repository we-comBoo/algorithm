package org.comboo.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 백준 2437번 저울: https://www.acmicpc.net/problem/2437
 */
public class S2437 {
    
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        // 정렬
        Arrays.sort(numbers);
        // 누적합 계산
        long sum = 0;
        for (int i = 0; i < n; i++) {
            if (sum + 1 < numbers[i]) {
                break;
            }
            sum += numbers[i];
        }
        // 출력
        System.out.println(sum + 1);
    }
}
