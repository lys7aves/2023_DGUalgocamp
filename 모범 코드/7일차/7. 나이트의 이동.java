import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {
    static int dist[][];
    static int T, l, sx, sy, ex, ey, x, y, d;
    static int dx[] = {-2, -2, -1, -1, 1, 1, 2, 2};
    static int dy[] = {-1, 1, -2, 2, -2, 2, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        
        T = Integer.parseInt(st.nextToken());
        while(T-- > 0){
            st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            sx = Integer.parseInt(st.nextToken());
            sy = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            ex = Integer.parseInt(st.nextToken());
            ey = Integer.parseInt(st.nextToken());
            
            dist = new int[l][l];
            Queue<Integer> que = new LinkedList<>();
            
            que.offer(sx);
            que.offer(sy);
            que.offer(1);
            dist[sx][sy] = 1;
            while(!que.isEmpty()){
                x = que.poll();
                y = que.poll();
                d = que.poll();
                
                for(int i=0; i<8; i++){
                    int x_ = x+dx[i], y_ = y+dy[i];
                    if(x_ < 0 || x_ >= l || y_ < 0 || y_ >= l || dist[x_][y_] > 0) continue;
                    dist[x_][y_] = d+1;
                    
                    que.offer(x_);
                    que.offer(y_);
                    que.offer(d+1);
                }
            }
            
            System.out.println(dist[ex][ey]-1);
        }
    }

}
