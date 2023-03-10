// Programmers_최대공약수최소공배수
package ProgrammersLv1;

public class 최대공약수_최소공배수 {
	public static void main(String[] args) {
		int n = 2;
		int m = 5;
		int small, big;
		int gcd, lcm;

		if (n <= m) {
			small = n;
			big = m;
		} else {
			small = m;
			big = n;
		}

		gcd = gcd(small, big);
		lcm = n * m / gcd;    // 최소공배수 = 두 * 수 / 최대공약수

		System.out.println(gcd);
		System.out.println(lcm);
	}

	// 최대공약수 구하는 함수
	private static int gcd(int s, int b) {
		int gcd = 0;

		for (int i = 1; i <= s; i++) {
			if (s % i == 0) {    // 작은수와 나누어 떨어지는 수가
				if (b % i == 0) {    // 큰수와도 나누어 떨어지면 공약수
					gcd = i;
				}
			}
		}

		return gcd;
	}
}
