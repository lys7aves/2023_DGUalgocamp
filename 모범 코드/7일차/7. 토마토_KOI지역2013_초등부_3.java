import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main{
	static int N, M, ans;
	static int arr[][];
	static int dx[] = {-1, 1, 0, 0};
	static int dy[] = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		Queue<Integer> que = new LinkedList<>();
		
		arr = new int[N+2][M+2];
		for(int i=1; i<=N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=1; j<=M; j++){
				arr[i][j] = Integer.parseInt(st.nextToken());
				if(arr[i][j] == 1){
					que.offer(i);
					que.offer(j);
				}
			}
		}
		for(int i=1; i<=N; i++) arr[i][0] = arr[i][M+1] = -1;
		for(int j=1; j<=M; j++) arr[0][j] = arr[N+1][j] = -1;
		
		while(!que.isEmpty()){
			int x = que.poll();
			int y = que.poll();
			ans = arr[x][y];
			
			for(int i=0; i<4; i++){
				int nx=x+dx[i], ny=y+dy[i];
				if(arr[nx][ny] != 0) continue;
				
				arr[nx][ny] = arr[x][y] + 1;
				que.offer(nx);
				que.offer(ny);
			}
		}
		
		for(int i=1; i<=N; i++){
			for(int j=1; j<=M; j++){
				if(arr[i][j] == 0) ans = 0;
			}
		}
		
		System.out.println(ans-1);
	}
}