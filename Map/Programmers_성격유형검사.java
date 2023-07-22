package Map;

import java.util.HashMap;

public class Programmers_성격유형검사 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"AN", "CF", "MJ", "RT", "NA"}, new int[] {5, 3, 2, 7, 5}));
		System.out.println(solution(new String[] {"TR", "RT", "TR"}, new int[] {7, 1, 3}));
	}

	private static String solution(String[] survey, int[] choices) {
		StringBuilder answer = new StringBuilder();

		HashMap<String, Integer> map = new HashMap<>();
		map.put("R", 0);    // 라이언
		map.put("T", 0);    // 튜브
		map.put("C", 0);    // 콘
		map.put("F", 0);    // 프로도
		map.put("J", 0);    // 제이지
		map.put("M", 0);    // 무지
		map.put("A", 0);    // 어피치
		map.put("N", 0);    // 네오

		for (int i = 0; i < choices.length; i++) {
			if (choices[i] <= 3) {    // 비동의 계열
				String 유형 = survey[i].substring(0, 1);
				int 점수 = 0;

				switch (choices[i]) {
					case 1:
						점수 = 3;
						break;
					case 2:
						점수 = 2;
						break;
					case 3:
						점수 = 1;
						break;
				}

				int value = map.get(유형);
				map.put(유형, value + 점수);
			} else if (choices[i] >= 5) {    // 동의 계열
				String 유형 = survey[i].substring(1);
				int 점수 = choices[i] - 4;

				int value = map.get(유형);
				map.put(유형, value + 점수);
			}
		}

		// 1번 지표
		if (map.get("R") >= map.get("T")) {
			answer.append("R");
		} else if (map.get("R") < map.get("T")) {
			answer.append("T");
		}

		// 2번 지표
		if (map.get("C") >= map.get("F")) {
			answer.append("C");
		} else if (map.get("C") < map.get("F")) {
			answer.append("F");
		}

		// 3번 지표
		if (map.get("J") >= map.get("M")) {
			answer.append("J");
		} else if (map.get("J") < map.get("M")) {
			answer.append("M");
		}

		// 4번 지표
		if (map.get("A") >= map.get("N")) {
			answer.append("A");
		} else if (map.get("A") < map.get("N")) {
			answer.append("N");
		}

		return answer.toString();
	}
}
