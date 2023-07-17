//O(N^3)
import java.io.*;
import java.util.*;
public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int count = 0;
        for(int i=1; i<=N; i++) {
            for(int j=i; j<=N; j++) {
                for(int k=j; k<=N; k++) {
                    if(i+j+k == N && k < i+j) count++;
                }
            }
        }
        System.out.println(count);
    }
}










//O(N^2)
import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int count=0;
        for(int i=1; i<n; i++) {
            for(int j=i; j<n; j++) {
                    int k=n-(i+j);
                    if(j<=k&&k<i+j) {
                        count++;
                }
            }
        }
        System.out.println(count);
    }

}
