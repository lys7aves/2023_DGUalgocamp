import java.io.*;
import java.util.*;

public class main{
	static int N;
	static int[][] person, cow;
	static int[] dx = {-1, 1, 0, 0};
	static int[] dy = {0, 0, -1, 1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		person = new int[N+2][N+2];
		cow = new int[N+2][N+2];
		for(int i=1; i<=N; i++){
			String str = br.readLine();
			for(int j=1; j<=N; j++){
				switch(str.charAt(j-1)){
					case 'R':
						person[i][j] = 1;
						cow[i][j] = 1;
						break;
					case 'G':
						person[i][j] = 2;
						cow[i][j] = 1;
						break;
					case 'B':
						person[i][j] = 3;
						cow[i][j] = 2;
				}
			}
		}
		
		int cnt_person=0, cnt_cow=0;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=N; j++){
				if(person[i][j] > 0){
					cnt_person += 1;
					dfs(person, i, j, person[i][j]);
				}
				if(cow[i][j] > 0){
					cnt_cow += 1;
					dfs(cow, i, j, cow[i][j]);
				}
			}
		}
		
		System.out.println(cnt_person + " " + cnt_cow);
	}
	
	// 배열도 인자로 넘기면 하나의 dfs로 두 배열을 처리할 수 있음.
	static void dfs(int[][] arr, int x, int y, int c){
		if(arr[x][y] != c) return;
		arr[x][y] = 0;
		
		for(int i=0; i<4; i++) dfs(arr, x+dx[i], y+dy[i], c);
	}
}