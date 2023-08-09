import java.io.*;
import java.util.*;

public class main{
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		
		int N = Integer.parseInt(br.readLine());
		
		int[] LIS = new int[N];
		int maxi=0;
		ArrayList<Integer> K = new ArrayList<>();
		K.add(0);
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			int X = Integer.parseInt(st.nextToken());
			
			LIS[i] = lower_bound(K, X);
			
			if(LIS[i] == K.size()) K.add(X);
			K.set(LIS[i], X);
			
			maxi = Math.max(maxi, LIS[i]);
		}
		
		System.out.print(maxi);
	}
	
	static int lower_bound(ArrayList<Integer> K, int X){
		int lb = K.size();
		int l=0, r=lb;
		
		while(l<r){
			int m = (l+r)/2;
			
			if(K.get(m) >= X){
				lb = m;
				r = m;
			}
			else l = m+1;
		}
		
		return lb;
	}
}