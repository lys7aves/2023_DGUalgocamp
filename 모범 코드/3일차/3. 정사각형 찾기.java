import java.io.*;
import java.util.*;

public class main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++){
			String str = br.readLine();
			for(int j=0; j<M; j++) arr[i][j] = str.charAt(j) - '0';
		}
		
		int ans=1;
		for(int i=0; i<N; i++){
			for(int j=0; j<M; j++){
				for(int l=1; l<N; l++){
					if(i+l >= N || j+l >= M) break;
					if(arr[i][j] == arr[i+l][j] && arr[i][j] == arr[i][j+l] && arr[i][j] == arr[i+l][j+l]){
						ans = Math.max(ans, (l+1)*(l+1));
					}
				}
			}
		}
		
		System.out.println(ans);
	}
}