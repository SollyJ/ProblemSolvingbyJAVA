// Programmers_예산
package ProgrammersLv1;

import java.util.Arrays;

public class Budget {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 3, 2, 5, 4}, 9));
		System.out.println(solution(new int[] {2, 2, 3, 3}, 10));
	}

	private static int solution(int[] d, int budget) {
		int answer = 0;
		int sum = 0;

		Arrays.sort(d);

		int i = 0;
		while (i < d.length) {
			sum += d[i];

			if (sum > budget)
				break;

			i++;
		}

		answer = i;

		return answer;
	}
}