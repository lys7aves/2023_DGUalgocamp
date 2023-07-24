import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {
    static int N, M;
    static char arr[][];
    static int dist[][];
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
		
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new char[N+2][M+2];

        for(int i=1; i<=N; i++) {
            String str = br.readLine();
			for(int j=1; j<=M; j++){
				arr[i][j] = str.charAt(j-1);
			}
        }

		int maxi=0;
		for(int i=1; i<=N; i++){
			for(int j=1; j<=M; j++){
				if(arr[i][j] == 'L'){
					maxi = Math.max(maxi, bfs(i, j));
				}
			}
		}
		
		System.out.println(maxi);
    }
	
	static int bfs(int x, int y){
		int maxi = 0, d;
		
		dist = new int[N+1][M+1];
		
        Queue<Integer> que = new LinkedList<>();
		
		que.offer(x); que.offer(y); que.offer(1);
		while(!que.isEmpty()){
			x = que.poll();
			y = que.poll();
			d = que.poll();
			
			if(arr[x][y] != 'L' || dist[x][y] > 0) continue;
			dist[x][y] = d;
			maxi = d;
			
			for(int i=0; i<4; i++){
				que.offer(x+dx[i]);
				que.offer(y+dy[i]);
				que.offer(d+1);
			}
		}
		
		return maxi-1;
	}

}