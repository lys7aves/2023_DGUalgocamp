import java.io.*;
import java.util.*;

public class main {
    public static void main(String args[]) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

		ArrayList<Integer> list = new ArrayList<>();

        for(int i =0; i<n; i++){
            int num = Integer.parseInt(br.readLine());
            list.add(num);
        }

        Collections.sort(list);

        for(int i : list) {
            sb.append(i).append('\n');
        }

        System.out.println(sb.toString());

    }
}
