package org.comboo.week9;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Objects;

/**
 * 백준 10610번 30: https://www.acmicpc.net/problem/10610
 */
public class S10610 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strings = br.readLine().split("");

        Arrays.sort(strings, Comparator.reverseOrder());

        if (!Objects.equals(strings[strings.length - 1], "0")) {
            System.out.println(-1);
            return;
        }

        long number = 0;
        StringBuilder sb = new StringBuilder();
        for (String s : strings) {
            number += Integer.parseInt(s);
            sb.append(s);
        }

        if (number % 3 != 0) {
            System.out.println(-1);
        } else {
            System.out.println(sb);
        }
    }
}
