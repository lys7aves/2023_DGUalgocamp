import java.io.*;
import java.util.*;

public class main{
    static boolean[] chk = new boolean[10000];
    
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        System.out.print(dfs(N, 0));
    }
    
    static int dfs(int x, int d){
        if(chk[x]) return d;
        chk[x] = true;
        
        int middle = (x/10)%100;
        return dfs(middle * middle, d+1);
    }
}