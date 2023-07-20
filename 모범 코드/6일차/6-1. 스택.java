import java.io.*;
import java.util.*;

public class main {
    public static void main(String[] args) throws IOException{
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        Stack<Integer> stack = new Stack<Integer>();
        while(true) {
            st = new StringTokenizer(br.readLine());
            String str = st.nextToken();
            if(str.equals("size")) {
                int x = stack.size();
                System.out.println(x);
            }else if(str.equals("empty")) {
                Boolean isEmpty = stack.empty();
                if(isEmpty) System.out.println(1);
                else System.out.println(0);
            }else if(str.equals("push")) {
                int x = Integer.parseInt(st.nextToken());
                stack.push(x);
                System.out.println(x);
            }else if(str.equals("top")) {
                if(stack.empty()) {
                    System.out.println(-1);
                    continue;
                }
                int x = stack.peek();
                System.out.println(x);
            }else if(str.equals("pop")) {
                int x = stack.pop();
                System.out.println(x);
            }else {
                break;
            }
        }
    }
}
