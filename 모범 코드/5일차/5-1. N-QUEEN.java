// ����ȭ X O(N! * N^2)
import java.util.*;
import java.io.*;

public class main {

    static int N, ans;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        ans = 0;

        dfs(1);
        System.out.println(ans);
    }

    public static void dfs(int x) { // ������ x��° ���� �� ��° ĭ�� ������ �Ǵ�, ó���� dfs(1)
        if (x == N + 1) {
            ans++;
            return;
        }
        for (int i = 1; i <= N; i++) { // x��° �ٿ� i�� ���� �� �ִ��� �Ǵ�
            boolean pos = true;
            for (int j = 1; j < x; j++) {// ���� �ٰ� ���� ������ �� �ִ��� �Ǵ�
                // (j, arr[j])�� (x, i)
                if (i == arr[j] || j - arr[j] == x - i || j + arr[j] == x + i)
                    pos = false;
            }

            if (pos) {
                arr[x] = i;
                dfs(x + 1);
                arr[x] = 0; // backtrack
            }
        }
    }
}


//����ȭ O O(N!*N)
import java.util.*;
import java.io.*;

public class main {

    static int N, ans;
    static int[] arr;
    static boolean[] ver, diag1, diag2;
    // ver[x] == true -> �̹� ĥ�� (p,q)�� �� q == x �� ĭ�� �ִ�.
    // diag1[x] == true -> �̹� ĥ�� (p,q)�� �� (p+q) == x �� ĭ�� �ִ�.
    // diag2[x] == true -> �̹� ĥ�� (p,q)�� �� (p-q+N) == x �� ĭ�� �ִ�.

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        arr = new int[N + 1];
        ver = new boolean[N+1];
        diag1 = new boolean[2*N+1];
        diag2 = new boolean[2*N+1];

        ans = 0;
        dfs(1);
        System.out.println(ans);
    }

    public static void dfs(int x) { // ������ x��° ���� �� ��° ĭ�� ������ �Ǵ�, ó���� dfs(1)
        if (x == N + 1) {
            ans++;
            return;
        }
        for (int i = 1; i <= N; i++) { // x��° �ٿ� i�� ���� �� �ִ��� �Ǵ�
            if(ver[i] || diag1[x+i] || diag2[x-i+N]) // (x, i)�� ���� �ٰ� ���� ������ �� �ִ��� �Ǵ�
                continue;

            ver[i] = diag1[x+i] = diag2[x-i+N] = true;
            dfs(x+1);
            ver[i] = diag1[x+i] = diag2[x-i+N] = false; // backtrack
        }
    }
}
