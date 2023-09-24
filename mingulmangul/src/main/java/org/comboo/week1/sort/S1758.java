package org.comboo.week1.sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;

/*
 * 1758번 알바생 강호 https://www.acmicpc.net/problem/1758
 * 주의사항!!
 *  - n번째 사람이 0원의 팁을 준다면 n+1번째 사람부터는 무조건 음수이므로 계산할 필요가 없음!
 *  - 팁을 모두 더한 값이 int의 범위를 초과. long 사용해야 함
 *   => 항상 입력 범위에 대해 나올 수 있는 최댓값 생각하기!!
 */
public class S1758 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr, Collections.reverseOrder());

        long tips = 0;
        for (int i = 0; i < n; i++) {
            int tip = arr[i] - i;
            if (tip <= 0) {
                break;
            }
            tips += tip;
        }
        System.out.println(tips);
    }
}
