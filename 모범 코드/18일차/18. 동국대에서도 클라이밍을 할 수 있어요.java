import java.io.*;
import java.util.*;

public class main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        
        int N = Integer.parseInt(br.readLine());
        
        ArrayList<Coordinate> cor = new ArrayList<>();
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            cor.add(new Coordinate(x, y));
        }
        
        Collections.sort(cor);
        
        int[] lis = new int[N];
        ArrayList<Integer> K = new ArrayList<>();
        K.add(0);
        int LIS=0;
        for(int i=0; i<N; i++){
            int y = cor.get(i).getY();
            lis[i] = upper_bound(K, y);
            
            if(K.size() == lis[i]) K.add(y);
            K.set(lis[i], y);
            
            LIS = Math.max(LIS, lis[i]);
        }
        
        System.out.print(LIS);
    }
    
    static int upper_bound(ArrayList<Integer> K, int key){
        int ub = K.size();
        int l = 0, r = ub;
        
        while(l < r){
            int m = (l+r)/2;
            
            if(K.get(m) > key){
                r = m;
                ub = m;
            }
            else l = m+1;
        }
        
        return ub;
    }
}

class Coordinate implements Comparable<Coordinate>{
    private int x, y;
    
    public Coordinate(int x, int y){
        this.x = x;
        this.y = y;
    }
    
    public int getX(){ return this.x; }
    public int getY(){ return this.y; }
    
    @Override
    public int compareTo(Coordinate p){
        if(getX() == p.getX()) return getY() - p.getY();
        return getX() - p.getX();
    }
}