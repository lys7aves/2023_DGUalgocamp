import java.io.*;
import java.util.*;

public class main {
    static final int mod = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fibo = new int[10005];
		fibo[1] = 1; fibo[2] = 1;
		// 큰 수로 나눈 나머지를 출력하라는 경우는 대부분 일반적인 정수형으로는 그 수를 표현할 수 없기 때문
		//따라서 계산 과정에서도 계속 나눈 나머지를 계산하여 Overflow가 발생하지 않도록 해야 한다.
		for(int i=3; i<=N; i++) fibo[i] = (fibo[i-1] + fibo[i-2]) % mod;
        System.out.println(fibo[N]);
    }
}
