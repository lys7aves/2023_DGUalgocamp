// O(N^3)
import java.io.*;
import java.util.*;

public class main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i=0; i<N; i++){ // 시작점 i
            for(int j=i; j<N; j++){ // 끝점 j
                // 구간 [i,j] 검사
                int sum = 0;
                for (int k=i; k<=j; k++){ // sum에 arr[i~j] 의 합 저장
                    sum += arr[k];
                }
                if (sum == M){ // 구간 [i,j]의 합이 M과 같다면 경우의 수에 1 추가
                    count++;
                }
            }
        }
        System.out.println(count);
    }
}

// O(N^2)
import java.io.*;
import java.util.*;

public class main {
    public static void main(String args[]) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for(int i = 0; i < N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int count = 0;
        for (int i=0; i<N; i++){ // 시작점 i
			// i를 시작점으로 한 구간들 검사
			int sum = 0;
			for(int j=i; j<N; j++) {
				sum += arr[j]; // arr[i,j]의 합 sum
				if(sum == M) count++;
				if(sum > M) break;
			}
        }
        System.out.println(count);
    }
}
