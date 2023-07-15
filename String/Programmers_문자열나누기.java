package String;

public class Programmers_문자열나누기 {
	public static void main(String[] args) {
		System.out.println(solution("banana"));
		System.out.println(solution("abracadabra"));
		System.out.println(solution("aaabbaccccabba"));
	}

	private static int solution(String s) {
		int answer = 0;

		char x = s.charAt(0);

		int xCnt = 0;
		int notxCnt = 0;

		for (int i = 0; i < s.length(); i++) {
			if (xCnt == notxCnt) {
				x = s.charAt(i);
				answer++;
			}
			if (x == s.charAt(i))
				xCnt++;
			else
				notxCnt++;

		}

		return answer;
	}
}
