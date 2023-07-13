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

		// 컴퓨터는 이진법으로 실수를 표현하기 때문에 정확한 값을 저장하지 않는다. 따라서 두 실수가 같은지 검사하는 등 정확한 값이 필요한 경우에는 최대한 정수 연산을 이용한다.

		// A/B와 C/D의 비교는 A*D와 B*C의 비교를 통해 알 수 있다.

		long AD = (long)A*D;
		long BC = (long)B*C;
		if(AD>BC) System.out.println("A/B");
		else if(AD<BC) System.out.println("C/D");
		else System.out.println("EQUALS");
    }

}
