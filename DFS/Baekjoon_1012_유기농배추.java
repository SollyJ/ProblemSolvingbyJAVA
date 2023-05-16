package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_1012_유기농배추 {
	static int W;    // 가로
	static int H;   // 세로
	static int[][] gangwon;    // 배추밭
	static boolean[][] visited;    // 방문기록
	static int count;    // 배추흰지렁이 수

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;

			int T = Integer.parseInt(br.readLine());

			while (T > 0) {
				st = new StringTokenizer(br.readLine());
				W = Integer.parseInt(st.nextToken());
				H = Integer.parseInt(st.nextToken());
				int K = Integer.parseInt(st.nextToken());    // 배추 개수

				gangwon = new int[H][W];
				visited = new boolean[H][W];
				count = 0;

				// 배추밭에 배추 넣어주기
				for (int i = 0; i < K; i++) {
					st = new StringTokenizer(br.readLine());
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());

					gangwon[y][x] = 1;
				}

				// 깊이우선탐색하며 count
				for (int h = 0; h < H; h++) {
					for (int w = 0; w < W; w++) {
						if (gangwon[h][w] == 1 && !visited[h][w]) {    // 배추가 있다면
							dfs(h, w);    // 탐색
							count++;    // 탐색이 끝나면 count++
						}
					}
				}

				System.out.println(count);
				T -= 1;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static void dfs(int h, int w) {
		// 우, 하, 좌, 상으로 탐색하기 위한 x, y 배열
		// (0, 0)부터 (W, H)까지 우, 하 방향으로 가므로 우, 하를 먼저
		int[] searchX = {1, 0, -1, 0};
		int[] searchY = {0, 1, 0, -1};
		// int[] searchX = {0, 1, 0, -1};
		// int[] searchY = {1, 0, -1, 0};

		visited[h][w] = true;

		// 우, 하, 좌, 상 4번 반복
		for (int i = 0; i < 4; i++) {
			int newW = w + searchX[i];    // 새로운 x좌표
			int newH = h + searchY[i];    // 새로운 y좌표

			// 새로운 좌표 유효성 검사
			if (newH >= 0 && newW >= 0 && newH < H && newW < W) {
				// 인접한 곳에 배추가 있으면서 방문하지 않았다면 더 탐색
				if (gangwon[newH][newW] == 1 && !visited[newH][newW]) {
					dfs(newH, newW);
				}
			}
		}
	}
}
