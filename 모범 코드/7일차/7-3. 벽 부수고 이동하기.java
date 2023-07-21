import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {
	static int arr[][];
	static int dist[][][];
	static int N, M, ans;
	static int dx[] = { -1, 0, 1, 0 };
	static int dy[] = { 0, 1, 0, -1 };

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		arr = new int[N + 2][M + 2];
		dist = new int[N + 2][M + 2][2];

		for(int i=1; i<=N; i++) {
			String str = br.readLine();
			for(int j=1; j<=M; j++) {
				arr[i][j] = (int) (str.charAt(j - 1) - '0');
			}
		}

		Queue<Integer> que = new LinkedList<>();

		que.offer(1); que.offer(1); que.offer(0); que.offer(1);
		while(!que.isEmpty()) {
			int x = que.poll();
			int y = que.poll();
			int z = que.poll();
			int d = que.poll();
			
			if(x < 1 || x > N || y < 1 || y > M) continue;
			if(arr[x][y] == 1) z += 1;
			if(z == 2 || dist[x][y][z] > 0) continue;
			
			dist[x][y][z] = d;
			
			for(int i=0; i<4; i++) {
				que.offer(x+dx[i]);
				que.offer(y+dy[i]);
				que.offer(z);
				que.offer(d+1);
			}
		}
		
		ans = N * M + 1;
		if(dist[N][M][0] > 0) ans = Math.min(ans, dist[N][M][0]);
		if(dist[N][M][1] > 0) ans = Math.min(ans, dist[N][M][1]);
		
		if(ans == N*M+1) System.out.println(-1);
		else System.out.println(ans);
	}

}
