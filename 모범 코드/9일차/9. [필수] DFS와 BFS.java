import java.io.*;
import java.util.*;

public class main{
	static boolean[] chk;
	static ArrayList<ArrayList<Integer>> edge;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());
		
		edge = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<=N; i++) edge.add(new ArrayList<Integer>());
		while(M-- > 0){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			
			edge.get(u).add(v);
			edge.get(v).add(u);
		}
		
		for(int i=1; i<=N; i++){
			Collections.sort(edge.get(i));
		}
		
		// dfs
		chk = new boolean[N+1];
		dfs(V);
		System.out.println();
		
		// bfs
		for(int i=1; i<=N; i++) chk[i] = false;
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(V);
		while(!que.isEmpty()){
			int v = que.poll();
			
			if(chk[v]) continue;
			chk[v] = true;
			System.out.print(v + " ");
			
			for(int u: edge.get(v)) que.offer(u);
		}
	}
	
	static void dfs(int v){
		if(chk[v]) return;
		chk[v] = true;
		System.out.print(v + " ");
		
		for(int u: edge.get(v)){
			dfs(u);
		}
	}
}