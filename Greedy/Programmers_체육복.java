package Greedy;

public class Programmers_체육복 {
	public static void main(String[] args) {
		System.out.println(solution(5, new int[] {2, 4}, new int[] {1, 3, 5}));
		System.out.println(solution(5, new int[] {2, 4}, new int[] {3}));
		System.out.println(solution(3, new int[] {3}, new int[] {1}));
	}

	private static int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		int[] students = new int[n + 1];    // 학생마다 체육복 몇개 있는지 넣어줄 배열

		// 처음엔 한벌씩 있음
		for (int i = 1; i <= n; i++) {
			students[i] = 1;
		}

		// 체육복 도난 계산
		for (int i = 0; i < lost.length; i++) {
			students[lost[i]]--;
		}

		// 여벌 체육복 계산
		for (int i = 0; i < reserve.length; i++) {
			students[reserve[i]]++;
		}

		for (int i = 1; i <= n; i++) {
			if (students[i] == 0) {
				if (students[i - 1] == 2) {
					students[i] = 1;
					students[i - 1] = 1;
				} else if (i != n && students[i + 1] == 2) {
					students[i] = 1;
					students[i + 1] = 1;
				}
			}
		}

		for (int st : students) {
			if (st >= 1) {
				answer++;
			}
		}

		return answer;
	}
}
