package SimpleAlgorithm;

import java.util.HashSet;

public class Programmers_키패드누르기 {
	public static void main(String[] args) {

	}

	private static String solution(int[] numbers, String hand) {
		StringBuilder answer = new StringBuilder();

		HashSet<Integer> left = new HashSet<>();
		HashSet<Integer> right = new HashSet<>();

		left.add(1);
		left.add(4);
		left.add(7);
		right.add(3);
		right.add(6);
		right.add(9);

		// 현재 왼쪽, 오른쪽 엄지 위치
		// *은 10, #은 11로 둔다.
		int nowL = 10;
		int nowR = 12;

		for (int num : numbers) {
			if (left.contains(num)) {
				answer.append("L");
				nowL = num;
			} else if (right.contains(num)) {
				answer.append("R");
				nowR = num;
			} else if (num == 0) {
				num = 11;    // 0은 11로 두고 푼다.

				// num과 현재 두 엄지와의 거리를 계산
				// 위아래로는 3의 배수로 증가하므로 (절댓값의 /3을 한것)이 거리이고, 좌우로는 1씩 증가하고 한줄에 3개 까지 있으므로 (절댓값을 3으로 나눈 나머지)가 거리이다.
				int leftDist = Math.abs(num - nowL) / 3 + Math.abs(num - nowL) % 3;
				int rightDist = Math.abs(num - nowR) / 3 + Math.abs(num - nowR) % 3;

				if (leftDist > rightDist) {
					answer.append("R");
					nowR = num;
				} else if (leftDist < rightDist) {
					answer.append("L");
					nowL = num;
				} else {
					if (hand.equals("right")) {
						answer.append("R");
						nowR = num;
					} else {
						answer.append("L");
						nowL = num;
					}
				}
			} else {
				// num과 현재 두 엄지와의 거리를 계산
				int leftDist = Math.abs(num - nowL) / 3 + Math.abs(num - nowL) % 3;
				int rightDist = Math.abs(num - nowR) / 3 + Math.abs(num - nowR) % 3;

				if (leftDist > rightDist) {
					answer.append("R");
					nowR = num;
				} else if (leftDist < rightDist) {
					answer.append("L");
					nowL = num;
				} else {
					if (hand.equals("right")) {
						answer.append("R");
						nowR = num;
					} else {
						answer.append("L");
						nowL = num;
					}
				}
			}
		}

		return answer.toString();
	}
}
