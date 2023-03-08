// Programmers_약수개수와더하기
package ProgrammersLv1;

public class AliquotSum {
	public static void main(String[] args) {
		System.out.println(solution(13, 17));
		System.out.println(solution(24, 27));
	}

	private static int solution(int left, int right) {
		int answer = 0;

		for (int num = left; num <= right; num++) {
			if (aliquot(num) % 2 == 0) {    // 약수 개수가 짝수면
				answer += num;
			} else {    // 홀수면
				answer -= num;
			}
		}

		return answer;
	}

	// 약수 개수 구하는 함수
	private static int aliquot(int num) {
		int count = 0;

		for (int i = 1; i <= num; i++) {
			if (num % i == 0)
				count++;
		}

		return count;
	}
}
