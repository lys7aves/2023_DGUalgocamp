import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] fibo = new long[505]; // 70��° �Ǻ���ġ ���� int ������ 2^31 - 1 �� �Ѵ´�. �׷��� Long�� ������ 2^63 - 1 �� ���� �ʱ� ������ Long���� �����Ͽ� ������ �ذ��� �� �ִ�.
		fibo[1] = 1L; fibo[2] = 1L;
		for(int i=3; i<=N; i++) fibo[i] = fibo[i-1] + fibo[i-2];
        System.out.println(fibo[N]);
    }

}
