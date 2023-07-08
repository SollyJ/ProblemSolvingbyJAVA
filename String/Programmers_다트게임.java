package String;

public class Programmers_다트게임 {
	public static void main(String[] args) {
		System.out.println(solution("1S2D*3T"));
		System.out.println(solution("1D2S#10S"));
		System.out.println(solution("1D2S0T"));
		System.out.println(solution("1S*2T*3S"));
		System.out.println(solution("1D#2S*3S"));
		System.out.println(solution("1T2D3D#"));
		System.out.println(solution("1D2S3T*"));
	}

	private static int solution(String dartResult) {
		int answer = 0;

		String[] dartResultArr = dartResult.split("");

		int[] scoreArr = new int[3];    // 각 판당 점수가 들어갈 배열, 3세트만 한다고 문제에 제시
		int game = -1;

		for (int i = 0; i < dartResultArr.length; i++) {
			// 점수 넣기
			if (dartResultArr[i].matches("[0-9]")) {
				game++;

				if (dartResultArr[i + 1].matches("[0-9]")) {    // 두자리수이면 (== 10이면)
					scoreArr[game] += 10;
					i += 2;
				} else {
					scoreArr[game] += Integer.parseInt(dartResultArr[i]);
					i += 1;
				}
			}

			switch (dartResultArr[i]) {
				case "D":
					scoreArr[game] = (int)Math.pow(scoreArr[game], 2);
					break;
				case "T":
					scoreArr[game] = (int)Math.pow(scoreArr[game], 3);
					break;
				case "*":
					scoreArr[game] *= 2;
					if (game - 1 >= 0)
						scoreArr[game - 1] *= 2;
					break;
				case "#":
					scoreArr[game] *= -1;
			}
		}

		for (int score : scoreArr) {
			answer += score;
		}

		return answer;
	}
}
