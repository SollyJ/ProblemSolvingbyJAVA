// Programmers_문자열 정수로 바꾸기
package SimpleAlgorithm;

public class StringToInt {
	public static void main(String[] args) {
		String s = "8789";
		System.out.println(solution(s));
	}

	private static int solution(String s) {
		int answer = 0;
		boolean flag = true;
		short len = (short)s.length();

		if (s.charAt(0) == '-') {
			flag = false;
			answer = strToInt(s.substring(1, len));
		} else if (s.charAt(0) == '+') {
			answer = strToInt(s.substring(1, len));
		} else {
			answer = strToInt(s.substring(0, len));
		}

		return flag ? answer : -1 * answer;
	}

	private static int strToInt(String s) {
		int num = 0;
		short len = (short)s.length();

		// 문자열 인덱스 0부터 순회해 정수 num에 더해준다.
		// 따라서 10을 인덱스만큼 곱해줘야한다.
		for (short i = 0; i < len; i++) {
			num = num * 10 + s.charAt(i) - '0';
		}

		return num;
	}
}
