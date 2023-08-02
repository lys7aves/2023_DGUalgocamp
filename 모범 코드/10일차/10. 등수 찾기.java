import java.io.*;
import java.util.*;

public class main{
	static ArrayList<Integer>[] high, low;
	static boolean[] chk;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		high = new ArrayList[N+1];
		low = new ArrayList[N+1];
		for(int i=1; i<=N; i++){
			high[i] = new ArrayList<>();
			low[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			high[B].add(A);
			low[A].add(B);
		}
		
		chk = new boolean[N+1];
		System.out.print(dfs(high, X) + " ");
		chk[X] = false;
		System.out.print(N - dfs(low, X) + 1);
	}
	
	static int dfs(ArrayList<Integer>[] edge, int v){
		if(chk[v]) return 0;
		chk[v] = true;
		
		int cnt=1;
		for(int u: edge[v]) cnt += dfs(edge, u);
		
		return cnt;
	}
}