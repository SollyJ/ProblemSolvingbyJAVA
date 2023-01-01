// Baekjoon_12891_DNA
package DataStructure;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DNA {
	static int[] minsArr = new int[4];    // A, C, G, T 최소 개수 담을 배열
	static int[] checkArr = new int[4];    // A, C, G, T의 개수 카운트하는 배열
	static int check;    // 최소 개수를 만족하는 것을 세는 변수, check == 4이면 비밀번호 적합

	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringTokenizer st;

			st = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(st.nextToken());
			int P = Integer.parseInt(st.nextToken());
			char[] DNA = br.readLine().toCharArray();
			int result = 0;

			// minsArr 초기화
			st = new StringTokenizer(br.readLine());
			for (int i = 0; i < 4; i++) {
				minsArr[i] = Integer.parseInt(st.nextToken());
				if (minsArr[i] == 0)
					check++;    // 포함되어야할 최소개수가 0이라는것은 이미 하나는 만족한단 뜻이므로 check++한다.
			}

			// 첫번째 부분 문자열(윈도우)을 검사한다.
			for (int i = 0; i < P; i++) {
				add(DNA[i]);
			}
			if (check == 4)
				result++;

			// 다음 윈도우를 검사하는데 어차피 중간에 겹치는 부분이 있으므로 새로 윈도우를 할당하는 것보다
			// 앞문자 하나 빼주고, 뒷문자 하나 더해주는식으로 한다.
			for (int back = P; back < S; back++) {
				int front = back - P;
				add(DNA[back]);
				remove(DNA[front]);
				if (check == 4)
					result++;
			}

			System.out.println(result);
			br.close();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

	private static void add(char c) {
		switch (c) {
			case 'A':
				checkArr[0]++;
				if (checkArr[0] == minsArr[0])
					check++;
				break;
			case 'C':
				checkArr[1]++;
				if (checkArr[1] == minsArr[1])
					check++;
				break;
			case 'G':
				checkArr[2]++;
				if (checkArr[2] == minsArr[2])
					check++;
				break;
			case 'T':
				checkArr[3]++;
				if (checkArr[3] == minsArr[3])
					check++;
				break;
			default:
				break;
		}
	}

	private static void remove(char c) {
		switch (c) {
			case 'A':
				// remove할땐 선check--해주고 후checkArr--해줘야한다.
				if (checkArr[0] == minsArr[0])
					check--;
				checkArr[0]--;
				break;
			case 'C':
				if (checkArr[1] == minsArr[1])
					check--;
				checkArr[1]--;
				break;
			case 'G':
				if (checkArr[2] == minsArr[2])
					check--;
				checkArr[2]--;
				break;
			case 'T':
				if (checkArr[3] == minsArr[3])
					check--;
				checkArr[3]--;
				break;
			default:
				break;
		}
	}
}
