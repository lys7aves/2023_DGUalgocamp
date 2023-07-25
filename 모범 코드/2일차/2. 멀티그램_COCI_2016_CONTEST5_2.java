import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int l;
		for(l=1; l<str.length(); l++){
			// 길이가 l인 애너그램으로 이루어져 있는지 확인
			if(str.length()%l != 0) continue;
			
			int n = str.length()/l;
			int[][] cnt = new int[n][26];
			for(int i=0; i<n; i++){
				for(int j=0; j<l; j++){
					cnt[i][str.charAt(i*l+j) - 'a'] += 1;
				}
			}
			
			// 맨 앞에 있는 문자열과 뒤에 나오는 문자열 간에 나온 알파벳 개수가 같은지 확인
			// & 연산자를 이용해주면 하나라도 틀렸는지의 여부를 알 수 있으며, 연산 속도도 빠름.
			boolean flag=true;
			for(int j=0; j<26; j++){
				for(int i=1; i<n; i++){
					flag &= cnt[0][j] == cnt[i][j];
				}
			}
			
			if(flag) break;
		}
		
		if(l == str.length()) System.out.println(-1);
		else System.out.println(str.substring(0, l));
	}
}