// Programmers_옹알이
package Greedy;

public class Babbling {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"aya", "yee", "u", "maa"}));
		System.out.println(solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
	}

	private static int solution(String[] babbling) {
		int answer = 0;
		String[] speaks = {"aya", "ye", "woo", "ma"};

		for (String str : babbling) {
			for (String speak : speaks) {
				str = str.replaceFirst(speak, "?");    // 첫문자만 ?로 replace 한다.
			}
			if (str.matches(".*[a-z].*")) {
				continue;
			} else {
				answer++;
			}
		}
		return answer;
	}
}
