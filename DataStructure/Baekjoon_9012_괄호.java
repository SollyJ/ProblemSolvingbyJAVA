package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Baekjoon_9012_괄호 {
	static String str;

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder sb = new StringBuilder();

			int T = Integer.parseInt(br.readLine());

			for (int i = 0; i < T; i++) {
				str = br.readLine();

				if (isVPS(str)) {
					sb.append("YES\n");
				} else {
					sb.append("NO\n");
				}
			}

			System.out.println(sb);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static boolean isVPS(String str) {
		Stack<Character> stack = new Stack<>();

		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == '(') {
				stack.push(str.charAt(i));
			} else {
				if (!stack.isEmpty()) {
					stack.pop();
				} else {
					return false;
				}
			}
		}

		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}
}
