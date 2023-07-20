import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        Queue<Integer> queue = new LinkedList<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        for (int i = 1; i <= N; i++) { // ť�� 1~N�� ���� ���ʷ� �ִ´�.
            queue.offer(i);
        }
        while (!queue.isEmpty()) { // ť�� �� ������ �ݺ��Ѵ�.
            for (int i = 1; i < M; i++) { // M-1���� �� �ڷ� ������
                int x = queue.poll();
                queue.offer(x);
            }
            int x = queue.poll(); // M��°�� ������ ����Ѵ�.
            sb.append(x + " ");
        }
        System.out.println(sb.toString());
    }
}
