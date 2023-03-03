// Programmers_제일 작은수 제거
package ProgrammersLv1;

import java.util.Arrays;

public class RemoveMinNum {
	public static void main(String[] args) {
		int[] arr = {10, 1};
		int min = Integer.MAX_VALUE;

		// 제일 작은 수 구하기
		for (int e : arr) {
			if (e < min) {
				min = e;
			}
		}

		// min 빼기
		int finalMin = min;
		arr = Arrays.stream(arr).filter(i -> i != finalMin).toArray();

		if (arr.length == 0) {
			// -1 채워 넣기
			// 배열 복사 후 원소를 넣는다.
			arr = Arrays.copyOf(arr, arr.length + 1);
			arr[0] = -1;
			System.out.println(Arrays.toString(arr));
		} else {
			System.out.println(Arrays.toString(arr));
		}
	}
}
