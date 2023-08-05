import java.io.*;
import java.util.*;

public class main{
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        
        TreeMap<String, Integer> map = new TreeMap<>();
        for(int i=0; i<N; i++){
            String book = br.readLine();
            
            if(!map.containsKey(book)) map.put(book, 0);
            map.replace(book, map.get(book)+1);
        }
        
        int max=0;
        String ans = new String();
        for(String book: map.keySet()){
            if(max < map.get(book)){
                max = map.get(book);
                ans = book;
            }
        }
        
        System.out.print(ans);
    }
}