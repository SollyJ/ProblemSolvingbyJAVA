// Programmers_직사각형별찍기
package SimpleAlgorithm;

import java.util.stream.IntStream;

public class RectangleStar {
	public static void main(String[] args) {
		StringBuilder sb = new StringBuilder();

		IntStream.range(0, 5).forEach(s -> sb.append("*"));
		IntStream.range(0, 3).forEach(s -> System.out.println(sb.toString()));
	}
}
