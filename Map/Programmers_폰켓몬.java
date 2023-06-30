package Map;

import java.util.HashMap;

public class Programmers_폰켓몬 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 1, 2, 3}));
		System.out.println(solution(new int[] {3, 3, 3, 2, 2, 4}));
		System.out.println(solution(new int[] {3, 3, 3, 2, 2, 2}));
	}

	private static int solution(int[] nums) {
		int answer = 0;

		int len = nums.length;
		HashMap<Integer, Integer> ponkemon = new HashMap<>();    // 폰켓몬 번호, 해당 폰켓몬 개수

		// 주어진 배열을 순회하면서 map을 초기화 해준다.
		for (int pN : nums) {
			if (ponkemon.containsKey(pN)) {
				int temp = ponkemon.get(pN);
				ponkemon.put(pN, temp + 1);
			} else {
				ponkemon.put(pN, 1);
			}
		}

		if (ponkemon.size() <= len / 2) {   // 폰켓몬 종류가 골라야하는 개수보다 작거나 같다면 답은 폰켓몬 종류 개수
			answer = ponkemon.size();
		} else {    // 폰켓몬 종류가 골라야하는 개수보다 크다면 답은 골라야하는 개수
			answer = len / 2;
		}

		return answer;
	}
}
