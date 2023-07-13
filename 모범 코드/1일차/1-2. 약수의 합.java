//O(N)
import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long ans = 0L;
        for(long i=1L; i<=N; i++)
        {
            if(N % i == 0) ans += i;
        }
        System.out.println(ans);
    }

}


//O(sqrt(N))
import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        long ans = 0L;
        for(long i=1L; i*i<=N; i++)
        {
            if(N % i == 0) {
                if(i != N/i) ans += i + (N/i);
                else ans += i;
            }
        }
        System.out.println(ans);
    }

}
