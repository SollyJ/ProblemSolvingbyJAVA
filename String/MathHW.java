// Baekjoon_2870_수학숙제
package String;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MathHW {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int N = Integer.parseInt(br.readLine());
			List<BigInteger> nums = new ArrayList<>();

			for (int i = 0; i < N; i++) {
				String str = br.readLine();
				String[] temp;

				// 숫자가 아닌 문자를 기준으로 나눠라.
				// ex. "3a9d"의 경우 {"3", "", "9", ""}
				temp = str.split("\\D");

				for (String s : temp) {
					if (!s.equals(""))
						nums.add(new BigInteger(s));
				}
			}

			Collections.sort(nums);
			nums.forEach(System.out::println);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
}
