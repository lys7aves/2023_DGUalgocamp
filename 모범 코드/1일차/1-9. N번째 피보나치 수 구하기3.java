import java.io.*;
import java.util.*;

public class main {
    static final int mod = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] fiba = new long[10005];
		fiba[1] = 1L; fiba[2] = 2L; fiba[3] = 4L;
		for(int i=4; i<=N; i++)
		{
			fiba[i] = (fiba[i-1] + 2*fiba[i-2] - fiba[i-3]) % mod;
			// 뺄셈이 포함된 계산 결과를 나눈 나머지는 음수가 될 수 있음에 유의하자
			if(fiba[i] < 0) fiba[i] += mod;
		}
        System.out.println(fiba[N]);
    }

}
