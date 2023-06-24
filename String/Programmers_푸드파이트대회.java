package String;

public class Programmers_푸드파이트대회 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 3, 4, 6}));
		System.out.println(solution(new int[] {1, 7, 1, 2}));
	}

	private static String solution(int[] food) {
		String answer = "";
		StringBuilder sb = new StringBuilder();

		for (int f = 1; f < food.length; f++) {
			int num = food[f] / 2;    // 한 사람이 먹을 f번 음식 개수

			for (int i = 0; i < num; i++) {
				sb.append(f);    // num만큼 f번 음식을 배치한다.
			}
		}

		sb.append(0);    // 한 선수가 먹을 음식 배치가 끝났다면 중간에 물을 둔다.

		answer = sb.toString();    // 지금까지의 음식 배치를 answer에 넣어두고

		int len = answer.length() - 1;    // 물을 제외한 음식들 길이를 len에 저장
		for (int i = len - 1; i >= 0; i--) {    // 거꾸로 순회하며 answer에 붙여준다.
			answer = answer.concat(String.valueOf(answer.charAt(i)));
		}

		return answer;
	}
}
