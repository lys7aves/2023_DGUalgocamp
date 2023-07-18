import java.util.*;
import java.io.*;

public class main {

    static int N, ans;
    static int[] arr;
    static boolean[] used;
	static StringBuilder sb;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
		sb = new StringBuilder();

        arr = new int[N + 1];
        used = new boolean[N + 1];

        dfs(1);
        System.out.println(sb.toString());
    }

    public static void dfs(int x) {
		if(x == N + 1) {
            for(int i=1; i<=N; i++) sb.append(arr[i]).append(' ');
			sb.append('\n');
            return;
        }
        for (int i = 1; i <= N; i++) { // arr[x]에 i를 놓을 수 있는지 판단
			if(used[i] == true) continue;
            arr[x] = i; used[i] = true;
            dfs(x+1);
            arr[x] = 0; used[i] = false; // backtrack
        }
    }
}
