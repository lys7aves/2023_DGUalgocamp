import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] X = new int[N];
		int[] LIS = new int[N];
		int maxi=0;
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			X[i] = Integer.parseInt(st.nextToken());
			
			for(int j=0; j<i; j++){
				if(X[j] < X[i]){
					LIS[i] = Math.max(LIS[i], LIS[j]);
				}
			}
			LIS[i]++;
			
			maxi = Math.max(maxi, LIS[i]);
		}
		
		System.out.print(maxi);
	}
}