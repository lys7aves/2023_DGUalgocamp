import java.io.*;
import java.util.*;

public class main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());
        
        st = new StringTokenizer(br.readLine());
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=0; i<N; i++) arr.add(Integer.parseInt(st.nextToken()));
        
        Collections.sort(arr);
        
        for(int i=0; i<Q; i++){
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            
            System.out.println(upper_bound(N, arr, B) - lower_bound(N, arr, A));
        }
    }
    
    static int lower_bound(int N, ArrayList<Integer> arr, int K){
        int answer=N, l=0, m, r=N-1;
        
        while(l <= r){
            m = (l+r)/2;
            
            if(arr.get(m) < K) l = m+1;
            else{
                answer = m;
                r = m-1;
            }
        }
        
        return answer;
    }
    
    static int upper_bound(int N, ArrayList<Integer> arr, int K){
        int answer=N, l=0, m, r=N-1;
        
        while(l <= r){
            m = (l+r)/2;
            
            if(arr.get(m) <= K) l = m+1;
            else{
                answer = m;
                r = m-1;
            }
        }
        
        return answer;
    }
}