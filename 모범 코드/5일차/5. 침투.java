import java.io.*;
import java.util.*;

public class main{
	static int N, M;
	static int[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String args[]) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N+2][M+2];
		for(int i=1; i<=N; i++){
			String str = br.readLine();
			for(int j=1; j<=M; j++){
				arr[i][j] = str.charAt(j-1) - '0';
			}
		}
		
		// 패딩
		for(int i=1; i<=N; i++) arr[i][0] = arr[i][M+1] = 1;
		for(int j=1; j<=M; j++) arr[0][j] = arr[N+1][j] = 1;
		
		// 벽을 시작으로 dfs를 돌려도 바로 벽을 만나 return 되어 상관 없음.
		for(int j=1; j<=M; j++) dfs(1, j);
		
		boolean flag=false;
		for(int j=1; j<=M; j++){
			if(arr[N][j] == 2) flag = true;
		}
		
		System.out.println(flag ? "YES" : "NO");
	}
	
	static void dfs(int x, int y){
		if(arr[x][y] != 0) return;
		arr[x][y] = 2;
		
		for(int i=0; i<4; i++) dfs(x+dx[i], y+dy[i]);
	}
}