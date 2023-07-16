package DataStructure;

import java.util.Stack;

public class Programmers_크레인인형뽑기 {
	public static void main(String[] args) {
		System.out.println(
			solution(new int[][] {{0, 0, 0, 0, 0}, {0, 0, 1, 0, 3}, {0, 2, 5, 0, 1}, {4, 2, 4, 4, 2}, {3, 5, 1, 3, 1}},
				new int[] {1, 5, 3, 5, 1, 2, 1, 4}));
	}

	private static int solution(int[][] board, int[] moves) {
		int answer = 0;
		int len = board.length;
		Stack<Integer> basket = new Stack<>();    // 바구니

		// n번을 집어 올렸을 때나오는 인형: board[i][n-1]
		for (int n : moves) {
			for (int i = 0; i < len; i++) {
				int now = board[i][n - 1];
				if (now != 0) {
					// 같은 인형 연속해서 쌓이면 사라짐
					if (!basket.isEmpty() && basket.peek() == now) {
						basket.pop();
						answer += 2;    // 같은 인형 두개가 사라짐
						board[i][n - 1] = 0;
						break;
					}

					// 바구니에 인형 넣기
					basket.push(now);
					board[i][n - 1] = 0;
					break;
				}
			}
		}

		return answer;
	}
}
