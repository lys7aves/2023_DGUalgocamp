import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] chk = new boolean[N+1];
		for(int i=1; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int p = Integer.parseInt(st.nextToken());
			int q = Integer.parseInt(st.nextToken());
			
			chk[p] = true;
		}
		
		int cnt=0, ans=0;
		for(int i=1; i<=N; i++){
			if(!chk[i]){
				cnt++;
				ans = i;
			}
		}
		
		if(cnt == 1) System.out.print(ans);
		else System.out.print(-1);
	}
}