package SimpleAlgorithm;

public class Programmers_콜라문제 {
	public static void main(String[] args) {
		System.out.println(solution(2, 1, 20));
		System.out.println(solution(3, 1, 20));
	}

	private static int solution(int a, int b, int n) {
		int answer = 0;

		while (n >= a) {
			int mart = n;    // 마트에 가져갈 콜라 개수

			while (mart % a != 0) {    // mart가 a의 배수가 될때까지
				mart--;
			}

			int take = mart / a * b;    // 상빈이가 받은 콜라 수
			n = n - mart + take;    // 현재 갖고있는 콜라 수 갱신
			answer += take;    // 정답에 누적 더해줌
		}

		return answer;
	}
}
