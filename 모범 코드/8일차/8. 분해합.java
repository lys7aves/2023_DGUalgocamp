import java.io.*;
import java.util.*;

public class main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        boolean flag=false;
        for(int i=1; i<=N; i++){
            int sum=0, j=i;
            while(j > 0){
                sum += j%10;
                j /= 10;
            }
            
            if(sum+i == N){
                System.out.print(i);
                flag = true;
                break;
            }
        }
        
        if(!flag) System.out.print(0);
    }
}