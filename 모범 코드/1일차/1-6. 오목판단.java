import java.io.*;
import java.util.*;
public class main{
    static char board[][];
    static char answer = '.';
    public static void main(String[] args) throws IOException{ // BufferedReader를 사용하기 위해서는 해당 메소드에 throws IOException 구문이 필수입니다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        board = new char[7][7];
        for(int i=0; i<7; i++)
        {
            String str = br.readLine();
            for(int j=0; j<7; j++)
            {
                board[i][j] = str.charAt(j);
            }
        }

        for(int i=0; i<7; i++) for(int j=0; j<7; j++) {
            check(i,j,1,0);
            check(i,j,0,1);
            check(i,j,1,1);
            check(i,j,1,-1);
        }
        System.out.println(answer);
    }
    static void check(int x, int y, int dx, int dy) { // x,y부터 dx,dy방향의 5칸이 오목이 완성되었는지 확인
        if(board[x][y] == '.') return ;
        if(x+4*dx < 0 || x+4*dx >= 7 || y+dy*4 < 0 || y+dy*4 >= 7) return ;
        for(int i=1; i<5; i++) {
            if(board[x+i*dx][y+i*dy] != board[x][y]) return ;
        }
        answer = board[x][y];
    }
}
