package com.condingtest;

import java.io.*;
import java.util.*;

public class Main {
  static List<Integer>[] tree;
  static boolean[] visited;
  static int[] parent;

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int n = Integer.parseInt(br.readLine()); // 노드 개수

    tree = new ArrayList[n + 1]; // 1번 노드부터 사용
    visited = new boolean[n + 1];
    parent = new int[n + 1];

    // 각 노드에 대해 리스트 초기화
    for (int i = 1; i <= n; i++) {
      tree[i] = new ArrayList<>();
    }

    // 간선 정보 입력
    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      // 양방향 연결
      tree[u].add(v);
      tree[v].add(u);
    }

    // DFS 시작 (루트 노드는 1)
    dfs(1);

    // 2번 노드부터 부모 출력
    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= n; i++) {
      sb.append(parent[i]).append("\n");
    }

    System.out.print(sb);
  }

  static void dfs(int current) {
    visited[current] = true;

    for (int next : tree[current]) {
      if (!visited[next]) {
        parent[next] = current; // 부모 기록
        dfs(next);
      }
    }
  }
}
