// Programmers 실패율
package Map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;

public class FailRate {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(5, new int[] {2, 1, 2, 6, 2, 4, 3, 3})));
		System.out.println(Arrays.toString(solution(10, new int[] {1, 2, 3, 3, 4, 5, 5})));
	}

	private static int[] solution(int N, int[] stages) {
		int[] answer = new int[N];

		// <스테이지 번호, 몇명이 거쳤는지>
		HashMap<Integer, Integer> map = new HashMap<>();
		// <스테이지 번호, 실패율>
		HashMap<Integer, Double> failRate = new HashMap<>();
		// i번째 스테이지에 멈춰있는 유저 수
		int[] stopUsers = new int[N + 1];

		// 스테이지마다 몇명이 거쳤는지 map에 넣기
		for (int stage : stages) {
			if (stage == N + 1) {    // 이 유저는 모든 스테이지를 다 클리어 한 것
				stage--;
			} else {
				stopUsers[stage]++;    // 현재 스테이지에 멈춰있는 유저수 +1
			}

			// ex) 3번 스테이지에 멈춰 있다는 것은 1, 2, 3번 스테이지를 거쳤다는 것
			// 따라서 stage번호를 줄여가며 map에 put해준다.
			while (stage > 0) {
				if (map.containsKey(stage)) {
					int temp = map.get(stage);
					map.put(stage--, temp + 1);
				} else {
					map.put(stage--, 1);
				}
			}
		}

		// 스테이지마다 실패율 계산
		for (int i = 1; i <= N; i++) {
			// System.out.println(stopUsers[i] + " " + map.get(i) + " " + (double)stopUsers[i] / map.get(i));
			if (!map.containsKey(i)) {    // 예외처리: i번째 스테이지에 도달한 적이 없는 경우 실패율은 0
				failRate.put(i, 0.0);
			} else {
				failRate.put(i, (double)stopUsers[i] / map.get(i));    // i번째 스테이지의 실패율
			}
		}

		// 실패율 기준으로 내림차순
		List<Integer> keySet = new ArrayList<>(failRate.keySet());
		keySet.sort(new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Double.compare(failRate.get(o2), failRate.get(o1));
			}
		});

		// 내림차순 정렬된 key(스테이지 번호) answer에 차례대로 넣기
		for (int i = 0; i < N; i++) {
			answer[i] = keySet.get(i);
		}

		return answer;
	}
}
