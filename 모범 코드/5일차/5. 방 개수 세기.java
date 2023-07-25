import java.io.*;
import java.util.*;

public class main{
	static int N, M;
	static char[][] arr;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new char[N+2][M+2];	// 패딩
		for(int i=1; i<=N; i++){
			String str = br.readLine();
			for(int j=1; j<=M; j++){
				arr[i][j] = str.charAt(j-1);
			}
		}
		
		int cnt=0;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=M; j++){
				if(arr[i][j] == '.'){
					cnt += 1;
					dfs(i, j);
				}
			}
		}
		
		System.out.println(cnt);
	}
	
	static void dfs(int x, int y){
		if(arr[x][y] != '.') return;
		arr[x][y] = '#';
		for(int i=0; i<4; i++) dfs(x+dx[i], y+dy[i]);
	}
}