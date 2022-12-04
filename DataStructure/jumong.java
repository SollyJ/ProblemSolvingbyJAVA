// Baekjoon_1940_주몽
package DataStructure;

import java.io.*;
import java.util.*;

public class jumong {
    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        int[] arr = new int[N];
        int answer = 0;

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {    
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for(int i : arr) {
            int one = i;
            int two = M-one;
            if(Arrays.stream(arr).anyMatch(x -> x == two))    answer++;
        }        

        System.out.print(answer/2);
    }
}