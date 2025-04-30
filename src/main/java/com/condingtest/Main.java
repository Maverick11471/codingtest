package com.condingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
  static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
  static int[] visited;
  static int order = 1;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());
    int R = Integer.parseInt(st.nextToken());

    visited = new int[N + 1];

    for (int i = 0; i <= N; i++) {
      graph.add(new ArrayList<>());
    }

    for (int i = 0; i < M; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    for (int i = 1; i <= N; i++) {
      Collections.sort(graph.get(i));
    }

    dfs(R);

    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= N; i++) {
      sb.append(visited[i]).append('\n');
    }

    System.out.print(sb);
  }

  static void dfs(int node) {
    visited[node] = order++;

    for (int next : graph.get(node)) {
      if (visited[next] == 0) {
        dfs(next);
      }
    }
  }
}
