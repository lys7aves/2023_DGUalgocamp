import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean flag=false;
		for(int i=0; i<=N; i++){
			for(int j=0; j<=N; j++){
				for(int k=0; k<=N; k++){
					if(A*i + B*j + C*k == N) flag = true;
				}
			}
		}
		
		System.out.println(flag ? 1 : 0);
	}
}