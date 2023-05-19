package SimpleAlgorithm;

import java.util.Scanner;

public class Baekjoon_1436_영화감독숌 {
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int N = scan.nextInt();

		int n = 1;
		int endNum = 666;

		while (n != N) {
			endNum++;

			String endNumToStr = String.valueOf(endNum);

			if (endNumToStr.contains("666")) {
				n++;
			}

		}

		System.out.println(endNum);
	}
}
