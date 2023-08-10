import java.io.*;
import java.util.*;

public class main{
	static ArrayList<Edge>[] edge;
	static int N;
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int T = Integer.parseInt(st.nextToken());
		
		edge = new ArrayList[N+1];
		for(int i=1; i<=N; i++) edge[i] = new ArrayList<>();
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			edge[a].add(new Edge(b, c));
			edge[b].add(new Edge(a, c));
		}
		
		int l = 0;
		int r = (int)1e9;
		while(l < r){
			int m = (l+r)/2;
			
			int res = check(m);
			if(res == -1 || res > T) l = m+1;
			else r = m;
		}
		
		System.out.print(l);
	}
	
	static int check(int limit){
		int[] dist = new int[N+1];
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(1, 1));
		while(!pq.isEmpty()){
			Edge tmp = pq.remove();
			int v = tmp.getTo();
			int d = tmp.getDis();
			
			if(dist[v] > 0) continue;
			dist[v] = d;
			
			for(Edge e: edge[v]){
				int to = e.getTo();
				int dis = e.getDis();
				
				if(dis > limit) continue;
				pq.offer(new Edge(to, d + dis));
			}
		}
		return dist[N]-1;
	}
}

class Edge implements Comparable<Edge>{
	private int to, dis;
	
	public Edge(int to, int dis){
		this.to = to;
		this.dis = dis;
	}
	
	public int getTo(){ return this.to; }
	public int getDis(){ return this.dis; }
	
	@Override
	public int compareTo(Edge e){
		return getDis() - e.getDis();
	}
}