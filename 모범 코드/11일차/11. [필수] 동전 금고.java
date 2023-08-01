import java.io.*;
import java.util.*;

public class main{
    static int M, N;
    static int[][] arr;
    static boolean[][] chk;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        
        arr = new int[M][N];
        for(int i=0; i<M; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        chk = new boolean[M][N];
        
        int l=0, m, r=1000000000;
        while(l < r){
            m = (l+r)/2;
            
            bfs(m);
            if(chk[M-1][N-1]) r = m;
            else l = m+1;
        }
        
        System.out.print(l);
    }
    
    static void bfs(int d){
		for(int i=0; i<M; i++){
			for(int j=0; j<N; j++){
				chk[i][j] = false;
			}
		}
		chk[0][0] = true;
		
		Queue<Integer> que = new LinkedList<>();
		que.add(0);
		que.add(0);
		while(!que.isEmpty()){
			int x = que.remove();
			int y = que.remove();
			
			for(int i=0; i<4; i++){
				int x_ = x+dx[i];
				int y_ = y+dy[i];

				if(x_ < 0 || x_ >= M || y_ < 0 || y_ >= N) continue;
				if(arr[x_][y_] - arr[x][y] > d) continue;
				if(chk[x_][y_]) continue;

				chk[x_][y_] = true;
				que.add(x_);
				que.add(y_);
			}
		}
    }
}