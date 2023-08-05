import java.io.*;
import java.util.*;

public class main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        TreeSet<String> set = new TreeSet<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            
            String name = st.nextToken();
            String status = st.nextToken();
            
            if(status.equals("enter")) set.add(name);
            else set.remove(name);
        }
        
        System.out.println(set.size());
        for(String name: set){
            System.out.println(name);
        }
    }
}