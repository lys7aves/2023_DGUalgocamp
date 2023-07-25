import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] x = new int[N];
		int[] y = new int[N];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			x[i] = Integer.parseInt(st.nextToken());
			y[i] = Integer.parseInt(st.nextToken());
		}
		
		int maxArea=0;
		for(int i=0; i<N; i++){
			// i번째 점이 기준 점
			for(int j=0; j<N; j++){
				// i번째 점과 같은 x좌표를 가진 점 찾기 > j번째 점
				if(x[i] != x[j]) continue;
				for(int k=0; k<N; k++){
					// i번째 점과 같은 y좌표를 가진 점 찾기 > k번째 점
					if(y[i] != y[k]) continue;
					maxArea = Math.max(maxArea, Math.abs(y[i]-y[j]) * Math.abs(x[i]-x[k]));
				}
			}
		}
		
		System.out.print(maxArea);
	}
}