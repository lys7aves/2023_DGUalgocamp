import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main{
    static int X, Y, K, M, x, y, d, ans;
    static boolean chk[][];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        X = Integer.parseInt(st.nextToken());
        Y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        
        chk = new boolean[X+1][Y+1];
        Queue<Integer> que = new LinkedList<>();
        
        ans = M;
        que.offer(0);
        que.offer(0);
        que.offer(0);
        while(!que.isEmpty()){
            x = que.poll();
            y = que.poll();
            d = que.poll();
            if(d > K) break;
            
            if(chk[x][y]) continue;
            chk[x][y] = true;
            ans = Math.min(ans, Math.abs(x+y-M));
            
            que.offer(X); que.offer(y); que.offer(d+1);
            que.offer(0); que.offer(y); que.offer(d+1);
            que.offer(x); que.offer(Y); que.offer(d+1);
            que.offer(x); que.offer(0); que.offer(d+1);
            if(x+y < X){ que.offer(x+y); que.offer(0); que.offer(d+1);}
            else{ que.offer(X); que.offer(x+y-X); que.offer(d+1);}
            if(x+y < Y){ que.offer(0); que.offer(x+y); que.offer(d+1);}
            else{ que.offer(x+y-Y); que.offer(Y); que.offer(d+1);}
        }
        
        System.out.println(ans);
    }
}