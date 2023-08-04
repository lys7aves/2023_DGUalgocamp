import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for(int i=0; i<N; i++) pq.add(Integer.parseInt(br.readLine()));
		
		int sum=0;
		for(int i=1; i<N; i++){
			int x = pq.poll() + pq.poll();
			pq.add(x);
			
			sum += x;
		}
		
		System.out.print(sum);
	}
}