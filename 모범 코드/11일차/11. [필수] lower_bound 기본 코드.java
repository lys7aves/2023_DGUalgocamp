import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());
		
		int K = Integer.parseInt(br.readLine());
		
		System.out.print(lower_bound(N, arr, K));
	}
	
	static int lower_bound(int N, int[] arr, int K){
		int answer=0;
		
		return answer;
	}
}