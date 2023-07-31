// 시간초과가 뜰 때도 있음;;
import java.io.*;
import java.util.*;

public class main{
    static ArrayList<ArrayList<Integer>> edge;
    static boolean[] chk;
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        
        edge = new ArrayList<>();
        for(int i=0; i<=N; i++) edge.add(new ArrayList<>());
        
        while(M-- > 0){
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
			
            edge.get(u).add(v);
            edge.get(v).add(u);
        }
		
        chk = new boolean[N+1];
        int cnt=0;
        for(int i=1; i<=N; i++){
            if(!chk[i]){
                cnt += 1;
                dfs(i);
            }
        }
		
        System.out.print(cnt);
    }
    
    static void dfs(int v){
        if(chk[v]) return;
        chk[v] = true;
        
        for(int u: edge.get(v)) dfs(u);
    }
}