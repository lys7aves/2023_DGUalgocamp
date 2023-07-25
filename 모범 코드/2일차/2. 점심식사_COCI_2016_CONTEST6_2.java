import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		int[] arr = new int[N];
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int ans=0;
		for(int i=0; i<N; i++){
			int sum=0, cnt=0;
			for(int j=i; j<N; j++){
				if(sum+arr[j] > C) continue;
				sum += arr[j];
				cnt += 1;
			}
			
			ans = Math.max(ans, cnt);
		}
		
		System.out.println(ans);
	}
}