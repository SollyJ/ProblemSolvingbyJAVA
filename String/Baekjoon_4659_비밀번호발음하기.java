package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Baekjoon_4659_비밀번호발음하기 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder sb = new StringBuilder();

			while (true) {
				String pw = br.readLine();
				if (pw.equals("end"))
					break;

				sb.append("<").append(pw).append("> is ");

				if (!isAcceptable(pw)) {
					sb.append("not ");
				}

				sb.append("acceptable.").append("\n");
			}

			System.out.println(sb);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private static boolean isAcceptable(String password) {
		List<Character> pwToChars = new ArrayList<>();
		int len = password.length();

		for (int i = 0; i < password.length(); i++) {
			pwToChars.add(password.charAt(i));
		}

		// 조건1
		if (!haveVowel(pwToChars))
			return false;

		// 조건2
		for (int i = 0; i <= len - 3; i++) {
			if (isVowel(pwToChars.get(i))) {    // 모음일때
				if (isVowel(pwToChars.get(i + 1)) && isVowel(pwToChars.get(i + 2))) {    // 모음이 3개 연속이면
					return false;
				}
			} else {    // 자음일때
				if (!isVowel(pwToChars.get(i + 1)) && !isVowel(pwToChars.get(i + 2))) {    // 자음이 3개 연속이면
					return false;
				}
			}
		}

		// 조건3
		for (int i = 0; i <= len - 2; i++) {
			if (pwToChars.get(i) == pwToChars.get(i + 1)) {
				if (pwToChars.get(i) != 'e' && pwToChars.get(i) != 'o') {
					return false;
				}
			}
		}

		return true;
	}

	private static boolean haveVowel(List<Character> list) {
		return (list.contains('a') || list.contains('e') || list.contains('i') || list.contains('o')
			|| list.contains('u'));
	}

	private static boolean isVowel(Character c) {
		return (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u');
	}
}
