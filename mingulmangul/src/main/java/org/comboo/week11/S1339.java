package org.comboo.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * 백준 1339번 단어 수학: https://www.acmicpc.net/problem/1339
 */
public class S1339 {

    private static final int[] alpha = new int[26];

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        for (int i = 0; i < n; i++) {
            String words = br.readLine();
            int length = words.length();
            for (int j = 0; j < length; j++) {
                int pow = length - (j + 1);
                int idx = words.charAt(j) - 'A';
                alpha[idx] += Math.pow(10, pow);
            }
        }

        Arrays.sort(alpha);
        int digit = 9;
        int answer = 0;
        for (int i = alpha.length - 1; i >= 0; i--) {
            if (alpha[i] == 0) {
                break;
            }
            answer += alpha[i] * digit;
            digit--;
        }
        System.out.println(answer);
    }
}
