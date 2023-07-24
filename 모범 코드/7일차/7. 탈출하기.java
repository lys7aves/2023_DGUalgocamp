import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main{
	static int N, M, sx, sy, x, y, d;
	static char arr[][];
	static int dist[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new LinkedList<>();
		
		arr = new char[N+2][M+2];
		dist = new int[N+2][M+2];
		for(int i=1; i<=N; i++){
			String str = br.readLine();
			for(int j=1; j<=M; j++){
				arr[i][j] = str.charAt(j-1);
				if(arr[i][j] == 'S'){
					sx = i;
					sy = j;
					arr[i][j] = '.';
				}
				if(arr[i][j] == '*'){
					que.offer(i);
					que.offer(j);
					que.offer(-1);
					arr[i][j] = '.';
				}
			}
		}
		
		que.offer(sx);
		que.offer(sy);
		que.offer(1);
		while(!que.isEmpty()){
			x = que.poll();
			y = que.poll();
			d = que.poll();
			
			if(d > 0 && arr[x][y] == 'D'){
				dist[x][y] = d;
				break;
			}
			if(arr[x][y] != '.' || dist[x][y] != 0) continue;
			dist[x][y] = d;
			
			for(int i=0; i<4; i++){
				que.offer(x+dx[i]);
				que.offer(y+dy[i]);
				que.offer(d + (d > 0 ? 1 : -1));
			}
		}
		
		if(arr[x][y] == 'D' && dist[x][y] > 0) System.out.println(dist[x][y]-1);
		else System.out.println("KAKTUS");
	}
}