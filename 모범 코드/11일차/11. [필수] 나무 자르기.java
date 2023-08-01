import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] h = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) h[i] = Integer.parseInt(st.nextToken());
		
		int l=0, r=1000000000;
		while(l < r){
			int m = (l+r+1) / 2;
			
			long sum=0;
			for(int i=0; i<N; i++) sum += h[i] > m ? h[i] - m : 0;
			
			if(sum >= M) l = m;
			else r = m-1;
		}
		
		System.out.print(l);
	}
}