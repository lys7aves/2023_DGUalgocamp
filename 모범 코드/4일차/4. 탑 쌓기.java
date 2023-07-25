import java.io.*;
import java.util.*;

public class main{
	static int N, B, ans;
	static int[] height;
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		
		height = new int[N];
		for(int i=0; i<N; i++) height[i] = Integer.parseInt(br.readLine());
		
		// 답은 모든 블럭의 높이 합보단 작음.
		// 블럭 하나의 높이가 최대 1e6이기 때문에 ans 초기값을 1e6 * N으로 설정함.
		ans = N * 1000000;
		dfs(0, 0);
		
		System.out.println(ans);
	}
	
	static void dfs(int k, int h){
		if(h >= B) ans = Math.min(ans, h-B);
		if(k == N) return;
		
		dfs(k+1, h);
		dfs(k+1, h+height[k]);
	}
}