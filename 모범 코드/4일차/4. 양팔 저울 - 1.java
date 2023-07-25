import java.io.*;
import java.util.*;

public class main{
	static int N;
	static int[] weight;
	static boolean[] chk;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		N = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		weight = new int[N];
		for(int i=0; i<N; i++) weight[i] = Integer.parseInt(st.nextToken());
		
		// 추의 무게가 최대 100이므로 최대 100N 인덱스까지 필요하다.
		chk = new boolean[100*N+1];
		dfs(0, 0);
		
		int cnt=0;
		for(int i=1; i<=100*N; i++) cnt += chk[i] ? 1 : 0;
		
		System.out.println(cnt);
	}
	
	static void dfs(int k, int w){
		chk[w] = true;
		if(k == N) return;
		
		dfs(k+1, w);
		dfs(k+1, w+weight[k]);
	}
}