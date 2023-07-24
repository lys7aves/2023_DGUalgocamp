import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main{
	static int N, x, sum=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		
		Stack<Integer> stack = new Stack<Integer>();
		
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			x = Integer.parseInt(st.nextToken());
			
			if(x == 0) stack.pop();
			else stack.push(x);
		}
		
		while(!stack.empty()){
			sum += stack.pop();
		}
		
		System.out.println(sum);
	}
}