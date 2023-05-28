// Baekjoon_2828_사과담기게임
package Greedy;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class AppleGame {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());    // 스크린 칸
			int M = Integer.parseInt(st.nextToken());    // 바구니 크기

			// 바구니 위치를 좌표로 저장
			int left = 1;
			int right = M;

			int J = Integer.parseInt(br.readLine());    // 사과 개수

			int count = 0;    // 이동 거리

			for (int j = 0; j < J; j++) {
				int apple = Integer.parseInt(br.readLine());    // 사과 떨어지는 위치

				// 경우1. 사과 떨어지는 위치가 바구니 오른쪽 이라면
				if (apple > right) {
					while (!(left <= apple && apple <= right)) {
						left++;
						right++;
						count++;
					}
					// 경우2. 사과 떨어지는 위치가 바구니 왼쪽 이라면
				} else if (apple < left) {
					while (!(left <= apple && apple <= right)) {
						left--;
						right--;
						count++;
					}
				}
				// 경우3. 사과 떨어지는 위치가 바구니 안이라면 그냥 넘어가면 된다.
			}

			System.out.println(count);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
