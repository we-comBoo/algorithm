package org.comboo.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 백준 1213번 팰린드롬 만들기: https://www.acmicpc.net/problem/10610
 */
public class S1213 {

    private static final String SORRY = "I'm Sorry Hansoo";
    private static final int[] alpha = new int[27];

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split("");
        for (String s : strings) {
            int idx = s.charAt(0) - 'A';
            alpha[idx]++;
        }

        StringBuilder sb = new StringBuilder();
        int odd = -1;
        for (int i = 0; i < alpha.length; i++) {
            if (alpha[i] % 2 != 0) {
                if (odd >= 0) {
                    System.out.println(SORRY);
                    return;
                }
                odd = i;
            }
            char ch = (char) (i + 'A');
            for (int j = 0; j < alpha[i] / 2; j++) {
                sb.append(ch);
            }
        }

        if (odd >= 0) {
            System.out.println(String.valueOf(sb) + (char) (odd + 'A') + sb.reverse());
        } else {
            System.out.println(String.valueOf(sb) + sb.reverse());
        }
    }
}
