package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/*
연속된 수의 개수가 정해지지 않았으므로, 1~N개까지 가능하단 뜻
최댓값을 알기 위해 작은 문제로 나누어서 그 결과를 저장하여 다시 큰 문제를 해결
=> DP
 */

public class Baekjoon_2670_연속부분최대곱 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());
			double[] nums = new double[N];

			for (int i = 0; i < N; i++) {
				nums[i] = Double.parseDouble(br.readLine());
			}

			// 1. 테이블 정의
			double[] dp = new double[N];

			// 2. 초기값 세팅
			dp[0] = nums[0];
			double max = dp[0];

			// 3. 점화식
			for (int i = 1; i < N; i++) {
				dp[i] = Math.max(nums[i], dp[i - 1] * nums[i]);
				max = Math.max(dp[i], max);
			}

			System.out.println(String.format("%.3f", max));
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
			e.printStackTrace();
		}
	}
}
