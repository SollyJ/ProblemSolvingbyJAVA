package SimpleAlgorithm;

import java.util.Arrays;

public class Programmers_과일장수 {
	public static void main(String[] args) {
		System.out.println(solution(3, 4, new int[] {1, 2, 3, 1, 2, 3, 1}));
		System.out.println(solution(4, 3, new int[] {4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2}));
	}

	private static int solution(int k, int m, int[] score) {
		int answer = 0;

		Arrays.sort(score);

		int count = score.length;    // 사과 총 개수
		int box = count / m;    // 나올 수 있는 상자 수

		int i = count - 1;    // score배열을 거꾸로 순회할 변수
		while (i >= 0 && box != 0) {
			i = i - m + 1;    // 최저 사과 점수 인덱스
			answer += score[i--] * m * 1;    // 점수 계산해주고, 다음 박스를 위해서 i-- 해준다.
			box--;    // 한 상자 썼으므로 box--
		}

		return answer;
	}
}
