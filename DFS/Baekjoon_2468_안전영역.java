package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_2468_안전영역 {
	static int N;
	static int[][] map;
	static boolean[][] visited;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			N = Integer.parseInt(br.readLine());

			int maxHeight = 0;    // 최대 높이

			// map 초기화
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());

				for (int j = 0; j < N; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());

					if (map[i][j] > maxHeight) {
						maxHeight = map[i][j];
					}
				}
			}

			int answer = 0;

			for (int height = 0; height <= maxHeight; height++) {
				visited = new boolean[N][N];

				int cnt = 0;

				// 모든 지역 탐색
				for (int i = 0; i < N * N; i++) {
					// 안전영역인지
					if (!visited[i / N][i % N] && map[i / N][i % N] > height)
						cnt += dfs(i % N, i / N, height);
				}

				answer = Math.max(cnt, answer);
			}

			System.out.println(answer);
		} catch (Exception e) {
			e.printStackTrace();
			e.getLocalizedMessage();
		}
	}

	private static int dfs(int x, int y, int height) {
		visited[y][x] = true;

		int[] searchX = {0, 0, -1, 1};
		int[] searchY = {-1, 1, 0, 0};

		for (int i = 0; i < 4; i++) {
			int nx = x + searchX[i];
			int ny = y + searchY[i];

			if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
				if (!visited[ny][nx] && map[ny][nx] > height)
					dfs(nx, ny, height);
			}
		}

		return 1;
	}
}
