package Map;

import java.util.HashMap;
import java.util.Iterator;

public class Programmers_완주하지못한선수 {
	public static void main(String[] args) {

	}

	private static String solution(String[] participant, String[] completion) {
		String answer = "";

		// 완주한 선수 map에 넣기
		// 동명이인이 있을 수도 있으므로 value에는 완주한 선수 이름의 개수를 넣어준다.
		HashMap<String, Integer> map = new HashMap<>();
		for (String c : completion) {
			if (map.containsKey(c)) {
				int value = map.get(c);
				map.put(c, value + 1);
			} else {
				map.put(c, 1);
			}
		}

		// 완주하지 못한 선수 찾기
		for (String p : participant) {
			if (map.containsKey(p)) {
				int value = map.get(p);
				map.put(p, value - 1);
			} else {
				answer = p;
			}
		}

		// 동명이인이 있어 위에서 완주하지 못한 선수를 찾지 못한 경우
		Iterator<String> it = map.keySet().stream().iterator();
		while (it.hasNext()) {
			String key = it.next();

			if (map.get(key) < 0) {
				answer = key;
			}
		}

		return answer;
	}
}
