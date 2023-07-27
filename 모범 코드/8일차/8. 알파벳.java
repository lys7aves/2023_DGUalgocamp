import java.io.*;
import java.util.*;

public class main{
    static int ans=0;
    static char[][] arr;
    static boolean[] chk;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        
        arr = new char[R+2][C+2];
        for(int i=1; i<=R; i++){
            String str = br.readLine();
            for(int j=1; j<=C; j++) arr[i][j] = str.charAt(j-1);
        }
        
        chk = new boolean['Z'+1];
        chk[0] = true;
        dfs(1, 1, 1);
        
        System.out.print(ans);
    }
    
    static void dfs(int x, int y, int d){
        if(chk[arr[x][y]]) return;
        
        ans = Math.max(ans, d);
        
        chk[arr[x][y]] = true;
        for(int i=0; i<4; i++) dfs(x+dx[i], y+dy[i], d+1);
        chk[arr[x][y]] = false;
    }
}