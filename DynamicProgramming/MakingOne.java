// Baekjoon_1463_1로만들기
package DynamicProgramming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MakingOne {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] result = new int[N + 1];  // result[n]은 n일때 연산 횟수 최솟값
		result[0] = 0;
		result[1] = 0;
		// result[2] = 1;   // 2, 3은 미리 설정해두면 안되는 이유는
		// result[3] = 1;   // 만약 N이 2면 result[3]은 있지도 않은데 result[3]에 값을 설정해뒀으니 outofindex 에러가 뜨는 것이다.

		for (int i = 2; i <= N; i++) {
			result[i] = 1 + result[i - 1];

			if (i % 3 == 0) {
				result[i] = Math.min(1 + result[i / 3], result[i]);
			}
			if (i % 2 == 0) {    // 3과 2에 동시에 나누어 떨어지는 수가 있기 때문에 elseif가 아닌 if문 따로 해줘야한다.
				result[i] = Math.min(1 + result[i / 2], result[i]);
			}
		}

		System.out.print(result[N]);
		br.close();
	}
}
