import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> w = new ArrayList<>();
		for(int i=0; i<N; i++) w.add(-Integer.parseInt(br.readLine()));
		
		Collections.sort(w);
		
		int ans=0;
		for(int i=0; i<N; i++) ans = Math.max(ans, -(i+1)*w.get(i));
		
		System.out.print(ans);
	}
}