package Map;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.StringTokenizer;

public class Baekjoon_2910_빈도정렬 {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;

			// 저장 순서를 기억해야하므로 LinkedHashMap !
			HashMap<Long, Integer> frequency = new LinkedHashMap<>();    // <숫자, 카운트>

			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < N; i++) {
				long num = Integer.parseInt(st.nextToken());

				if (frequency.containsKey(num)) {
					int cnt = frequency.get(num);
					frequency.put(num, cnt + 1);
				} else {
					frequency.put(num, 1);
				}
			}

			// 카운트 내림차순 정렬
			List<Long> keyList = new ArrayList<>(frequency.keySet());

			keyList.sort(new Comparator<Long>() {
				@Override
				public int compare(Long o1, Long o2) {
					return frequency.get(o2).compareTo(frequency.get(o1));
				}
			});

			// 출력
			Iterator<Long> it = keyList.iterator();
			while (it.hasNext()) {
				Long num = it.next();

				for (int i = 0; i < frequency.get(num); i++) {
					System.out.print(num + " ");
				}
			}
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
