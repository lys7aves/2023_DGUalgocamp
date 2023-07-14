import java.io.*;
import java.util.*;

public class main {
    static final int mod = 1000000007;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] fibo = new int[10005];
		fibo[1] = 1; fibo[2] = 1;
		// ū ���� ���� �������� ����϶�� ���� ��κ� �Ϲ����� ���������δ� �� ���� ǥ���� �� ���� ����
		//���� ��� ���������� ��� ���� �������� ����Ͽ� Overflow�� �߻����� �ʵ��� �ؾ� �Ѵ�.
		for(int i=3; i<=N; i++) fibo[i] = (fibo[i-1] + fibo[i-2]) % mod;
        System.out.println(fibo[N]);
    }
}
