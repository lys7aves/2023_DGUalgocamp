import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int arr[] = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int ans = 0;

        for (int i=0; i<N; i++) { // 구간의 시작점 i
            for(int j=i; j<N; j++) { // 구간의 끝점 j
                int sum = 0;
                for(int k=i; k<=j; k++) sum += arr[k];
                boolean check = false;
                for(int k=i; k<=j; k++) {
                    if(sum == arr[k] * (j-i+1)) { // sum / (j-i+1) == arr[k]
                        check = true;
                        break;
                    }
                }
                if(check == true) {
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }

}
