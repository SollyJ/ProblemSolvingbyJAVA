// Baekjoon_10709_기상캐스터
package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class WeatherCaster {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder sb = new StringBuilder();

			StringTokenizer st = new StringTokenizer(br.readLine());
			int H = Integer.parseInt(st.nextToken());
			int W = Integer.parseInt(st.nextToken());

			for (int i = 0; i < H; i++) {
				String str = br.readLine();
				// 구름이 떠있는지 확인하는 용도의 큐
				Queue<Character> q = new LinkedList<>();
				// 구름이 옮겨오는 시간
				int delay = 0;

				for (int j = 0; j < W; j++) {
					char c = str.charAt(j);

					if (c == 'c') {    // 이 구역에 구름이 떠있다면
						sb.append(0 + " ");
						q.add(c);
						delay = 0;
					} else if (c != 'c' && !q.isEmpty()) {    // 구름이 안 떠있는데, 구름이 옮겨온다면
						sb.append(++delay + " ");
					} else {    // 구름이 아예 뜨지 않을 경우
						sb.append("-1 ");
					}
				}

				sb.append("\n");
			}

			System.out.println(sb);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}
