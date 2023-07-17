import java.io.*;
import java.util.*;

public class main {
    public static int[][] cp;
    public static int dist(int x, int y) {
        return Math.abs(cp[x][0]-cp[y][0])+Math.abs(cp[x][1] - cp[y][1]);
    }

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        cp = new int[n][2];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            cp[i][0] = Integer.parseInt(st.nextToken());
            cp[i][1] = Integer.parseInt(st.nextToken());
        }

        int totaldist = 0;
        for(int i=0;i<n-1;i++) {
            totaldist += dist(i,i+1);
        } // totaldist�� ��� üũ����Ʈ�� �ǳʶ��� �ʾ��� ���� �� �Ÿ�
        int answer = Integer.MAX_VALUE;
        for(int i=1;i<n-1;i++) {
            int mindist = totaldist - dist(i,i-1)- dist(i,i+1) + dist(i-1,i+1); // mindist = i�� üũ����Ʈ�� �پ�Ѿ��� ���� �Ÿ�
            if(mindist < answer) answer = mindist;
        }
        System.out.println(answer);
    }

}
