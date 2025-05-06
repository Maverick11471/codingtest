package com.condingtest;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.StringTokenizer;

public class Main {
  static int[] parent;

  // Find: 부모 노드를 찾는다 (경로 압축)
  static int find(int x) {
    if (x == parent[x]) return x;
    return parent[x] = find(parent[x]);
  }

  // Union: 두 집합을 합친다
  static void union(int a, int b) {
    int rootA = find(a);
    int rootB = find(b);
    if (rootA != rootB) {
      parent[rootB] = rootA;
    }
  }

  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int n = Integer.parseInt(st.nextToken()); // 원소 개수
    int m = Integer.parseInt(st.nextToken()); // 연산 개수

    parent = new int[n + 1];
    for (int i = 0; i <= n; i++) {
      parent[i] = i; // 자기 자신이 부모
    }

    StringBuilder sb = new StringBuilder();

    for (int i = 0; i < m; i++) {
      st = new StringTokenizer(br.readLine());
      int cmd = Integer.parseInt(st.nextToken());
      int a = Integer.parseInt(st.nextToken());
      int b = Integer.parseInt(st.nextToken());

      if (cmd == 0) {
        union(a, b);
      } else if (cmd == 1) {
        if (find(a) == find(b)) {
          sb.append("YES\n");
        } else {
          sb.append("NO\n");
        }
      }
    }

    System.out.print(sb.toString());
  }
}
