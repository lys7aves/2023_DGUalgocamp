import java.io.*;
import java.util.*;

public class main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		// ��ǻ�ʹ� ���������� �Ǽ��� ǥ���ϱ� ������ ��Ȯ�� ���� �������� �ʴ´�. ���� �� �Ǽ��� ������ �˻��ϴ� �� ��Ȯ�� ���� �ʿ��� ��쿡�� �ִ��� ���� ������ �̿��Ѵ�.

		// A/B�� C/D�� �񱳴� A*D�� B*C�� �񱳸� ���� �� �� �ִ�.

		long AD = (long)A*D;
		long BC = (long)B*C;
		if(AD>BC) System.out.println("A/B");
		else if(AD<BC) System.out.println("C/D");
		else System.out.println("EQUALS");
    }

}
