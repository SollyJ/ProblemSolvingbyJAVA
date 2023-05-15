// Baekjoon_1325_효율적인 해킹
package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Hacking {
	static boolean[] visited;    // 방문리스트
	static ArrayList<Integer>[] computers;    // 컴퓨터 신뢰관계를 그래프(인접리스트)로 구현
	static int[] count;     // n번 컴퓨터를 해킹했을때 해킹할 수 있는 컴퓨터 수

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());

			// 초기화
			computers = new ArrayList[N + 1];
			for (int i = 1; i <= N; i++) {
				computers[i] = new ArrayList<>();
			}

			count = new int[N + 1];

			// 그래프에 값 넣어주기
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());

				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());

				computers[a].add(b);
				// A, B의 신뢰 관계가 정해져있으므로 방향이 정해져있는 그래프이다.
				//computers[b].add(a);
			}

			// 너비우선탐색하며 해킹 수 계산
			for (int i = 1; i <= N; i++) {
				visited = new boolean[N + 1];    // 방문리스트 초기화
				bfs(i);    // i번 컴퓨터를 제일 먼저 해킹했을때
				//System.out.println(count[i]);	// 해킹수
			}

			// 최댓값 구하기
			int max = 0;

			for (int i = 1; i <= N; i++) {
				max = Math.max(count[i], max);
			}

			// 정답 출력
			for (int i = 1; i <= N; i++) {
				if (max == count[i]) {
					sb.append(i + " ");
				}
			}

			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void bfs(int node) {
		Queue<Integer> q = new LinkedList<>();

		// 현재 노드 방문 표시
		q.add(node);
		visited[node] = true;

		while (!q.isEmpty()) {
			int newNode = q.poll();

			// 인접노드 중 방문하지 않은 노드 방문
			for (int i : computers[newNode]) {
				if (!visited[i]) {
					q.add(i);
					visited[i] = true;
					count[i]++;    // 해킹 컴퓨터++
				}
			}
		}
	}
}
