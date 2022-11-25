package week2;

import java.io.*;
import java.util.*;

public class remainderSum {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long result = 0;

        long[] sum_arr = new long[N+1]; // N번째 까지의 수들의 누적합
        long[] remainder = new long[M]; // 누적합 배열을 M으로 나눈 나머지가 인덱스인 배열

        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            sum_arr[i] = sum_arr[i-1] + Long.parseLong(st.nextToken());
        }

        for(int i=1; i<=N; i++) {
            int r = (int)(sum_arr[i] % M);

            if(r == 0)  result++;   
            remainder[r]++; // 나머지가 r인 인덱스 +1
        }

        for(int i=0; i<M; i++) {
            if(remainder[i] > 1) {   // 나머지가 i인 인덱스의 개수가 2개 이상이면
                result = result + (remainder[i]*(remainder[i] - 1))/2;  // 나머지가 같은 인덱스들 중 2가지를 뽑는 경우의 수
            }
        }

        System.out.print(result);
    }
}
