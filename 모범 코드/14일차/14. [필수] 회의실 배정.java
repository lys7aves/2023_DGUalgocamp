import java.io.*;
import java.util.*;

public class main{
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		
		ArrayList<Meeting> meetings = new ArrayList<>();
		for(int i=0; i<N; i++){
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			
			meetings.add(new Meeting(start, end));
		}
		
		Collections.sort(meetings);
		
		int end=0, cnt=0;
		for(int i=0; i<N; i++){
			if(meetings.get(i).getStart() >= end){
				cnt++;
				end = meetings.get(i).getEnd();
			}
		}
		
		System.out.print(cnt);
	}
}

class Meeting implements Comparable<Meeting>{
	private int start, end;
	
	public Meeting(int start, int end){
		this.start = start;
		this.end = end;
	}
	
	public int getStart(){ return this.start; }
	public int getEnd(){ return this.end; }
	
	@Override
	public int compareTo(Meeting x){
		return getEnd() - x.getEnd();
	}
}