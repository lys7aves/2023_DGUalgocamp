import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		HashSet<Integer> set = new HashSet<>();
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++){
			set.add(Integer.parseInt(st.nextToken()));
		}
		
		System.out.print(set.size());
	}
}