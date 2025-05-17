package com.condingtest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
  public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    int T = Integer.parseInt(br.readLine()); // 테스트 케이스 수

    for (int t = 0; t < T; t++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int N = Integer.parseInt(st.nextToken()); // 국가 수
      int M = Integer.parseInt(st.nextToken()); // 비행기 수

      // 비행기 정보는 입력만 받고 따로 저장하거나 사용하지 않음
      for (int i = 0; i < M; i++) {
        br.readLine(); // 간선 정보 무시
      }

      // 항상 N - 1개의 비행기만 있으면 모든 국가를 방문할 수 있음
      System.out.println(N - 1);
    }
  }
}
