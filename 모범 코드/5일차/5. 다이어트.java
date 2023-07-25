import java.io.*;
import java.util.*;

public class main {
	static int N, mp, mf, ms, mv;
	static int[] p, f, s, v, c, ans;
	static boolean[] chk;

    public static void main(String[] args) throws  IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
		
        st = new StringTokenizer(br.readLine());
		mp = Integer.parseInt(st.nextToken());
		mf = Integer.parseInt(st.nextToken());
		ms = Integer.parseInt(st.nextToken());
		mv = Integer.parseInt(st.nextToken());
		
		ans = new int[N+1];
		chk = new boolean[N];
		p = new int[N];
		f = new int[N];
		s = new int[N];
		v = new int[N];
		c = new int[N];
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			p[i] = Integer.parseInt(st.nextToken());
			f[i] = Integer.parseInt(st.nextToken());
			s[i] = Integer.parseInt(st.nextToken());
			v[i] = Integer.parseInt(st.nextToken());
			c[i] = Integer.parseInt(st.nextToken());
		}
		dfs(0, 0, 0, 0, 0, 0);
		
		System.out.println(ans[N]);
		for(int i=0; i<N; i++){
			if(ans[i] == 1) System.out.print(i+1 + " ");
		}
    }

    static void dfs(int k, int np, int nf, int ns, int nv, int nc){
		if(k == N){
			if(np >= mp && nf >= mf && ns >= ms && nv >= mv && (ans[N] == 0 || ans[N] > nc)){
				for(int i=0; i<N; i++){
					ans[i] = chk[i] ? 1 : 0;
				}
				ans[N] = nc;
			}
			return;
		}
		
		chk[k] = true;
		dfs(k+1, np+p[k], nf+f[k], ns+s[k], nv+v[k], nc+c[k]);
		chk[k] = false;
		dfs(k+1, np, nf, ns, nv, nc);
    }

}
