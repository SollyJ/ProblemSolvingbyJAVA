// 백트래킹
package DFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Baekjoon_2529_부등호 {
	static int k;    // 부등호 개수
	static char[] marks;
	static boolean[] visited;
	static ArrayList<String> numList;    // 부등호 만족하는 정수문자열 넣을 리스트

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			k = Integer.parseInt(br.readLine());
			marks = new char[k];
			visited = new boolean[10];    // 0~9
			numList = new ArrayList<>();

			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < k; i++) {
				marks[i] = st.nextToken().toCharArray()[0];
			}

			dfs(0, "");

			Collections.sort(numList);
			int len = numList.size();
			System.out.println(numList.get(len - 1));
			System.out.println(numList.get(0));
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private static void dfs(int index, String number) {

		if (index == k + 1) {
			numList.add(number);
			return;
		}

		for (int n = 0; n <= 9; n++) {
			if (!visited[n]) {
				if (index == 0 || check(number.charAt(index - 1), (char)(n + '0'), marks[index - 1])) {
					visited[n] = true;

					dfs(index + 1, number + n);

					visited[n] = false;    // 하나 찾았으면 방문배열 초기화 해주기
				}
			}
		}
	}

	// n1 mark n2가 옳은지 체크해주는 함수
	private static boolean check(char n1, char n2, char mark) {
		if (mark == '<') {
			return n1 < n2;
		} else if (mark == '>') {
			return n1 > n2;
		}

		return false;
	}
}
