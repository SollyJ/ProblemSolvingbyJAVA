// Baekjoon_11053_가장 긴 증가하는 부분 수열
package DynamicProgramming;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baekjoon_11053 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());

			// 1. 테이블 정의
			//List<Integer> dp = new ArrayList<>();
			int[] seq = new int[N];
			int[] dp = new int[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				seq[i] = Integer.parseInt(st.nextToken());
			}

			// 2. 초기값 세팅
			dp[0] = 1;    // 0번째 원소만으로 만들수 있는 수열 길이는 1

			int max = dp[0];

			// 3. 점화식
			for (int i = 1; i < N; i++) {
				dp[i] = 1;    // 자기자신은 무조건 포함되므로

				// 0 ~ (i-1) 까지의 원소 탐색
				for (int j = 0; j < i; j++) {
					// dp[i] < dp[j] + 1 조건이 있어야 하는 이유:
					// 중복 카운트를 안하기 위해서
					if (seq[j] < seq[i] && dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}

				if (dp[i] > max) {
					max = dp[i];
				}
			}

			// 4. 결과값 도출
			System.out.println(max);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
