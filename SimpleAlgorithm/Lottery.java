// Programmers 로또의 최고 순위와 최저 순위
package SimpleAlgorithm;

import java.util.Arrays;
import java.util.HashSet;

public class Lottery {
	public static void main(String[] args) {
		System.out.println(
			Arrays.toString(solution(new int[] {44, 1, 0, 0, 31, 25}, new int[] {31, 10, 45, 1, 6, 19})));
		System.out.println(
			Arrays.toString(solution(new int[] {0, 0, 0, 0, 0, 0}, new int[] {38, 19, 20, 40, 15, 25})));
		System.out.println(
			Arrays.toString(solution(new int[] {45, 4, 35, 20, 3, 9}, new int[] {20, 9, 3, 45, 4, 35})));
	}

	private static int[] solution(int[] lottos, int[] win_nums) {
		int[] answer = new int[2];    // 최고 순위, 최저 순위

		int same = 0;    // 같은 번호 카운트
		int zero = 0;    // 알아볼 수 없는 번호 카운트

		// 검색을 위해 set에 win_nums를 넣어준다.
		HashSet<Integer> win_nums_set = new HashSet<>();
		for (int i = 0; i < 6; i++) {
			win_nums_set.add(win_nums[i]);
		}

		for (int i = 0; i < 6; i++) {
			if (lottos[i] == 0) {
				zero++;
			} else if (win_nums_set.contains(lottos[i])) {
				same++;
			}
		}

		// 최고 점수는 same+zero개 번호가 일치 했을때의 순위이다.
		switch (same + zero) {
			case 6:
				answer[0] = 1;
				break;
			case 5:
				answer[0] = 2;
				break;
			case 4:
				answer[0] = 3;
				break;
			case 3:
				answer[0] = 4;
				break;
			case 2:
				answer[0] = 5;
				break;
			default:
				answer[0] = 6;
		}

		// 최저 점수는 현재까지의 same개 번호가 일치 했을때의 순위이다.
		switch (same) {
			case 6:
				answer[1] = 1;
				break;
			case 5:
				answer[1] = 2;
				break;
			case 4:
				answer[1] = 3;
				break;
			case 3:
				answer[1] = 4;
				break;
			case 2:
				answer[1] = 5;
				break;
			default:
				answer[1] = 6;
		}

		return answer;
	}
}
