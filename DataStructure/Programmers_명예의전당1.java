package DataStructure;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Programmers_명예의전당1 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution1(3, new int[] {10, 100, 20, 150, 1, 100, 200})));
		System.out.println(Arrays.toString(solution2(4, new int[] {0, 300, 40, 300, 20, 70, 150, 50, 500, 1000})));
	}

	// 리스트 정렬 이용
	private static int[] solution1(int k, int[] score) {
		int len = score.length;
		int[] answer = new int[len];
		List<Integer> 명예의전당 = new ArrayList<>();

		for (int i = 0; i < len; i++) {
			명예의전당.add(score[i]);
			Collections.sort(명예의전당, Collections.reverseOrder());    // 내림차순

			// 예외: k가 socre길이보다 큰 경우도 있음을 주의
			// k일 전까지는 최솟값을 넣어준다.
			if (k > len || i < k) {
				answer[i] = 명예의전당.get(명예의전당.size() - 1);
			} else {    // k일 다음날 부터는 k등(인덱스로는 k-1)의 점수를 넣어준다.
				answer[i] = 명예의전당.get(k - 1);
			}
		}

		return answer;
	}

	// 우선 순위 큐 이용
	private static int[] solution2(int k, int[] score) {
		int len = score.length;
		int[] answer = new int[len];

		PriorityQueue<Integer> 명예의전당 = new PriorityQueue<>();
		
		for (int i = 0; i < len; i++) {
			명예의전당.add(score[i]);

			if (명예의전당.size() > k) {
				명예의전당.poll();
			}

			answer[i] = 명예의전당.peek();
		}

		return answer;
	}
}
