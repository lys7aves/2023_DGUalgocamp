import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		long[][] dp = new long[N+1][W+1];
		
		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			for(int j=1; j<=W; j++){
				dp[i][j] = dp[i-1][j];
				if(j-x >= 0) dp[i][j] = Math.max(dp[i][j], dp[i-1][j-x]+v);
			}
		}
		
		System.out.print(dp[N][W]);
	}
}