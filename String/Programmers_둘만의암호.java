package String;

import java.util.ArrayList;
import java.util.List;

public class Programmers_둘만의암호 {
	public static void main(String[] args) {
		System.out.println(solution("aukks", "wbqd", 5));
	}

	private static String solution(String s, String skip, int index) {
		StringBuilder answer = new StringBuilder();

		// skip할 문자들 리스트에 넣기
		List<Character> skip_chars = new ArrayList<>();
		for (int i = 0; i < skip.length(); i++) {
			skip_chars.add(skip.charAt(i));
		}

		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);    // 연산할 문자

			int back = index;    // 몇번 뒤로 갈지
			while (back > 0) {
				if (c == 'z') {
					c = 'a';
				} else {
					c = (char)(c + 1);
				}

				while (skip_chars.contains(c)) {
					if (c == 'z') {
						c = 'a';
					} else {
						c = (char)(c + 1);
					}
				}

				back--;
			}

			answer.append(c);
		}

		return answer.toString();
	}
}
