import java.io.*;
import java.util.*;
public class main{
	static int N;
    static char board[][];
    static String answer = "Yes";
    public static void main(String[] args) throws IOException{ // BufferedReader를 사용하기 위해서는 해당 메소드에 throws IOException 구문이 필수입니다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
        board = new char[N][N];
        for(int i=0; i<N; i++)
        {
            String str = br.readLine();
            for(int j=0; j<N; j++)
            {
                board[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<N; i++)
		{
            check(i,0,0,1); // i행 검사
			check(0,i,1,0); // i열 검사
			check(i,0,1,1); // (i,0) 부터 오른쪽 아래 검사
			check(0,i,1,1); // (0,i) 부터 오른쪽 아래 검사
            check(i,0,-1,1); // (i,0) 부터 오른쪽 위 검사
            check(N-1,i,-1,1); // (N-1, i) 부터 오른쪽 위 검사
        }
        System.out.println(answer);
    }
    static void check(int x, int y, int dx, int dy) {
		int Qcnt = 0;
        do{
			if(board[x][y] == 'Q') Qcnt++;
			x+=dx; y+=dy;
		}while(x>=0 && x<N && y>=0 && y<N);
		if(Qcnt >= 2) answer = "No";
    }
}
