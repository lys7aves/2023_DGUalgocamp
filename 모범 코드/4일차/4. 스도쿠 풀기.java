import java.io.*;
import java.util.*;

public class main{
	static int[][] arr, ans;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		arr = new int[9][9];
		for(int i=0; i<9; i++){
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<9; j++) arr[i][j] = Integer.parseInt(st.nextToken());
		}
		
		ans = new int[9][9];
		dfs(0, 0);
		
		if(ans[0][0] == 0) System.out.println("Not Possible");
		else{
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					System.out.print(ans[i][j] + " ");
				}
				System.out.println();
			}
		}
	}
	
	static void dfs(int x, int y){
		if(x == 9){
			for(int i=0; i<9; i++){
				for(int j=0; j<9; j++){
					ans[i][j] = arr[i][j];
				}
			}
		}
		else if(y == 9) dfs(x+1, 0);
		else if(arr[x][y] > 0) dfs(x, y+1);
		else{
			for(int k=1; k<=9; k++){
				boolean flag=true;
				
				for(int i=0; i<9; i++) if(arr[i][y] == k) flag = false;
				for(int j=0; j<9; j++) if(arr[x][j] == k) flag = false;
				for(int i=0; i<3; i++){
					for(int j=0; j<3; j++){
						if(arr[x/3*3+i][y/3*3+j] == k) flag = false;
					}
				}
				
				if(flag){
					arr[x][y] = k;
					dfs(x, y+1);
					arr[x][y] = 0;
				}
			}
		}
	}
}