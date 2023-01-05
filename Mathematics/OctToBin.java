// Baekjoon_1212_8진수2진수
package Mathematics;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class OctToBin {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			StringBuilder result = new StringBuilder();
			String Oct = br.readLine();

			// 0~7까지 2진수
			String[] bins = {"000", "001", "010", "011", "100", "101", "110", "111"};

			for (int i = 0; i < Oct.length(); i++) {
				int idx = Oct.charAt(i) - '0';    // 숫자로 변환
				result.append(bins[idx]);    // 해당하는 2진수로 변환
			}

			if (Oct.equals("0"))
				System.out.println(Oct);
			else {
				while (result.charAt(0) == '0')    // result의 첫글자 0일때 처리
					result = new StringBuilder(result.substring(1));
				System.out.println(result);
			}
			br.close();
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
