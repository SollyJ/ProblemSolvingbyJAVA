package String;

public class Programmers_옹알이2 {
	public static void main(String[] args) {
		System.out.println(solution(new String[] {"aya", "yee", "u", "maa"}));
		System.out.println(solution(new String[] {"ayaye", "uuu", "yeye", "yemawoo", "ayaayaa"}));
	}

	private static int solution(String[] babbling) {
		int answer = 0;

		for (String bab : babbling) {
			// 같은 문자열 연속인게 있으면 넘어감
			if (bab.contains("ayaaya") || bab.contains("yeye") || bab.contains("woowoo") || bab.contains("mama")) {
				continue;
			}

			// " "로 먼저 바꿔준 후, ""로 바꿔주는 이유
			// 반례: "yayae"
			bab = bab.replace("aya", " ");
			bab = bab.replace("ye", " ");
			bab = bab.replace("woo", " ");
			bab = bab.replace("ma", " ");
			bab = bab.replace(" ", "");

			if (bab.equals(""))
				answer++;
		}

		return answer;
	}
}
