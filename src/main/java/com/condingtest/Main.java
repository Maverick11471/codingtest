package com.condingtest;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    int n = Integer.parseInt(br.readLine());
    for (int i = 0; i < n; i++) {
      int x = Integer.parseInt(br.readLine());
      if (x == 0) {
        if (pq.isEmpty()) {
          bw.write("0\n");
        } else {
          bw.write(pq.poll());
        }
      } else {
        pq.add(x);
      }
    }
    bw.flush();
    bw.close();
  }
}
