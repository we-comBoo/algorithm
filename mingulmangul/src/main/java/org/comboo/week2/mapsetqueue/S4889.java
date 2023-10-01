package org.comboo.week2.mapsetqueue;

import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Deque;
import java.util.ArrayDeque;

/**
 * 4889번 안정적인 문자열: https://www.acmicpc.net/problem/4889
 */
public class S4889 {

    /**
     * if {
     * 	  push {
     * if }
     * 	if stack is empty
     *    } -> { 연산 수행 (answer++)
     *  pop {
     * ---
     * if stack is not empty
     *  answer += stack.size() / 2
     */
    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; ; i++) {
            String str = br.readLine();
            if (!str.isEmpty() && str.charAt(0) == '-') {
                break;
            }
            int answer = calcAnswer2(str);
            System.out.println(i + ". " + answer);
        }
    }

    // 스택 사용
    private static int calcAnswer1(String str) {
        Deque<Character> stack = new ArrayDeque<>();
        int length = str.length();
        int answer = 0;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '{') {
                stack.push('{');
            } else if (stack.isEmpty()) {
                answer++;
                stack.push('{');
            } else {
                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return answer + (stack.size() / 2);
        }
        return answer;
    }

    // 스택의 사이즈만 필요 -> 정수형 변수만 사용 (스택 X)
    private static int calcAnswer2(String str) {
        int length = str.length();
        int answer = 0;
        int size = 0;

        for (int i = 0; i < length; i++) {
            if (str.charAt(i) == '{') {
                size++;
            } else if (size == 0) {
                answer++;
                size++;
            } else {
                size--;
            }
        }

        if (size > 0) {
            return answer + (size / 2);
        }
        return answer;
    }

}
