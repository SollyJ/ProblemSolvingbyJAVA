// Programmers_없는숫자더하기
package ProgrammersLv1;

import java.util.ArrayList;

public class Programmers_없는숫자더하기 {
	public static void main(String[] args) {
		int[] nums1 = {1, 2, 3, 4, 6, 7, 8, 0};
		System.out.println(solution(nums1));
	}

	private static int solution(int[] numbers) {
		int answer = 0;

		// 0~9 까지 넣을 리스트 numsArr
		ArrayList<Integer> numsArr = new ArrayList<>(10);
		for (int i = 0; i < 10; i++) {
			numsArr.add(i);
		}

		for (int e : numbers) {    // numbers를 순회하면서
			numsArr.remove(numsArr.indexOf(e));    // numsArr에서 원소를 제거한다.
		}

		if (numsArr.isEmpty()) {
			answer = 0;
		} else {
			for (int e : numsArr) {    // numsArr에 남아있는 값들을 모두 더해준다.
				//System.out.println(e);
				answer += e;
			}
		}

		return answer;
	}
}
