// Programmers_크기가작은부분문자열
package SimpleAlgorithm;

public class 크기가_작은부분_문자열 {
	public static void main(String[] args) {
		System.out.println(solution("3141592", "271"));
		System.out.println(solution("500220839878", "7"));
	}

	private static int solution(String t, String p) {
		int answer = 0;

		int tlen = t.length();
		int plen = p.length();

		for (int i = 0; i <= tlen - plen; i++) {
			// 첫번째 숫자 비교
			if (t.charAt(i) - '0' > p.charAt(0) - '0') {
				continue;
			} else if (t.charAt(i) - '0' == p.charAt(0) - '0') {
				if (plen == 1) {    // p가 한글자면 크기가 같단 뜻이므로 answer++하고 break
					answer++;
					continue;
				}

				// p가 한글자 이상이면
				// 두번째 숫자부터 비교
				int k = 1;    // p의 두번째 숫자부터 비교할 인덱스

				while (k < plen) {
					if (t.charAt(i + k) - '0' > p.charAt(k) - '0') {
						break;
					} else if (t.charAt(i + k) - '0' == p.charAt(k) - '0') {
						k++;
						continue;
					} else {
						answer++;
						break;
					}
				}

				if (k == plen)
					answer++;
			} else {
				answer++;
				continue;
			}
		}

		return answer;
	}
}
