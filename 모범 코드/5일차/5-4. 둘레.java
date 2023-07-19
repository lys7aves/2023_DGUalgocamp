import java.io.*;
import java.util.*;

public class main {
    static int[][] arr = new int[102][102];
    static boolean[][] visit = new boolean[102][102];
    static int[] dx = {0,0,-1,1};
    static int[] dy = {1,-1,0,0};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());

        for (int k=1; k<=N; k++) {
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            arr[i][j] = 1;
        }

        dfs(0,0);

        for (int i=1; i<101; i++) {
            for (int j=1; j<101; j++) {
                if (arr[i][j] == 1) {
                    for (int k=0; k<4; k++) {
                        int ni = i + dx[k];
                        int nj = j + dy[k];
                        if (arr[ni][nj] == 0 && visit[ni][nj]) {
                            count ++;
                        }
                    }
                }
            }
        }
        System.out.println(count);
    }

    public static void dfs(int i, int j) {

        visit[i][j] = true;
        for (int k=0; k<4; k++) {
            int ni = i + dx[k];
            int nj = j + dy[k];

            if (ni < 0 || nj < 0 || ni > 101 || nj > 101) {
                continue;
            }
            if (arr[ni][nj] == 0 && !visit[ni][nj]) {
                dfs(ni,nj);
            }
        }
    }

}
