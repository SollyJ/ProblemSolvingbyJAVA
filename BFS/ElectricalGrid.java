// Programmers_전력망둘로나누기
package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class ElectricalGrid {
	static int[][] graph;

	public static void main(String[] args) {
		System.out.println(solution(9, new int[][] {{1, 3}, {2, 3}, {3, 4}, {4, 5}, {4, 6}, {4, 7}, {7, 8}, {7, 9}}));
		System.out.println(solution(4, new int[][] {{1, 2}, {2, 3}, {3, 4}}));
	}

	private static int solution(int n, int[][] wires) {
		int answer = Integer.MAX_VALUE;
		graph = new int[n + 1][n + 1];    // 그래프를 인접행렬로 표현

		// 그래프에 값 넣어주기
		for (int i = 0; i < n - 1; i++) {
			int a = wires[i][0];
			int b = wires[i][1];
			graph[a][b] = 1;
			graph[b][a] = 1;
		}

		// 선 하나씩 끊으면서 bfs로 송전탑 개수 세기
		for (int i = 0; i < n - 1; i++) {
			// 선에 연결된 두 노드
			int left = wires[i][0];
			int right = wires[i][1];

			// 선 끊기
			graph[left][right] = 0;
			graph[right][left] = 0;

			// bfs로 개수 세서 최솟값 구하기
			answer = Math.min(answer, bfs(left, n));

			// 선 복구
			graph[left][right] = 1;
			graph[right][left] = 1;
		}

		return answer;
	}

	private static int bfs(int left, int n) {
		Queue<Integer> q = new LinkedList<>();    // bfs 할 큐
		boolean[] visited = new boolean[n + 1];    // 방문 기록 배열
		int cnt = 1;    // 노드 개수 (송전탑 개수)

		visited[left] = true;
		q.add(left);

		while (!q.isEmpty()) {
			int tmp = q.poll();
			visited[tmp] = true;

			for (int i = 1; i < n + 1; i++) {
				if (graph[tmp][i] == 1 && !visited[i]) {
					q.add(i);
					cnt++;
				}
			}
		}

		return Math.abs(cnt - (n - cnt));
	}
}
