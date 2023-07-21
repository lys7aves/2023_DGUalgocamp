import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {
    static int arr[][];
    static int dist[][];
    static int R, C, sx, sy;
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
		
        int T = Integer.parseInt(br.readLine());
        while(T-- > 0) {
            st = new StringTokenizer(br.readLine());
            C = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
			
            arr = new int[R + 2][C + 2];
            dist = new int[R + 2][C + 2];
			
            Queue<Integer> que = new LinkedList<>();

            for(int i = 1; i <= R; i++) {
                String str = br.readLine();
                for(int j = 1; j <= C; j++) {
                    char tmp = str.charAt(j - 1);
					if (tmp == '@'){
						sx = i;
						sy = j;
					}
					if(tmp == '*'){
						que.offer(i);
						que.offer(j);
						que.offer(1);
					}
                    if(tmp == '.' || tmp == '@' || tmp == '*') arr[i][j] = 1;
                }
            }

			que.offer(sx);
			que.offer(sy);
			que.offer(-1);
            while(!que.isEmpty()) {
				int x = que.poll();
				int y = que.poll();
				int d = que.poll();
				
				if(arr[x][y] == 0 || dist[x][y] != 0) continue;
				dist[x][y] = d;
				
                for (int i = 0; i < 4; i++) {
					int d_ = d > 0 ? d+1 : d-1;
					que.offer(x + dx[i]);
					que.offer(y + dy[i]);
					que.offer(d_);
                }
            }
			
			int ans = - R * C - 1;
			for(int i=1; i<=R; i++){
				if(dist[i][1] < 0) ans = Math.max(ans, dist[i][1]);
				if(dist[i][C] < 0) ans = Math.max(ans, dist[i][C]);
			}
			for(int j=1; j<=C; j++){
				if(dist[1][j] < 0) ans = Math.max(ans, dist[1][j]);
				if(dist[R][j] < 0) ans = Math.max(ans, dist[R][j]);
			}
            if (ans == -R*C-1)
                sb.append("IMPOSSIBLE\n");
            else
                sb.append((-ans) + "\n");
        }
        System.out.println(sb.toString());
    }

}
