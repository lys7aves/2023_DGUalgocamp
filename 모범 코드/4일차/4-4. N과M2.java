import java.util.*;
import java.io.*;

public class main {

    static int N, M;
    static int[] arr;
    static boolean[] used;
	static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		sb = new StringBuilder();

        arr = new int[N + 1];

        dfs(1, 1); // arr
        System.out.println(sb.toString());
    }

    public static void dfs(int x, int y) { // arr[x]를 y이상의 수로 채우고 다음 단계로
		if(x == M + 1) {
            for(int i=1; i<=M; i++) sb.append(arr[i]).append(' ');
			sb.append('\n');
            return;
        }
        for (int i = y; i <= N; i++) { // arr[x]에 i를 놓을 수 있는지 판단
            arr[x] = i;
            dfs(x+1, i+1);
            arr[x] = 0; // backtrack
        }
    }
}
