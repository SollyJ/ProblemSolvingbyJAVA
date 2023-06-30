package Map;

import java.util.Arrays;
import java.util.HashMap;

public class Programmers_추억점수 {
	public static void main(String[] args) {
		String[] 이름 = {"may", "kein", "kain", "radi"};
		int[] 그리움 = {5, 10, 1, 3};
		String[][] 사진첩 = {{"may"}, {"kein", "deny", "may"}, {"kon", "coni"}};

		System.out.println(Arrays.toString(solution(이름, 그리움, 사진첩)));
	}

	private static int[] solution(String[] name, int[] yearning, String[][] photo) {
		int[] answer = new int[photo.length];

		HashMap<String, Integer> map = new HashMap<>();

		for (int i = 0; i < name.length; i++) {
			map.put(name[i], yearning[i]);    // 각 사람마다 그리움점수 넣기
		}

		for (int i = 0; i < photo.length; i++) {
			for (String n : photo[i]) {
				if (map.get(n) == null)    // 그리움 점수가 없는 이름이면 넘어감
					continue;

				answer[i] += map.get(n);
			}
		}

		return answer;
	}
}
