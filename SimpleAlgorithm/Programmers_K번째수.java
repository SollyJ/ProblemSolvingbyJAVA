package SimpleAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Programmers_K번째수 {
	public static void main(String[] args) {
		int[] arr = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}};

		System.out.println(Arrays.toString(solution(arr, commands)));
	}

	private static int[] solution(int[] array, int[][] commands) {
		int[] answer = new int[commands.length];

		for (int i = 0; i < commands.length; i++) {
			ArrayList<Integer> newArr = getNewArr(array, commands[i][0], commands[i][1]);

			int k = commands[i][2];
			answer[i] = newArr.get(k - 1);
		}

		return answer;
	}

	private static ArrayList<Integer> getNewArr(int[] array, int i, int j) {
		ArrayList<Integer> newArr = new ArrayList<>();

		for (int n = i - 1; n < j; n++) {
			newArr.add(array[n]);
		}

		Collections.sort(newArr);

		return newArr;
	}
}
