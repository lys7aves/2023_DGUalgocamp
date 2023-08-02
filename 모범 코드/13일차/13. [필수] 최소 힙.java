import java.io.*;
import java.util.*;

public class main{
	static int[] tree;
	static int size=0;
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		tree = new int[N+1];
		
		for(int i=0; i<N; i++){
			int x = Integer.parseInt(br.readLine());
			
			if(x == 0) System.out.println(remove());
			else add(x);
		}
	}
	
	static void swap(int i, int j){
		int tmp=tree[i];
		tree[i] = tree[j];
		tree[j] = tmp;
	}
	
	static void add(int x){
		tree[++size] = x;
		
		int idx=size;
		while(idx > 1){
			if(tree[idx] < tree[idx/2]) swap(idx, idx/2);
			else break;
			
			idx /= 2;
		}
	}
	
	static int remove(){
		if(size == 0) return 0;
		int top = tree[1];
		
		tree[1] = tree[size];
		tree[size--] = 0;
		
		int idx = 1;
		while(idx*2 <= size){
			int l=idx*2, r=idx*2+1;
			
			if((r > size || tree[l] < tree[r]) && tree[idx] > tree[l]){
				swap(idx, l);
				idx = l;
			}
			else if(r <= size && tree[idx] > tree[r]){
				swap(idx, r);
				idx = r;
			}
			else break;
		}
		
		return top;
	}
}