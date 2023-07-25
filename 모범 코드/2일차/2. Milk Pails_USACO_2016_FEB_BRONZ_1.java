import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int X = Integer.parseInt(st.nextToken());
		int Y = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int ans=0;
		for(int i=0; i<=M; i++){
			for(int j=0; j<=M; j++){
				int tmp = X*i + Y*j;
				if(tmp <= M && tmp > ans) ans = tmp;
			}
		}
		
		System.out.println(ans);
	}
}