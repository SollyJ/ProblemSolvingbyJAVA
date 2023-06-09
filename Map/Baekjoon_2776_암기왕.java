package Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Baekjoon_2776_암기왕 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;
			StringBuilder sb = new StringBuilder();    // 시간초과 방지위해 사용

			int T = Integer.parseInt(br.readLine());

			for (int t = 0; t < T; t++) {
				int N = Integer.parseInt(br.readLine());

				HashSet<Integer> note1 = new HashSet<>();    // 검색할때 가장 빠른 자료구조

				st = new StringTokenizer(br.readLine());
				for (int n = 0; n < N; n++) {
					note1.add(Integer.parseInt(st.nextToken()));
				}

				int M = Integer.parseInt(br.readLine());

				st = new StringTokenizer(br.readLine());
				for (int m = 0; m < M; m++) {
					if (note1.contains(Integer.parseInt(st.nextToken()))) {
						sb.append("1\n");
					} else {
						sb.append("0\n");
					}
				}
			}

			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
