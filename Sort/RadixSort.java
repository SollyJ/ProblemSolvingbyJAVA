// 기수정렬(radixSort)
package Sort;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int N = Integer.parseInt(br.readLine());    // 정렬할 데이터 개수
		int[] arr = new int[N];
		// N개의 입력 배열에 저장
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		Queue<Integer>[] queue = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			queue[i] = new LinkedList<>();  // 큐 안의 데이터들도 list로 구현
		}

		int max_jarisu = maxDigitCount(arr);
		int digitNumber = 0;   // 각 자리의 숫자 저장할 변수
		int arrIndex = 0;   // 배열에 다시 저장할 때 인덱스

		// 최대 자리수 만큼 반복
		for (int i = 0; i < max_jarisu; i++) {
			for (int j = 0; j < N; j++) {
				digitNumber = getDigit(arr[j], i);
				queue[digitNumber].add(arr[j]);
			}

			// 큐안에 들어있는 데이터를 순서대로 꺼내 배열에 덮어씌움
			for (int j = 0; j < 10; j++) {
				while (!queue[j].isEmpty()) {
					arr[arrIndex++] = queue[j].remove();
				}
			}
			arrIndex = 0;
		}

		for (int i = 0; i < N; i++) {
			System.out.println(arr[i]);
		}
	}

	// 숫자의 자리수 반환하는 함수
	// getDigit(234, 0) -> 4
	// getDigit(234, 1) -> 3
	// getDigit(234, 2) -> 2
	private static int getDigit(int num, int index) {
		return (int)Math.floor(num / Math.pow(10, index)) % 10;
	}

	// 숫자의 자리수 구하기
	// digitCount(45) -> 2
	// digitCount(123) -> 3
	private static int digitCount(int num) {
		if (num == 0)
			return 1;

		// log10을 하면 자리수가 나온다.
		return (int)Math.floor(Math.log10(num)) + 1;
	}

	// 배열 중 숫자 자리수가 최대인 것을 구하기
	private static int maxDigitCount(int[] arr) {
		int max = 0;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, digitCount(arr[i]));
		}
		return max;
	}
}