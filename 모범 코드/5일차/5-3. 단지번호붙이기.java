import java.io.*;
import java.util.*;

public class main {

    static int[][] arr;
    static boolean[][] visited;
    static int n, cnt;
    static int dx[] = {-1, 0, 1, 0};
    static int dy[] = {0, 1, 0, -1};
	static ArrayList<Integer> ans = new ArrayList<>();

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n+2][n+2];
        visited = new boolean[n+2][n+2];

        for(int i=1; i<=n; i++) {
            String str = br.readLine();
            for(int j=1; j<=n; j++) {
                arr[i][j] = str.charAt(j-1) - '0';
            }
        }

        for(int i=1; i<=n; i++) {
            for(int j=1; j<=n; j++) {
                if(arr[i][j] == 1 && visited[i][j] == false) {
					cnt = 0;
                    dfs(i, j);
					ans.add(cnt);
                }
            }
        }
		
		Collections.sort(ans);
		
		System.out.println(ans.size());
		for(int i=0; i<ans.size(); i++){
			System.out.println(ans.get(i));
		}
    }

    static void dfs(int x, int y) {
		if(arr[x][y] == 0 || visited[x][y] == true) return;
        visited[x][y] = true;
		cnt++;
		
        for(int i=0; i<4; i++) {
            int newx = x + dx[i];
            int newy = y + dy[i];
            dfs(newx, newy);
        }
    }

}
