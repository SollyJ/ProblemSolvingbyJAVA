package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Baekjoon_2579_계단오르기 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int stairs = Integer.parseInt(br.readLine());
			int[] scores = new int[stairs];

			for (int i = 0; i < stairs; i++) {
				scores[i] = Integer.parseInt(br.readLine());
			}

			// 1. 테이블 선언
			// i번째 계단까지의 점수 최댓값
			int[] dp = new int[stairs];

			// 2. 초기값
			dp[0] = scores[0];

			// 3. 점화식
			for (int i = 1; i < stairs; i++) {
				dp[i] = scores[i];    // i번째 계단은 무조건 밟으므로 점수를 넣어준다.

				if (i == 1) {
					dp[i] += dp[i - 1];    // 두번째 계단까지의 점수 최댓값
				} else if (i == 2) {
					dp[i] += Math.max(scores[i - 1], scores[i - 2]);    // 세번째 계단까지의 점수 최댓값은 첫번째 + 세번째 or 두번째 + 세번째
				} else {    // 네번째 계단부터는 연속된 세개의 계단을 밟으면 안된다.
					dp[i] += Math.max(dp[i - 3] + scores[i - 1], dp[i - 2]);
				}
			}

			// 4. 결과값 도출
			System.out.println(dp[stairs - 1]);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
