import java.io.*;
import java.util.*;

public class main{
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        
        int[][] arr = new int[N][M];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) arr[i][j] = Integer.parseInt(st.nextToken());
        }
        
        // dist[i][j][0]: 도끼를 줍지 않은 경우
        // dist[i][j][1]: 도끼를 주운 경우
        int [][][] dist = new int[N][M][2];
        Queue<Integer> que = new LinkedList<>();
        
        que.offer(0); que.offer(0); que.offer(0); que.offer(1);
        while(!que.isEmpty()){
            int x = que.poll();
            int y = que.poll();
            int z = que.poll();
            int d = que.poll();
            
            if(x < 0 || x >= N || y < 0 || y >= M) continue;
            if(arr[x][y] == 2) z = 1;
            if(arr[x][y] == 1 && z == 0) continue;
            if(dist[x][y][z] > 0) continue;
            dist[x][y][z] = d;
            
            for(int i=0; i<4; i++){
                que.offer(x+dx[i]);
                que.offer(y+dy[i]);
                que.offer(z);
                que.offer(d+1);
            }
        }
        
        int ans = N*M*3+1;
        if(dist[N-1][M-1][0] > 0) ans = Math.min(ans, dist[N-1][M-1][0] - 1);
        if(dist[N-1][M-1][1] > 0) ans = Math.min(ans, dist[N-1][M-1][1] - 1);
        
        if(ans == N*M*3+1 || ans > T) System.out.print("Fail");
        else System.out.print(ans);
    }
}