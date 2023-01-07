// baek1183
package Mathematics;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Promise {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());

		int[] t_arry = new int[N];

		StringTokenizer st;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			t_arry[i] = Integer.parseInt(st.nextToken()) - Integer.parseInt(st.nextToken());
		}
		Arrays.sort(t_arry);

		if (N % 2 == 0) {    // 짝수 일때
			System.out.print(Math.abs(t_arry[(N - 1) / 2 + 1] - t_arry[(N - 1) / 2]) + 1);
		} else {  // 홀수 일때는 중간값 하나가 답
			System.out.print(1);
		}
	}
}
