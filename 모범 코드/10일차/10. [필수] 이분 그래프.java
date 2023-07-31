import java.io.*;
import java.util.*;

public class main{
	static ArrayList<Integer>[] edge;
	static int[] color;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int V = Integer.parseInt(st.nextToken());
		int E = Integer.parseInt(st.nextToken());
		
		edge = new ArrayList[V+1];
		for(int i=1; i<=V; i++) edge[i] = new ArrayList<>();
		
		for(int i=0; i<E; i++){
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			edge[u].add(v);
			edge[v].add(u);
		}
		
		color = new int[V+1];
		boolean flag = true;
		for(int i=1; i<=V; i++){
			if(color[i] == 0){
				flag &= dfs(i, 1);
			}
		}
		
		System.out.print(flag ? "YES" : "NO");
	}
	
	static boolean dfs(int v, int c){
		if(color[v] == c) return true;
		if(color[v] == 3-c) return false;
		color[v] = c;
		
		boolean flag=true;
		for(int u: edge[v]) flag &= dfs(u, 3-c);
		
		return flag;
	}
}