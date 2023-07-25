import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[][] arr = new int[102][102];
		for(int k=0; k<N; k++){
			st = new StringTokenizer(br.readLine());
			// 패딩을 위해 인덱스 1씩 증가
			int x = Integer.parseInt(st.nextToken()) + 1;
			int y = Integer.parseInt(st.nextToken()) + 1;
			for(int i=x; i<x+10; i++){
				for(int j=y; j<y+10; j++){
					arr[i][j] = 1;
				}
			}
		}
		
		int[] dx = {-1, 1, 0, 0};
		int[] dy = {0, 0, -1, 1};
		int cnt=0;
		for(int i=1; i<=100; i++){
			for(int j=1; j<=100; j++){
				if(arr[i][j] == 1){
					for(int k=0; k<4; k++){
						if(arr[i+dx[k]][j+dy[k]] == 0) cnt += 1;
					}
				}
			}
		}
		
		System.out.println(cnt);
	}
}