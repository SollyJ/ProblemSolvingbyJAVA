package SimpleAlgorithm;

import java.util.Arrays;

public class Programmers_모의고사 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new int[] {1, 2, 3, 4, 5})));
		System.out.println(Arrays.toString(solution(new int[] {1, 3, 2, 4, 2})));
	}

	private static int[] solution(int[] answers) {
		int[] answer = {};
		int[] counts = new int[3];    // 맞힌 개수

		int[] person1_score = {1, 2, 3, 4, 5};    // 이 답이 반복
		int[] person2_score = {2, 1, 2, 3, 2, 4, 2, 5};
		int[] person3_score = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		for (int i = 0; i < answers.length; i++) {
			if (answers[i] == person1_score[i % 5])
				counts[0]++;
			if (answers[i] == person2_score[i % 8])
				counts[1]++;
			if (answers[i] == person3_score[i % 10])
				counts[2]++;
		}

		// 맞힌 개수 비교하며 배열에 넣어준다.
		// 배열에 원소를 삽입할땐 기존 배열을 복사해 크기를 1늘려준후 넣어준다.
		int max = Math.max(Math.max(counts[0], counts[1]), counts[2]);    // 셋 중 최댓값
		for (int i = 0; i < 3; i++) {
			if (counts[i] == max) {
				answer = Arrays.copyOf(answer, answer.length + 1);
				answer[answer.length - 1] = i + 1;
			}
		}

		return answer;
	}
}
