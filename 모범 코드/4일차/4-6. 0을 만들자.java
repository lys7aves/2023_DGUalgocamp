import java.util.*;
import java.io.*;

public class main {

	static int N;
	static long ans;
	static int[] arr;
	static StringBuilder sb;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		sb= new StringBuilder();

		N = Integer.parseInt(br.readLine());
		dfs(1, 0, 1, "1");

		System.out.println(sb.toString());
}

	public static void dfs(int x, int res, int tmp, String form) {
		// x������ ���ڵ��� ����ؼ� Ȯ���� ��� ��� = res, ����� �ִ� �� = tmp, ���� form�� ��Ȳ
		// 1 + 2 3 - 4 5 => dfs(5, 24, -45, "1+23-45")
		// 6�� �̾�������ٸ� 1 + 2 3 - 4 5 6 => dfs(6, 24, -456, "1+23-456")
		// 6�� + �� �ٴ´ٸ� 1 + 2 3 - 4 5 + 6 => dfs(6, -21, 6, "1+23-45+6")
		// 6�� - �� �ٴ´ٸ� 1 + 2 3 - 4 5 - 6 => dfs(6, -21, -6, "1+23-45-6")
		if (x == N) {
			int result = res + tmp;
			if(result == 0) sb.append(form).append('\n');
			return ;
		}
		int newtmp;
		if(tmp > 0) newtmp = tmp*10 + (x+1); // 23 -> 234
		else newtmp = tmp*10 - (x+1); // -23 -> -234

		dfs(x+1, res, newtmp, form + ' ' + (char)((x+1) + '0'));
		dfs(x+1, res+tmp, x+1, form + '+' + (char)((x+1) + '0'));
		dfs(x+1, res+tmp, -(x+1), form + '-' + (char)((x+1) + '0'));


	}
}
