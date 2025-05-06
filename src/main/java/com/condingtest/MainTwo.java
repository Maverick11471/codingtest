import java.io.*;
import java.util.*;

public class Main {

  static List<List<Integer>> graph = new ArrayList<>();
  static int[] parent;
  static boolean[] visited;

  public static void main(String[] args) throws IOException {
    // 입력 초기화
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int n = Integer.parseInt(br.readLine());

    // 그래프 초기화
    for (int i = 0; i <= n; i++) {
      graph.add(new ArrayList<>());
    }

    parent = new int[n + 1];
    visited = new boolean[n + 1];

    // 간선 입력 받기
    for (int i = 0; i < n - 1; i++) {
      StringTokenizer st = new StringTokenizer(br.readLine());
      int u = Integer.parseInt(st.nextToken());
      int v = Integer.parseInt(st.nextToken());

      graph.get(u).add(v);
      graph.get(v).add(u);
    }

    // 루트 노드에서 DFS 시작
    dfs(1);

    // 2번 노드부터 부모 출력
    StringBuilder sb = new StringBuilder();
    for (int i = 2; i <= n; i++) {
      sb.append(parent[i]).append("\n");
    }

    System.out.print(sb);
  }

  private static void dfs(int current) {
    visited[current] = true;

    for (int next : graph.get(current)) {
      if (!visited[next]) {
        parent[next] = current; // 부모 기록
        dfs(next);
      }
    }
  }
}
