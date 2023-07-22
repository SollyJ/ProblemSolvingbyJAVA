// Programmers 햄버거 만들기
package DataStructure;

import java.util.Stack;

public class MakingHamburger {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 1, 1, 2, 3, 1, 2, 3, 1}));
		System.out.println(solution(new int[] {1, 3, 2, 1, 2, 1, 3, 1, 2}));
	}

	private static int solution(int[] ingredient) {
		int answer = 0;

		Stack<Integer> stack = new Stack<>();

		for (int in : ingredient) {
			stack.push(in);

			if (stack.size() >= 4) {
				int mayBread1 = stack.pop();
				int mayMeat = stack.pop();
				int mayVeg = stack.pop();
				int mayBread2 = stack.pop();

				if (mayBread1 == 1 && mayMeat == 3 && mayVeg == 2 && mayBread2 == 1) {
					answer++;
				} else {
					stack.push(mayBread2);
					stack.push(mayVeg);
					stack.push(mayMeat);
					stack.push(mayBread1);
				}
			}
		}

		return answer;
	}
}
