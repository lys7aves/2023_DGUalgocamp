import java.io.*;
import java.util.*;

public class main {
    public static void main(String args[]) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());
		int sum = 0;
		int[] cnt = new int[105];
		st = new StringTokenizer(br.readLine());
        for(int i =0; i<N; i++){
            int num = Integer.parseInt(st.nextToken());
			sum += num;
			cnt[num] ++;
            list.add(num);
        }

        Collections.sort(list);
        int average = (2*sum+N)/(2*N); // sum/N을 반올림하는 것은 sum/N + 1/2를 버림하는 것과 같다.
		int middle = list.get(N/2);
		int maxcnt = 0, mode = 0;
		for(int i=1; i<=100; i++) {
			if(cnt[i] >= maxcnt) {
				maxcnt = cnt[i];
				mode = i;
			}
		}
		int range = list.get(N-1) - list.get(0);

        System.out.println(average + "\n" + middle + "\n" + mode + "\n" + range);

    }
}
