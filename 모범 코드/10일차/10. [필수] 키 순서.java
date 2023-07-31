import java.io.*;
import java.util.*;

public class main{
	static ArrayList<Integer>[] tall, small;
	static boolean[] chk;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		tall = new ArrayList[N+1];
		small = new ArrayList[N+1];
		for(int i=1; i<=N; i++){
			tall[i] = new ArrayList<>();
			small[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			tall[a].add(b);
			small[b].add(a);
		}
		
		chk = new boolean[N+1];
		int cnt=0;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++) chk[j] = false;
			int tall_cnt = dfs(tall, i) - 1;
			
			for(int j=1; j<=N; j++) chk[j] = false;
			int small_cnt = dfs(small, i) - 1;
			
			if(tall_cnt + small_cnt == N-1) cnt++;
		}
		
		System.out.print(cnt);
	}
	
	static int dfs(ArrayList<Integer>[] edge, int v){
		if(chk[v]) return 0;
		chk[v] = true;
		
		int cnt=1;
		for(int u: edge[v]) cnt += dfs(edge, u);
		
		return cnt;
	}
}