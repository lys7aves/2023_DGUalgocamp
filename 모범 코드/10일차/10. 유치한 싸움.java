import java.io.*;
import java.util.*;

public class main{
	static ArrayList<Integer>[] S, D;
	static int[] color;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		S = new ArrayList[N+1];
		D = new ArrayList[N+1];
		for(int i=1; i<=N; i++){
			S[i] = new ArrayList<>();
			D[i] = new ArrayList<>();
		}
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			String c = st.nextToken();
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			if(c.equals("S")){
				S[a].add(b);
				S[b].add(a);
			}
			if(c.equals("D")){
				D[a].add(b);
				D[b].add(a);
			}
		}
		
		color = new int[N+1];
		int cnt=0;
		for(int i=1; i<=N; i++){
			if(color[i] == 0){
				if(!bfs(i)){
					System.out.print(0);
					return;
				}
				cnt++;
			}
		}
		
		System.out.print(1);
		for(int i=0; i<cnt; i++) System.out.print(0);
	}
	
	static boolean bfs(int v){
		Queue<Integer> que = new LinkedList<>();
		
		que.add(v);
		que.add(1);
		color[v] = 1;
		while(!que.isEmpty()){
			v = que.remove();
			int c = que.remove();

			for(int u: S[v]){
				if(color[u] == c) continue;
				if(color[u] == 3-c) return false;
				color[u] = c;
				que.add(u);
				que.add(c);
			}
			for(int u: D[v]){
				if(color[u] == c) return false;
				if(color[u] == 3-c) continue;
				color[u] = 3-c;
				que.add(u);
				que.add(3-c);
			}
		}
		
		return true;
	}
}