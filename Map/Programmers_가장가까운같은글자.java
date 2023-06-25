package Map;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Programmers_가장가까운같은글자 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution("banana")));
		System.out.println(Arrays.toString(solution("foobar")));
	}

	private static int[] solution(String s) {
		int[] answer = new int[s.length()];

		Map<Character, Integer> map = new HashMap<>();    // 글자가 어느 위치에 있는지 저장하기 위한 맵

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);

			if (map.containsKey(c)) {    // 글자가 이미 나온적이 있으면
				answer[i] = i - map.get(c);    // 얼마나 앞에 있냐 == 현재 위치에서 저장된 위치를 뺀 값
				map.put(c, i);    // 현재 위치로 갱신함
			} else {    // 처음 나왔으면
				answer[i] = -1;
				map.put(c, i);
			}
		}

		return answer;
	}
}
