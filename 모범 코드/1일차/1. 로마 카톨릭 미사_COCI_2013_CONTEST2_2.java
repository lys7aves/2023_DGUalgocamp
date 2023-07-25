import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		
		char[][] seat = new char[R+2][S+2];
		for(int i=1; i<=R; i++){
			String str = br.readLine();
			for(int j=1; j<=S; j++){
				seat[i][j] = str.charAt(j-1);
			}
		}
		
		int total=0, sanggeun=0;
		for(int i=1; i<=R; i++){
			for(int j=1; j<=S; j++){
				int cnt=0;
				// 주위에 사람이 몇명 있는지 확인
				for(int ii=i-1; ii<=i+1; ii++){
					for(int jj=j-1; jj<=j+1; jj++){
						cnt += seat[ii][jj] == 'o' ? 1 : 0;
					}
				}
				
				// (i,j)에 사람이 있으며 총 악수 횟수 증가, 없으면 상근이가 앉을 수 있음.
				if(seat[i][j] == 'o') total += cnt-1;	// cnt에 (i,j)도 더해짐.
				else sanggeun = Math.max(sanggeun, cnt);
			}
		}
		
		System.out.print(total/2 + sanggeun);
	}
}