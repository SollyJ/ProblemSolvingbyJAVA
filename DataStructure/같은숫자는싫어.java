// Programmers_같은숫자는싫어
// 스택
package DataStructure;

import java.util.Arrays;
import java.util.Stack;

public class 같은숫자는싫어 {
	public static void main(String[] args) {
		int[] arr = {3, 3, 4, 5, 6, 6, 1};

		System.out.println(Arrays.toString(solution(arr)));
	}

	private static int[] solution(int[] arr) {
		Stack<Integer> stack = new Stack<>();

		stack.push(arr[0]);

		for (int e : arr) {
			if (stack.peek() != e)
				stack.push(e);
		}

		int[] answer = new int[stack.size()];

		for (int i = 0; i < answer.length; i++) {
			answer[i] = stack.get(i);
		}

		return answer;
	}
}
