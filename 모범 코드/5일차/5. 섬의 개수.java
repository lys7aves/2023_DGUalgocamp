import java.io.*;
import java.util.*;

public class main{
	static int w, h;
	static int[][] arr;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		while(true){
			st = new StringTokenizer(br.readLine());
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			if(w == 0 && h == 0) break;
			
			arr = new int[h+2][w+2];
			for(int i=1; i<=h; i++){
				st = new StringTokenizer(br.readLine());
				for(int j=1; j<=w; j++){
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			int cnt=0;
			for(int i=1; i<=h; i++){
				for(int j=1; j<=w; j++){
					if(arr[i][j] == 1){
						cnt += 1;
						dfs(i, j);
					}
				}
			}
			
			System.out.println(cnt);
		}
	}
	
	static void dfs(int x, int y){
		if(arr[x][y] == 0) return;
		arr[x][y] = 0;
		for(int i=-1; i<=1; i++){
			for(int j=-1; j<=1; j++){
				// i=0, j=0인 경우 자기 자신으로 dfs를 돌리는데, 어차피 가면 arr 값이 0이라 바로 return 된다.
				// 따라서 i=0, j=0인 경우를 따로 처리하지 않아도 상관 없다.
				dfs(x+i, y+j);
			}
		}
	}
}