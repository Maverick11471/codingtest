package com.condingtest;

import java.io.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
  // 우선순위 큐에 넣기 위한 Node 클래스
  static class Node implements Comparable<Node> {
    int index; // 도착 정점 번호
    int distance; // 현재까지 계산된 거리

    public Node(int index, int distance) {
      this.index = index;
      this.distance = distance;
    }

    @Override
    public int compareTo(Node other) {
      return this.distance - other.distance; // 거리 기준 오름차순 정렬
    }
  }

  public static void main(String[] args) throws IOException {
    final int INF = Integer.MAX_VALUE;

    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int V = Integer.parseInt(st.nextToken()); // 정점 개수
    int E = Integer.parseInt(st.nextToken()); // 간선 개수
    int start = Integer.parseInt(br.readLine()); // 시작 정점

    // 인접 리스트 그래프 및 거리 배열
    List<Node>[] graph = new ArrayList[V + 1];
    int[] dist = new int[V + 1];
    Arrays.fill(dist, INF);

    for (int i = 1; i <= V; i++) {
      graph[i] = new ArrayList<>();
    }

    // 간선 입력
    for (int i = 0; i < E; i++) {
      st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken()); // 출발
      int v = Integer.parseInt(st.nextToken()); // 도착
      int w = Integer.parseInt(st.nextToken()); // 가중치
      graph[u].add(new Node(v, w));
    }

    // 다익스트라 실행
    dijkstra(start, graph, dist);

    // 결과 출력
    StringBuilder sb = new StringBuilder();
    for (int i = 1; i <= V; i++) {
      sb.append(dist[i] == INF ? "INF" : dist[i]).append("\n");
    }

    System.out.print(sb);
  }

  static void dijkstra(int start, List<Node>[] graph, int[] dist) {
    PriorityQueue<Node> pq = new PriorityQueue<>();
    dist[start] = 0;
    pq.offer(new Node(start, 0));

    while (!pq.isEmpty()) {
      Node current = pq.poll();
      int curIdx = current.index;
      int curDist = current.distance;

      // 이미 더 짧은 거리로 방문한 적이 있다면 건너뛰기
      if (dist[curIdx] < curDist) continue;

      for (Node neighbor : graph[curIdx]) {
        int cost = dist[curIdx] + neighbor.distance;
        if (cost < dist[neighbor.index]) {
          dist[neighbor.index] = cost;
          pq.offer(new Node(neighbor.index, cost));
        }
      }
    }
  }
}
