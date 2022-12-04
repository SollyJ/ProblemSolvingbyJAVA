package BinarySearch;
// baekjoon 1166
import java.util.*;
import java.lang.*;

public class present {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long N = scan.nextLong();
        long L = scan.nextLong();
        long W = scan.nextLong();
        long H = scan.nextLong();

        double A = 0;
        double max = (double)Math.max(L, W);
        max = (double)Math.max(max, H);

        for(int i=0; i<50000; i++) { // 최대한 근삿값을 찾기위해 충분한 반복을 한다.
            double mid = (A + max) / 2;

            // N개가 들어가거나 N개보다 더 많이 들어간다면
            // mid를 더 크게 해서 N개에 최대한 근사하도록해야
            // 가능한 정육면체 길이의 최댓값이다
            if((long)(L/mid) * (long)(W/mid) * (long)(H/mid) >= N) {
                A = mid;
            }
            else {  // N개보다 안들어간다면 mid를 줄여야함
                max = mid;
            }
        }

        System.out.println(A);
    }
}
