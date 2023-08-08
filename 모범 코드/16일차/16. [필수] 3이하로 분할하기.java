import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[] dp = new int[12];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		for(int i=4; i<=11; i++){
			dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
		}
		
		int T = Integer.parseInt(br.readLine());
		for(int i=0; i<T; i++){
			int N = Integer.parseInt(br.readLine());
			System.out.println(dp[N]);
		}
	}
}