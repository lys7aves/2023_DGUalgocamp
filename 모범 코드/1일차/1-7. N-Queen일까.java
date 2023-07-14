import java.io.*;
import java.util.*;
public class main{
	static int N;
    static char board[][];
    static String answer = "Yes";
    public static void main(String[] args) throws IOException{ // BufferedReader�� ����ϱ� ���ؼ��� �ش� �޼ҵ忡 throws IOException ������ �ʼ��Դϴ�.

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
            check(i,0,0,1); // i�� �˻�
			check(0,i,1,0); // i�� �˻�
			check(i,0,1,1); // (i,0) ���� ������ �Ʒ� �˻�
			check(0,i,1,1); // (0,i) ���� ������ �Ʒ� �˻�
            check(i,0,-1,1); // (i,0) ���� ������ �� �˻�
            check(N-1,i,-1,1); // (N-1, i) ���� ������ �� �˻�
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
