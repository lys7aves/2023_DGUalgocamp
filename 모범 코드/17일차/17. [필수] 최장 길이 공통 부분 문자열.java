import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String S = br.readLine();
		String T = br.readLine();
		
		int[][] LCS = new int[S.length()+1][T.length()+1];
		for(int i=1; i<=S.length(); i++){
			for(int j=1; j<=T.length(); j++){
				if(S.charAt(i-1) == T.charAt(j-1)) LCS[i][j] = LCS[i-1][j-1] + 1;
				else LCS[i][j] = Math.max(LCS[i-1][j], LCS[i][j-1]);
			}
		}
		
		System.out.print(LCS[S.length()][T.length()]);
	}
}