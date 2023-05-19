// Programmers_숫자짝꿍
package Map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class PairOfNums {
	public static void main(String[] args) {
		System.out.println(solution("100", "2345"));
		System.out.println(solution("100", "203045"));
		System.out.println(solution("100", "123450"));
		System.out.println(solution("12321", "42531"));
		System.out.println(solution("5525", "1255"));
	}

	private static String solution(String X, String Y) {
		StringBuilder sb = new StringBuilder();
		String answer = "";
		HashMap<String, Integer> map = new HashMap<>();    // key: 숫자, value: 나온 횟수
		ArrayList<String> ansList = new ArrayList<>();

		// X 문자열 순회하면서 map의 key값에 할당해준다.
		for (int i = 0; i < X.length(); i++) {
			String num = X.substring(i, i + 1);

			if (map.containsKey(num)) {
				map.put(num, map.get(num) + 1);
			} else {
				map.put(num, 1);
			}
		}

		// Y 문자열 순회
		for (int i = 0; i < Y.length(); i++) {
			String num = Y.substring(i, i + 1);

			if (map.containsKey(num)) {
				if (map.get(num) > 0) {    // map에 존재하면
					ansList.add(num);    // ansList에 num 추가
					map.put(num, map.get(num) - 1);    // 나온 횟수 감소
				}
			}
		}

		Collections.sort(ansList, Collections.reverseOrder());    // 내림차순 정렬

		if (ansList.isEmpty()) {
			answer = "-1";
		} else if (ansList.get(0).equals("0")) {
			answer = "0";
		} else {
			ansList.stream().forEach(s -> sb.append(s));
			answer += sb;
		}

		return answer;
	}
}
