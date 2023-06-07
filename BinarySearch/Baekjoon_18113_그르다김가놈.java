package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_18113_그르다김가놈 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {

			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());    // 김밥 개수
			int K = Integer.parseInt(st.nextToken());    // 꼬다리 길이
			int M = Integer.parseInt(st.nextToken()); // 김밥 조각의 최소 개수

			ArrayList<Integer> handedGimbabList = new ArrayList<>(N);

			for (int i = 0; i < N; i++) {
				int L = Integer.parseInt(br.readLine());    // 김밥 길이

				if (L <= K)    // 폐기
					continue;

				// 손질된 김밥 길이 리스트에 넣기
				if (L < 2 * K) {
					handedGimbabList.add(L - K);
				} else {
					handedGimbabList.add(L - (2 * K));
				}
			}

			/* 이분 탐색 */
			int start = 1;
			int end = 1000000000;    // 최대 김밥 길이
			int P = -1;

			while (start <= end) {
				int mid = (start + end) / 2;    // 김밥 조각 길이: mid(cm)
				int temp = calc(handedGimbabList, mid);

				if (temp >= M) {    // 김밥 조각 최소 개수보다 같거나 크다면
					P = mid;
					start = mid + 1;    // start를 증가 시켜줘서 조각 길이를 더 늘린다
				} else {
					end = mid - 1;    // end를 감소 시켜줘서 조각 길이를 줄인다
				}
			}

			System.out.println(P);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static int calc(List<Integer> list, int mid) {
		int 총김밥조각개수 = 0;

		for (int handed : list) {
			총김밥조각개수 += (handed / mid);    // mid(cm)로 자른 김밥 조각 개수 더하기
		}

		return 총김밥조각개수;
	}
}
