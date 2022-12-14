// Baekjoon_2751_수정렬2
// 병합정렬 Merge Sort
package Sort;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MergeSort {
	// 계속 호출되니까 전역에 선언
	public static int[] temp;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		int[] arr = new int[N];
		temp = new int[N];    // 병합정렬 할 때 임시로 쓰일 정렬변수

		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		mergeSort(arr, 0, N - 1);

		for (int i = 0; i < N; i++) {
			bw.write((arr[i] + "\n"));
		}

		bw.flush();
		bw.close();
	}

	// 병합 정렬 할 그룹을 나누는 함수
	static void mergeSort(int[] array, int start, int end) {
		if (start < end) {
			int mid = (start + end) / 2;
			mergeSort(array, start, mid);
			mergeSort(array, mid + 1, end);
			merge(array, start, end, mid);
		}
	}

	// 병합 정렬 하는 함수
	static void merge(int[] array, int start, int end, int mid) {
		int k = start;
		int index1 = start;
		int index2 = mid + 1;
		// 두 그룹을 비교해 병합하는 로직
		while (index1 <= mid && index2 <= end) {
			if (array[index1] < array[index2]) {
				temp[k] = array[index1];
				k++;
				index1++;
			} else {
				temp[k] = array[index2];
				k++;
				index2++;
			}
		}

		// 남아있는 값 정리 하기
		while (index1 <= mid) {
			temp[k] = array[index1];
			k++;
			index1++;
		}
		while (index2 <= end) {
			temp[k] = array[index2];
			k++;
			index2++;
		}

		for (int i = start; i <= end; i++) {
			array[i] = temp[i];
		}
	}
}
