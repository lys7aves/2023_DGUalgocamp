import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main{
	static int N, A, B, U, D, x, d;
	static int dist[];
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		dist = new int[N+1];
		Queue<Integer> que = new LinkedList<>();
		
		que.offer(A);
		que.offer(1);
		while(!que.isEmpty()){
			x = que.poll();
			d = que.poll();
			
			if(x < 1 || x > N || dist[x] > 0) continue;
			dist[x] = d;
			
			que.offer(x+U);
			que.offer(d+1);
			que.offer(x-D);
			que.offer(d+1);
		}
		
		if(dist[B] == 0) System.out.println("use the stairs");
		else System.out.println(dist[B]-1);
	}
}