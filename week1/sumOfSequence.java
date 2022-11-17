//backjoon 1024
import java.util.*;

public class sumOfSequence {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        long n = scan.nextInt();
        long l = scan.nextInt();
        long start_num = 0;
        boolean flag = true;

        while(l <= 100) {
            start_num = n/l - (l-1)/2;

            if(start_num < 0) {
                break;
            }
            
            if(n == (start_num * 2 + l - 1) * l / 2) {
                for(long k=0; k<l; k++)  {
                    System.out.print(start_num+k + " ");
                }
                flag = false;
                break;
            }
            l++;
        }
        
        if(flag)    System.out.print("-1");
    }
}