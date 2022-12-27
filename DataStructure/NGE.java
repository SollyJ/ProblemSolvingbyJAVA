// Baekjoon_17298_오큰수
package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class NGE {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());
			int[] arr = new int[N];
			int[] ans = new int[N];   // 정답 배열
			Stack<Integer> stack = new Stack<>();    // 인덱스를 넣을 스택

			// 배열에 원소 넣기
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}

			// for문의 i는 오른쪽을 탐색할 변수다.
			for (int i = 0; i < N; i++) {
				while (!stack.isEmpty() && (arr[stack.peek()] < arr[i])) {    // 오큰수를 찾아
					ans[stack.pop()] = arr[i];    // 정답 배열 인덱스는 stack을 pop한 수
				}
				stack.push(i);    // 다음 인덱스 넣기
			}
			while (!stack.isEmpty()) {
				ans[stack.pop()] = -1;
			}

			// StringBuilder안쓰고 for문으로 sout하면 시간초과남
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < N; i++) {
				sb.append(ans[i]).append(" ");
			}
			System.out.println(sb.toString());

			br.close();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
