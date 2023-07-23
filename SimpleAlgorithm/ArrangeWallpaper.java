// Programmers_바탕화면 정리
package SimpleAlgorithm;

import java.util.Arrays;

public class ArrangeWallpaper {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(solution(new String[] {".#...", "..#..", "...#."})));
		System.out.println(
			Arrays.toString(
				solution(new String[] {"..........", ".....#....", "......##..", "...##.....", "....#....."})));
		System.out.println(Arrays.toString(solution(
			new String[] {".##...##.", "#..#.#..#", "#...#...#", ".#.....#.", "..#...#..", "...#.#...", "....#...."})));
		System.out.println(Arrays.toString(solution(new String[] {"..", "#."})));
	}

	private static int[] solution(String[] wallpaper) {
		int[] answer = new int[4];

		int lux = Integer.MAX_VALUE;
		int luy = Integer.MAX_VALUE;
		int rdx = Integer.MIN_VALUE;
		int rdy = Integer.MIN_VALUE;

		for (int x = 0; x < wallpaper.length; x++) {
			for (int y = 0; y < wallpaper[0].length(); y++) {
				char c = wallpaper[x].charAt(y);

				if (c == '#') {
					if (lux > x)
						lux = x;
					if (luy > y)
						luy = y;
					if (rdx < x + 1)
						rdx = x + 1;
					if (rdy < y + 1)
						rdy = y + 1;
				}
			}
		}

		answer[0] = lux;
		answer[1] = luy;
		answer[2] = rdx;
		answer[3] = rdy;
		
		return answer;
	}
}
