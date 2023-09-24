package org.comboo.week1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/*
 * 1431번 시리얼 번호 https://www.acmicpc.net/problem/1431
 */
public class S1431 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] arr = new String[n];
        for (int i = 0; i < n; i++) {
            arr[i] = br.readLine();
        }

        Arrays.sort(arr, comp);

        StringBuilder sb = new StringBuilder();
        for (String str : arr) {
            sb.append(str).append('\n');
        }
        System.out.println(sb);
    }

    public static final Comparator<String> comp = new Comparator<>() {
        @Override
        public int compare(String o1, String o2) {
            if (o1.length() == o2.length()) {
                int sum1 = sumOfDigit(o1);
                int sum2 = sumOfDigit(o2);
                if (sum1 == sum2) {
                    return o1.compareTo(o2);
                }
                return sum1 - sum2;
            }
            return o1.length() - o2.length();
        }

        private int sumOfDigit(String str) {
            int sum = 0;
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= '0' && ch <= '9') {
                    sum += ch - '0';
                }
            }
            return sum;
        }
    };
}
