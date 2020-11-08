import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj2812 {

	public static void main(String[] args) throws IOException{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String [] s = br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int k = Integer.parseInt(s[1]);
		
		char [] num = br.readLine().toCharArray();
		Stack<Integer> stack = new Stack<>();
	
		
		int count=0;
		stack.add(num[0]-'0');
		
		for(int i=1; i<n; i++) {
			int temp = num[i]-'0';
			while(!stack.isEmpty() && stack.peek()<temp && count<k) {
				count++;
				stack.pop();
			}
			if(stack.size()<n-k) {
				stack.add(temp);
			}
		}
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<stack.size(); i++) {
			sb.append(stack.get(i));
		}
		System.out.print(sb);
	}

}
