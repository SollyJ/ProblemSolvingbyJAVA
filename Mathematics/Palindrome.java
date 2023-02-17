// Baekjoon_1747_팰린드롬
package Mathematics;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		// 1단게: 2~10000000 까지 중 소수를 구한다.
		int[] nums = new int[10000001];

		for (int i = 2; i <= 10000000; i++) {
			nums[i] = i;
		}

		for (int i = 2; i <= Math.sqrt(10000001); i++) {
			if (nums[i] == 0)
				continue;

			for (int j = i * 2; j <= 10000000; j += i) {
				nums[j] = 0;
			}
		}

		// 2단계: 팰린드롬 수를 찾는다.
		for (int i = N; i <= 10000000; i++) {
			if (nums[i] != 0) {    // 소수 이면서
				if (isPalindrome(nums[i])) {    // 팰린드롬 이면
					System.out.println(nums[i]);
					break;
				}
			}
		}
	}

	// 팰린드롬 판별 함수
	private static boolean isPalindrome(int number) {
		char[] numToChar = String.valueOf(number).toCharArray();    // 숫자를 char형 배열로 바꾼다.
		short s = 0;    // start
		short e = (short)(numToChar.length - 1);    // end
		while (s < e) {
			if (numToChar[s] != numToChar[e]) {
				return false;
			}
			s++;
			e--;
		}
		return true;
	}
}
