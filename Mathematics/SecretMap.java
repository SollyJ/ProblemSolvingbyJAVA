// Programmers_비밀지도
package Mathematics;

import java.util.Arrays;
import java.util.Scanner;

public class SecretMap {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		int n = scan.nextInt();
		int[] arr1 = new int[n];
		for (int i = 0; i < n; i++) {
			arr1[i] = scan.nextInt();
		}

		int[] arr2 = new int[n];
		for (int i = 0; i < n; i++) {
			arr2[i] = scan.nextInt();
		}

		String[] result = solution(n, arr1, arr2);
		System.out.println(Arrays.toString(result));
	}

	private static String[] solution(int n, int[] arr1, int[] arr2) {
		String[] answer = new String[n];

		for (int i = 0; i < n; i++) {
			String bin = decToBin(arr1[i] | arr2[i]);
			// n 자리수 채우기
			while (bin.length() < n) {
				bin = "0" + bin;
			}

			bin = bin.replaceAll("1", "#");
			bin = bin.replaceAll("0", " ");
			answer[i] = bin;
		}

		return answer;
	}

	// 10진수 -> 2진수 변환 함수
	private static String decToBin(int decimal) {
		StringBuilder sb = new StringBuilder();
		String binary = "";

		while (decimal > 0) {
			sb.append(decimal % 2);
			decimal /= 2;
		}

		binary = sb.reverse().toString();
		return binary;
	}
}
