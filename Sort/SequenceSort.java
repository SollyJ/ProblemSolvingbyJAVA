// Baekjoon_1015_수열정렬
package Sort;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class SequenceSort {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			short N = Short.parseShort(br.readLine());

			ArrayList<mData> A_list = new ArrayList<>();
			short[] P = new short[N];

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (short i = 0; i < N; i++) {
				A_list.add(new mData(Short.parseShort(st.nextToken()), i));
			}

			Collections.sort(A_list);

			// 배열 P에 값 추가하기
			for (short i = 0; i < N; i++) {
				P[A_list.get(i).index] = i;    // A_list.get(i).index는 해당 원소가 오름차순 하기 전 인덱스
			}

			// 배열 P 출력하기
			for (short i = 0; i < N; i++) {
				System.out.print(P[i] + " ");
			}

			br.close();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
