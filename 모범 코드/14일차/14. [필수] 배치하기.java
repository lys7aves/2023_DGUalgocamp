import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Integer> A = new ArrayList<>();
		ArrayList<Integer> B = new ArrayList<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) B.add(-Integer.parseInt(st.nextToken()));
		
		Collections.sort(A);
		Collections.sort(B);
		
		long X=0;
		for(int i=0; i<N; i++) X -= A.get(i) * (long)B.get(i);
		
		System.out.print(X);
	}
}