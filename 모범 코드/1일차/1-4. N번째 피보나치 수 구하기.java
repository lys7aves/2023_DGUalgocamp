import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] fibo = new long[505]; // 70번째 피보나치 수는 int 범위는 2^31 - 1 을 넘는다. 그러나 Long의 범위인 2^63 - 1 은 넘지 않기 때문에 Long으로 선언하여 문제를 해결할 수 있다.
		fibo[1] = 1L; fibo[2] = 1L;
		for(int i=3; i<=N; i++) fibo[i] = fibo[i-1] + fibo[i-2];
        System.out.println(fibo[N]);
    }

}
