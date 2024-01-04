package org.comboo.week11;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 백준 11000번 강의실 배정: https://www.acmicpc.net/problem/11000
 */
public class S11000 {

    public static void solution() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Lecture> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Lecture(start, end));
        }
        Collections.sort(list);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(list.get(0).end);
        for (int i = 1; i < list.size(); i++) {
            Integer poll = pq.peek();
            if (poll <= list.get(i).start) {
                pq.poll();
            }
            pq.add(list.get(i).end);
        }
        System.out.println(pq.size());
    }

    public static class Lecture implements Comparable<Lecture> {
        public int start;
        public int end;

        public Lecture(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Lecture other) {
            if (this.start == other.start) {
                return this.end - other.end;
            }
            return this.start - other.start;
        }
    }
}
