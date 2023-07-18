import java.util.*;
import java.io.*;

public class main {

	static int N;
	static long ans;
	static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		ans = Long.MAX_VALUE;
		arr = new int[N + 1];
		for(int i=1; i<=N; i++){
			arr[i] = Integer.parseInt(st.nextToken());
		}

		dfs(0, 0);

		System.out.println(ans);
}

	public static void dfs(int x, long diff) { // x번까지 사과를 사용해서 두 그룹의 무게 차이가 diff 인 상황
		if (x == N) {
			if(Math.abs(diff) < ans) {
				ans = Math.abs(diff);
			}
			return ;
		}
		dfs(x+1, diff + arr[x+1]);
		dfs(x+1, diff - arr[x+1]);
	}
}
