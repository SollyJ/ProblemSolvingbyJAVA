package Mathematics;

public class Programmers_기사단원의무기 {
	public static void main(String[] args) {
		System.out.println(solution(5, 3, 2));
		System.out.println(solution(10, 3, 2));
	}

	private static int solution(int number, int limit, int power) {
		int answer = 0;
		int[] aliquot = new int[number + 1];    // 1~number의 약수 개수를 넣을 배열

		for (int n = 1; n <= number; n++) {
			// 약수 개수 구하기
			int count = 0;

			// 시간 초과 해결을 위해 제곱근까지만 반복해준다.
			// n = 16 을 예로 들면, 4까지만 반복해줘도
			// 1*16, 2*8, 4*4 이렇게 곱셈의 성질을 이용하여 두개 더해주면 되기 때문이다.
			for (int i = 1; i <= Math.sqrt(n); i++) {
				if (n % i == 0) {
					count += 2;

					// 하지만 4*4 과 같은 경우는 4는 하나로 쳐야하므로 1을 빼준다.
					if (n / i == i) {
						count -= 1;
					}
				}
			}

			aliquot[n] = count;
		}

		// 필요한 철의 무게 구하기
		for (int i = 1; i <= number; i++) {
			if (aliquot[i] > limit) {
				answer += power;
			} else {
				answer += aliquot[i];
			}
		}

		return answer;
	}
}
