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
		for(int i=0; i<N; i++) B.add(Integer.parseInt(st.nextToken()));
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) A.add(Integer.parseInt(st.nextToken()));
		
		Collections.sort(A);
		Collections.sort(B);
		
		int j=0, cnt=0;
		for(int i=0; i<N; i++){
			while(j<N && A.get(j) <= B.get(i)) j++;
			if(j == N) break;
			cnt++;
			j++;
		}
		
		System.out.print(cnt);
	}
}