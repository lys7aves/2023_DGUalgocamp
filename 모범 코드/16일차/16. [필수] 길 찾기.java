import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int MAX = (int)1e9 + 7;
		
		int N = Integer.parseInt(br.readLine());
		char[][] arr = new char[N+1][N+1];
		for(int i=1; i<=N; i++){
			String str = br.readLine();
			for(int j=1; j<=N; j++){
				arr[i][j] = str.charAt(j-1);
			}
		}
		
		int[][] dp = new int[N+1][N+1];
		dp[0][1] = 1;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				if(arr[i][j] == '*') continue;
				dp[i][j] = (dp[i-1][j] + dp[i][j-1]) % MAX;
			}
		}
		
		System.out.print(dp[N][N]);
	}
}