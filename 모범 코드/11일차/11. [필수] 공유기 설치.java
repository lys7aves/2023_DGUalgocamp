import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		
		ArrayList<Integer> x = new ArrayList<>();
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) x.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(x);
		
		int l=1, m, r=1000000000;
		while(l < r){
			m = (l+r+1) / 2;
			
			int cnt=1, j=0;
			for(int i=0; i<N; i++){
				if(x.get(i) - x.get(j) >= m){
					cnt++;
					j = i;
				}
			}
			
			if(cnt < C) r = m-1;
			else l = m;
		}
		
		System.out.print(l);
	}
}