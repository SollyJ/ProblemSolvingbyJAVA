// Programmers_정수 내림차순 배치
package ProgrammersLv1;

import java.util.ArrayList;
import java.util.Collections;

public class IntegerDescending {
	public static void main(String[] args) {
		long n = 8346723;
		long answer = 0;
		ArrayList<Short> answerArr = new ArrayList<>();
		String answerStr = "";

		// 1의 자리부터 리스트에 차례대로 넣는다.
		while (true) {
			if (n == 0)
				break;

			answerArr.add((short)(n % 10));
			n /= 10;
		}

		// 리스트를 내림차순 정렬
		Collections.sort(answerArr, Collections.reverseOrder());

		// 리스트의 값(short)을 차례대로 문자열형 answer에 넣는다.
		for (short i : answerArr) {
			answerStr += i;
		}

		// 문자열형 answer을 long형으로 바꿔주어 최종적으로 answer을 구한다.
		answer = Long.parseLong(answerStr);

		System.out.println(answer);
	}
}
