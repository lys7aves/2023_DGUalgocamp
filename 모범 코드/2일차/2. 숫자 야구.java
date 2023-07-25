import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		// condition[i][0~2]: 숫자, condition[i][3]: strike 개수, condition[i][4]: ball 개수
		int[][] condition = new int[N][5];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			String number = st.nextToken();
			for(int j=0; j<3; j++) condition[i][j] = number.charAt(j) - '0';
			condition[i][3] = Integer.parseInt(st.nextToken());
			condition[i][4] = Integer.parseInt(st.nextToken());
		}
		
		int cnt=0;
		for(int a=1; a<=9; a++){
			for(int b=1; b<=9; b++){
				if(a == b) continue;
				for(int c=1; c<=9; c++){
					if(a == c || b == c) continue;
					boolean flag=true;
					for(int i=0; i<N; i++){
						int strike=0, ball=0;
						
						if(condition[i][0] == a) strike += 1;
						if(condition[i][1] == b) strike += 1;
						if(condition[i][2] == c) strike += 1;
						
						if(condition[i][0] == b || condition[i][0] == c) ball += 1;
						if(condition[i][1] == a || condition[i][1] == c) ball += 1;
						if(condition[i][2] == a || condition[i][2] == b) ball += 1;
						
						// 하나의 조건이라도 틀리면 abc는 가능한 수가 아님.
						if(strike != condition[i][3] || ball != condition[i][4]) flag = false;
					}
					
					if(flag) cnt += 1;
				}
			}
		}
		
		System.out.println(cnt);
	}
}