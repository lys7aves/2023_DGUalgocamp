import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		int k=0;
		
		int[][] medal = new int[N][4];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<4; j++) medal[i][j] = Integer.parseInt(st.nextToken());
			if(medal[i][0] == K) k = i;
		}
		
		int rank=1;
		for(int i=0; i<N; i++){
			for(int j=1; j<4; j++){
				if(medal[i][j] > medal[k][j]){
					rank += 1;
					break;
				}
				if(medal[i][j] < medal[k][j]) break;
			}
		}
		
		System.out.println(rank);
	}
}