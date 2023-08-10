import java.io.*;
import java.util.*;

public class main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        int next=1;
        
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++){
            int x = Integer.parseInt(st.nextToken());
            if(x == next) next++;
        }
        
        System.out.print(N-next+1);
    }
}