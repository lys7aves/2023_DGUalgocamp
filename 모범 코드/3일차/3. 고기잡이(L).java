import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int W = Integer.parseInt(st.nextToken());
		int H = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		int ans=0;
		for(int i=0; i<=N-W; i++){
			for(int j=0; j<=M-H; j++){
				int sum=0;
				for(int x=i; x<i+W; x++){
					for(int y=j; y<j+H; y++){
						sum += arr[x][y];
					}
				}
				ans = Math.max(ans, sum);
			}
		}
		
		System.out.println(ans);
	}
}