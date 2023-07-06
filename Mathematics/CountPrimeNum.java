// Programmers 소수찾기
package Mathematics;

public class CountPrimeNum {
	public static void main(String[] args) {
		System.out.println(solution(10));
		System.out.println(solution(5));
	}

	private static int solution(int n) {
		int answer = 0;
		int[] nums = new int[n + 1];

		// 에라토스테네스의 체 알고리즘 이용하기 위해 1~n 까지 넣어준다.
		for (int i = 2; i <= n; i++) {
			nums[i] = i;
		}

		// 1은 어차피 소수가 아니니까 2부터
		// 내부 for문에서 i의 배수들을 없애기줄 것이기 때문에 제곱근까지만 돌아도 됨
		for (int i = 2; i <= Math.sqrt(n); i++) {
			if (nums[i] == 0)
				continue;

			// i의 배수들을 0으로 바꿔준다. (소수가 아니라는 뜻)
			for (int j = i * 2; j <= n; j += i) {
				nums[j] = 0;
			}
		}

		for (int i = 2; i <= n; i++) {
			if (nums[i] != 0)
				answer++;
		}

		return answer;
	}
}
