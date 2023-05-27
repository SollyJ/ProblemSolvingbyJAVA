// Programmers_문자열 내림차순 배치
package String;

import java.util.ArrayList;

public class StringDesc {
	public static void main(String[] args) {
		String s = "Zbcdefg";
		System.out.println(solution(s));
	}

	private static String solution(String s) {
		String answer;
		int len = s.length();
		char[] answerChar = new char[len];

		// s의 각 문자 인덱스를 리스트에 넣어준다.
		ArrayList<Integer> idxList = new ArrayList<>(len);
		for (int i = 0; i < len; i++) {
			idxList.add(i);
		}

		// s를 순회하며 answer에 내림차순으로 문자를 넣어주기
		int i = 0;    // while 반복문에 쓰일 변수

		while (true) {
			if (idxList.isEmpty())    // 인덱스 리스트가 비었다는건 문자열 순회가 끝났단 뜻이므로 반복문 종료
				break;

			// idxList를 돌며 최대 문자 인덱스를 찾아 최대 문자를 찾는다.
			Character maxChar = Character.MIN_VALUE;    // 최대 문자
			int maxIdx = Integer.MIN_VALUE;    // 최대 문자의 인덱스

			for (int idx : idxList) {
				Character c = s.charAt(idx);
				if (c > maxChar) {
					maxChar = c;
					maxIdx = idx;
				}
			}

			// 최대 문자 인덱스를 idxList에서 제거 한다.
			idxList.remove(idxList.indexOf(maxIdx));

			// 최대문자를 answer에 넣어준다.
			answerChar[i] = maxChar;

			i++;
		}

		// 문자배열을 문자열로 바꿔주기
		answer = new String(answerChar);

		return answer;
	}
}
