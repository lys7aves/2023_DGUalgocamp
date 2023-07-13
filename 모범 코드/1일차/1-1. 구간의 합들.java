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
        for (int i=0; i<N; i++){ // ������ i
            for(int j=i; j<N; j++){ // ���� j
                // ���� [i,j] �˻�
                int sum = 0;
                for (int k=i; k<=j; k++){ // sum�� arr[i~j] �� �� ����
                    sum += arr[k];
                }
                if (sum == M){ // ���� [i,j]�� ���� M�� ���ٸ� ����� ���� 1 �߰�
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
        for (int i=0; i<N; i++){ // ������ i
			// i�� ���������� �� ������ �˻�
			int sum = 0;
			for(int j=i; j<N; j++) {
				sum += arr[j]; // arr[i,j]�� �� sum
				if(sum == M) count++;
				if(sum > M) break;
			}
        }
        System.out.println(count);
    }
}
