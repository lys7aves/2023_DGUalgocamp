import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int X = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		String[] name = new String[N];
		int[][] point = new int[N][15];
		ArrayList<String> names = new ArrayList<>();
		ArrayList<Integer> points = new ArrayList<>();
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			name[i] = st.nextToken();
			int vote = Integer.parseInt(st.nextToken());
			
			if(X > vote*20) continue;
			names.add(name[i]);
			for(int j=1; j<=14; j++){
				point[i][j] = vote / j;
				points.add(-point[i][j]);	// 음수로 저장하면 내림차순으로 정렬할 수 있음.
			}
		}
		
		Collections.sort(names);
		Collections.sort(points);
		
		int[] chip = new int[N];
		for(int i=0; i<N; i++){
			for(int j=1; j<=14; j++){
				for(int k=0; k<14; k++){
					if(point[i][j] == -points.get(k)) chip[i] += 1;
				}
			}
		}
		
		for(int i=0; i<names.size(); i++){
			for(int j=0; j<N; j++){
				if(names.get(i) == name[j]){
					System.out.println(name[j] + " " + chip[j]);
				}
			}
		}
	}
}