// Programmers_삼총사
package ProgrammersLv1;

public class 삼총사 {
	static boolean[] visited;
	static int answer;

	public static void main(String[] args) {
		System.out.println(solution(new int[] {-2, 3, 0, 2, -5}));
		System.out.println(solution(new int[] {-3, -2, -1, 0, 1, 2, 3}));
		System.out.println(solution(new int[] {-1, 1, -1, 1}));
	}

	private static int solution(int[] number) {
		answer = 0;
		visited = new boolean[number.length];

		combination(number, 0, number.length, 3);

		return answer;
	}

	// 백트래킹 사용해서 조합 구현
	// 배열, 시작 인덱스, 배열 길이, 몇 개 뽑을건지
	private static void combination(int[] arr, int start, int n, int r) {
		if (r == 0) {    // r개 다 뽑았으면
			int sum = 0;

			for (int i = 0; i < n; i++) {
				if (visited[i]) {    // 뽑은 수 다 더해서
					sum += arr[i];
				}
			}

			if (sum == 0) {    // 0이면 answer++
				answer++;
			}

			return;
		}

		for (int i = start; i < n; i++) {
			visited[i] = true;    // 하나 뽑고
			combination(arr, i + 1, n, r - 1);    // r - 1개 뽑으러 다시 재귀
			visited[i] = false;    // r개 다 뽑았으면 다시 방문여부 초기화
		}
	}
}
