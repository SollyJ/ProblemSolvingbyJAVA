package String;

public class Programmers_신규아이디추천 {
	public static void main(String[] args) {
		System.out.println(solution("...!@BaT#*..y.abcdefghijklm"));
		System.out.println(solution("z-+.^."));
		System.out.println(solution("=.="));
		System.out.println(solution("123_.def"));
		System.out.println(solution("abcdefghijklmn.p"));

	}

	private static String solution(String new_id) {
		String answer = new_id;

		// 1단계
		answer = answer.toLowerCase();

		// 2단계
		int i = 0;
		while (i < answer.length()) {
			char temp = answer.charAt(i);

			if ((97 <= temp && temp <= 122) || (48 <= temp && temp <= 57) || temp == '-' || temp == '_'
				|| temp == '.') {
				i++;
				continue;
			}

			answer = answer.replace(String.valueOf(temp), "");
			i = 0;
		}

		// 3단계
		while (answer.contains("..")) {
			answer = answer.replace("..", ".");
		}

		// 4단계
		if (answer.startsWith(".")) {
			answer = answer.substring(1);
		}
		if (answer.endsWith(".")) {
			answer = answer.substring(0, answer.length() - 1);
		}

		// 5단계
		if (answer.length() == 0) {
			answer = "a";
		}

		// 6단계
		if (answer.length() >= 16) {
			answer = answer.substring(0, 15);

			if (answer.endsWith(".")) {
				answer = answer.substring(0, answer.length() - 1);
			}
		}

		// 7단계
		if (answer.length() <= 2) {
			String temp = answer.substring(answer.length() - 1);

			while (answer.length() < 3) {
				answer = answer.concat(temp);
			}
		}

		return answer;
	}
}
