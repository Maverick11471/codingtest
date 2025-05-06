package com.condingtest;

import java.io.*;
import java.util.*;

public class MainTwo {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int N = Integer.parseInt(br.readLine());

    int[] dp = new int[N + 1];
    int[] prev = new int[N + 1];

    for (int i = 2; i <= N; i++) {
      dp[i] = dp[i - 1] + 1;
      prev[i] = i - 1;

      if (i % 2 == 0 && dp[i / 2] + 1 < dp[i]) {
        dp[i] = dp[i / 2] + 1;
        prev[i] = i / 2;
      }

      if (i % 3 == 0 && dp[i / 3] + 1 < dp[i]) {
        dp[i] = dp[i / 3] + 1;
        prev[i] = i / 3;
      }
    }

    System.out.println(dp[N]);

    StringBuilder sb = new StringBuilder();
    int current = N;
    while (current != 0) {
      sb.append(current).append(" ");
      current = prev[current];
    }

    System.out.println(sb.toString().trim());
  }
}
