package SimpleAlgorithm;

public class Programmers_덧칠하기 {
	public static void main(String[] args) {
		System.out.println(solution(8, 4, new int[] {2, 3, 6}));
		System.out.println(solution(5, 4, new int[] {1, 3}));
		System.out.println(solution(4, 1, new int[] {1, 2, 3, 4}));
	}

	private static int solution(int n, int m, int[] section) {
		int start = section[0];
		int end = section[0] + (m - 1);
		int answer = 1;    // 일단 한번 칠함

		for (int s : section) {
			if (s >= start && s <= end) {    // 이미 칠했거나, end가 주어진 영역을 벗어났다는 조건
				continue;
			} else {
				start = s;
				end = s + (m - 1);

				answer++;
			}
		}
		return answer;
	}
}
