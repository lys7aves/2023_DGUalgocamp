import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		TreeMap<String, Integer> students = new TreeMap<>();
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			String name = st.nextToken();
			String like = st.nextToken();
			int like_num=0;
			
			if(like.equals("rock")) like_num = 0;
			if(like.equals("scissors")) like_num = 1;
			if(like.equals("paper")) like_num = 2;
			
			students.put(name, like_num);
		}
		
		for(int i=0; i<M; i++){
			st = new StringTokenizer(br.readLine());
			
			String student1 = st.nextToken();
			String student2 = st.nextToken();
			
			int num1 = students.get(student1);
			int num2 = students.get(student2);
			
			if((num1 + 1) % 3 == num2) students.replace(student2, (num2+1)%3);
			else if(num1 == (num2 + 1) % 3) students.replace(student1, (num1+1)%3);
		}
		
		for(String name: students.keySet()){
			int like_num = students.get(name);
			String like = "";
			if(like_num == 0) like = "rock";
			if(like_num == 1) like = "scissors";
			if(like_num == 2) like = "paper";
			System.out.println(name + " " + like);
		}
	}
}