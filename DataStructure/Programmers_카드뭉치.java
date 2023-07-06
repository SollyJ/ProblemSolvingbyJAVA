package DataStructure;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Programmers_카드뭉치 {
	public static void main(String[] args) {
		// String[] cards1 = {"i", "drink", "water"};
		// String[] cards2 = {"want", "to"};
		// String[] goal = {"i", "want", "to", "drink", "water"};

		String[] cards1 = {"i", "water", "drink"};
		String[] cards2 = {"want", "to"};
		String[] goal = {"i", "want", "to", "drink", "water"};

		System.out.println(solution(cards1, cards2, goal));
	}

	private static String solution(String[] cards1, String[] cards2, String[] goal) {
		Queue<String> cards1_queue = new LinkedList<>(Arrays.asList(cards1));
		Queue<String> cards2_queue = new LinkedList<>(Arrays.asList(cards2));

		for (String word : goal) {
			if (!cards1_queue.isEmpty() && cards1_queue.peek().equals(word)) {
				cards1_queue.poll();
			} else if (!cards2_queue.isEmpty() && cards2_queue.peek().equals(word)) {
				cards2_queue.poll();
			} else {
				return "No";
			}
		}

		return "Yes";
	}
}
