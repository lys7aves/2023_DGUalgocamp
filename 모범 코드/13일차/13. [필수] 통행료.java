import java.io.*;
import java.util.*;

public class main{
	static ArrayList<Edge>[] edge;
	static PriorityQueue<pqNode> pq = new PriorityQueue<>();
	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		edge = new ArrayList[N+1];
		for(int i=1; i<=N; i++) edge[i] = new ArrayList<>();
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			edge[A].add(new Edge(B, C));
			edge[B].add(new Edge(A, C));
		}
		
		int[] minDis = new int[N+1];
		
		pq.add(new pqNode(1, 1));
		while(!pq.isEmpty()){
			pqNode tmp = pq.poll();
			int v = tmp.getV();
			int dis = tmp.getDis();
			
			if(minDis[v] > 0) continue;
			minDis[v] = dis;
			
			for(Edge e: edge[v]){
				int u = e.getTo();
				int d = e.getDis();
				
				pq.add(new pqNode(u, dis+d));
			}
		}
		
		System.out.print(minDis[N]-1);
	}
}

class Edge{
	private int to, dis;
	
	public Edge(int to, int dis){
		this.to = to;
		this.dis = dis;
	}
	
	public int getTo() { return this.to; }
	public int getDis() { return this.dis; }
}

class pqNode implements Comparable<pqNode>{
	private int v, dis;
	
	public pqNode(int v, int dis){
		this.v = v;
		this.dis = dis;
	}
	
	public int getV() { return this.v; }
	public int getDis() { return this.dis; }
	
	@Override
	public int compareTo(pqNode node){
		if(this.dis > node.getDis()) return 1;
		if(this.dis == node.getDis()) return 0;
		return -1;
	}
}