import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int sum=0;
		ArrayList<Integer> arr = new ArrayList<>();
		for(int i=0; i<9; i++){
			arr.add(Integer.parseInt(br.readLine()));
			sum += arr.get(i);
		}
		
		// 미리 정렬해두면 나중에 특정 난쟁이들을 빼고 정렬하는 수고를 덜 수 있음.
		Collections.sort(arr);
		
		boolean[] chk = new boolean[9];
		for(int i=0; i<9; i++){
			for(int j=0; j<9; j++){
				if(i == j) continue;
				if(sum - arr.get(i) - arr.get(j) == 100){
					// 선언 시, false로 초기화가 되어 있어 true로 표시함.
					chk[i] = true;
					chk[j] = true;
				}
			}
		}
		
		for(int i=0; i<9; i++){
			if(!chk[i]) System.out.println(arr.get(i));
		}
	}
}