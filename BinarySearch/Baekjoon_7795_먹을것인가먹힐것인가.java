package BinarySearch;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_7795_먹을것인가먹힐것인가 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();

			int T = Integer.parseInt(br.readLine());

			for (int t = 0; t < T; t++) {
				st = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(st.nextToken());
				int M = Integer.parseInt(st.nextToken());

				List<Integer> aList = new ArrayList<>(N);
				List<Integer> bList = new ArrayList<>(M);

				st = new StringTokenizer(br.readLine());
				for (int n = 0; n < N; n++) {
					aList.add(Integer.parseInt(st.nextToken()));
				}

				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					bList.add(Integer.parseInt(st.nextToken()));
				}
				Collections.sort(bList);

				int count = 0;

				// 이분탐색으로 B보다 큰 A를 카운트한다.
				for (int n = 0; n < N; n++) {
					int start = 0;
					int end = M - 1;
					int ind = 0;

					while (start <= end) {
						int mid = (start + end) / 2;

						if (aList.get(n) > bList.get(mid)) {
							start = mid + 1;
							ind = mid + 1;
						} else {
							end = mid - 1;
						}
					}

					count += ind;
				}

				sb.append(count).append("\n");
			}

			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
