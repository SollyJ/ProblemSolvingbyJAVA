// baek1003
import java.io.*;
import java.util.*;

public class fibo {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int[] N = new int[T];
        for(int i=0; i<T; i++) {
            N[i] = Integer.parseInt(br.readLine());
        }     

        // N일때 0개수와 1개수를 넣을 2차원배열
        // Integer로 선언한 이유는 배열 원소들을 0으로 자동 초기화 하기 위해서
        Integer[][] cnt = new Integer[41][2];   
        // 미리 저장해두면 재귀호출할 필요없이 그냥 바로 해당값을 꺼내면 된다.
        cnt[0][0] = 1;  // N이 0일때 0개수
        cnt[0][1] = 0;  // N이 0일때 1개수
        cnt[1][0] = 0;
        cnt[1][1] = 1;
        cnt[2][0] = 0;
        cnt[2][1] = 1;

        // bottom up 방식으로
        // 이미 계산한 적이 있는 값은 불러와서 쓴다.
        // Dynamic Programming
        // 큰 문제를 작은 문제로 쪼개서 그 답을 저장해두고 재활용 함
        for(int i=0; i<T; i++) {
            for(int k=2; k<=N[i]; k++) {
                cnt[k][0] = cnt[k-1][0] + cnt[k-2][0];
                cnt[k][1] = cnt[k-1][1] + cnt[k-2][1];
            }

            System.out.println(cnt[N[i]][0] + " " + cnt[N[i]][1]);
        }
    }
    
}