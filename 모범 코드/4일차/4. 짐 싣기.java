import java.io.*;
import java.util.*;

public class main{
	static int C, N, ans;
	static int[] W;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		C = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		W = new int[N];
		for(int i=0; i<N; i++) W[i] = Integer.parseInt(br.readLine());
		
		ans = 0;
		dfs(0, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int k, int w){
		if(w > C) return;
		ans = Math.max(ans, w);
		if(k == N) return;
		
		dfs(k+1, w);
		dfs(k+1, w+W[k]);
	}
}