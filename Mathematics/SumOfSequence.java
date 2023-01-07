// baekjoon 1024
package Mathematics;

import java.util.Scanner;

public class SumOfSequence {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		long n = scan.nextInt();
		long l = scan.nextInt();
		long start_num = 0;
		long temp_sum = 0;
		boolean flag = true;

		while (l <= 100) {
			start_num = n / l - (l - 1) / 2;  // 처음 시작 수를 구한다

			if (start_num < 0) {
				break;
			}

			temp_sum = (start_num * 2 + l - 1) * l / 2; // 처음시작수+1씩 한것을 l만큼 더한값

			if (n == temp_sum) {
				for (long k = 0; k < l; k++) {
					System.out.print(start_num + k + " ");    // 프린트
				}
				flag = false;
				break;
			}
			l++;
		}

		if (flag)
			System.out.print("-1");
	}
}