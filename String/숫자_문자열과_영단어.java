// Programmers 숫자 문자열과 영단어
package String;

public class 숫자_문자열과_영단어 {
	public static void main(String[] args) {
		System.out.println(solution1("one4seveneight"));
		System.out.println(solution1("23four5six7"));
		System.out.println(solution2("2three45sixseven"));
		System.out.println(solution2("123"));
	}

	// 풀이1 (단순 조건문 구현)
	private static int solution1(String s) {
		StringBuilder sb = new StringBuilder();
		int answer = 0;

		int i = 0;
		while (i < s.length()) {
			char c = s.charAt(i);

			// 숫자면
			if (0 <= c - '0' && c - '0' <= 9) {
				sb.append(c);    // sb에 추가
				i++;
				continue;
			}

			if (c == 'z') {
				sb.append(0);
				i += 4;
			} else if (c == 'o') {
				sb.append(1);
				i += 3;
			} else if (c == 't') {
				if (s.startsWith("two", i)) {
					sb.append(2);
					i += 3;
				} else if (s.startsWith("three", i)) {
					sb.append(3);
					i += 5;
				}
			} else if (c == 'f') {
				if (s.startsWith("four", i)) {
					sb.append(4);
					i += 4;
				} else if (s.startsWith("five", i)) {
					sb.append(5);
					i += 4;
				}
			} else if (c == 's') {
				if (s.startsWith("six", i)) {
					sb.append(6);
					i += 3;
				} else if (s.startsWith("seven", i)) {
					sb.append(7);
					i += 5;
				}
			} else if (c == 'e') {
				sb.append(8);
				i += 5;
			} else if (c == 'n') {
				sb.append(9);
				i += 4;
			}
		}

		answer = Integer.parseInt(sb.toString());

		return answer;
	}

	// 풀이2 (배열과 replaceAll 이용한 훨씬 간단한 풀이)
	private static int solution2(String s) {
		String[] numArr = {"zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

		for (int i = 0; i < 10; i++) {
			s = s.replaceAll(numArr[i], Integer.toString(i));
		}

		return Integer.parseInt(s);
	}
}
