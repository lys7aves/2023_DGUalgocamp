import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class main {
    static int arr[][];
    static int dist[][];
    static int N, M, cnt;
    static int dx[] = { -1, 0, 1, 0 };
    static int dy[] = { 0, 1, 0, -1 };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[N + 2][M + 2];	// 패딩
        dist = new int[N + 2][M + 2];

        for (int i = 1; i <= N; i++) {
            String str = br.readLine();
            for (int j = 1; j <= M; j++) {
                arr[i][j] = (int) (str.charAt(j - 1) - '0');
            }
        }

        Queue<Integer> queue = new LinkedList<>();
		
        queue.offer(1);
		queue.offer(1);
		queue.offer(1);
        while(!queue.isEmpty()) {
            int x = queue.poll();
			int y = queue.poll();
			int d = queue.poll();
			
			if(arr[x][y] == 0 || dist[x][y] > 0) continue;
			dist[x][y] = d;
			
            for(int i=0; i<4; i++) {
				queue.offer(x + dx[i]);
				queue.offer(y + dy[i]);
				queue.offer(d + 1);
            }
        }
		
        if(dist[N][M] == 0) System.out.println(-1);
        else System.out.println(dist[N][M]);
    }

}
