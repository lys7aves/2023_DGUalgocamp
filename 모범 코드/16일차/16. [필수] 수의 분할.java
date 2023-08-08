import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int MAX = (int)1e9 + 7;
		
		st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[x];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<x; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int[] dp = new int[n+1];
		dp[0] = 1;
		for(int i=1; i<=n; i++){
			for(int j=0; j<x; j++){
				if(i-arr[j] >= 0) dp[i] = (dp[i] + dp[i-arr[j]]) % MAX;
			}
		}
		
		System.out.print(dp[n]);
	}
}