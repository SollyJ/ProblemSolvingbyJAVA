package Map;

import java.util.Arrays;
import java.util.HashMap;

public class Programmers_대충만든자판 {
	public static void main(String[] args) {
		// String[] keymap = {"ABACD", "BCEFD"};
		// String[] keymap = {"AA"};
		// String[] keymap = {"AGZ", "BSSS"};
		String[] keymap = {"BC"};

		// String[] targets = {"ABCD", "AABB"};
		// String[] targets = {"B"};
		// String[] targets = {"ASA", "BGZ"};
		String[] targets = {"AC", "BC"};

		System.out.println(Arrays.toString(solution(keymap, targets)));
	}

	private static int[] solution(String[] keymap, String[] targets) {
		int[] answer = new int[targets.length];

		// <문자, 몇번 눌러야하는지>
		HashMap<Character, Integer> map = new HashMap<>();

		for (String key : keymap) {
			for (int i = 0; i < key.length(); i++) {
				char c = key.charAt(i);

				if (!map.containsKey(c)) {
					map.put(c, i + 1);
				} else {
					if (i + 1 < map.get(c)) {
						map.put(c, i + 1);
					}
				}
			}
		}

		for (int i = 0; i < targets.length; i++) {
			int count = 0;

			for (int j = 0; j < targets[i].length(); j++) {
				if (map.containsKey(targets[i].charAt(j))) {
					count += map.get(targets[i].charAt(j));
				} else {
					count = -1;
					break;
				}
			}

			answer[i] = count;
		}

		return answer;
	}
}
