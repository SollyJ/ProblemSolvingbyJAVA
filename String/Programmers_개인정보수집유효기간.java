package String;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Programmers_개인정보수집유효기간 {
	public static void main(String[] args) {
		// String today = "2022.05.19";
		// String[] terms = {"A 6", "B 12", "C 3"};
		// String[] privacies = {"2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"};

		String today = "2020.01.01";
		String[] terms = {"Z 3", "D 5"};
		String[] privacies = {"2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"};

		System.out.println(Arrays.toString(solution(today, terms, privacies)));
	}

	private static int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<>();

		// 오늘 날짜 년, 월, 일로 나눠서 배열에 넣기
		int[] todayArr = new int[3];
		todayArr[0] = Integer.parseInt(today.split("\\.")[0]);    // 년
		todayArr[1] = Integer.parseInt(today.split("\\.")[1]);    // 월
		todayArr[2] = Integer.parseInt(today.split("\\.")[2]);    // 일

		// 약관별 유효기간을 map에 넣기
		HashMap<String, Integer> termsMap = new HashMap<>();
		for (String term : terms) {
			termsMap.put(term.split(" ")[0], Integer.parseInt(term.split(" ")[1]));
		}

		for (int i = 0; i < privacies.length; i++) {
			String collectDate = privacies[i].split(" ")[0];    // 개인정보 수집 일자
			int year = Integer.parseInt(collectDate.split("\\.")[0]);
			int month = Integer.parseInt(collectDate.split("\\.")[1]);
			int day = Integer.parseInt(collectDate.split("\\.")[2]);

			String term = privacies[i].split(" ")[1];

			// 오늘 날짜와 개인정보 수집 일자의 차이가 유효기간보다 크거나 같으면 파기
			// 계산 편의를 위해 일로 다 바꿔준 후 계산한다.
			int diff = (todayArr[0] - year) * 28 * 12
				+ (todayArr[1] - month) * 28
				+ (todayArr[2] - day);

			int expiration = termsMap.get(term) * 28;

			if (diff >= expiration) {
				answer.add(i + 1);
			}
		}

		return answer.stream().mapToInt(i -> i).toArray();
	}
}
