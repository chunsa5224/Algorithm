import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class boj9935 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String str = br.readLine();
		String rm = br.readLine();
		
		Stack <Character> stack = new Stack<>();
		
		for(int i=str.length()-1; i>=0; i--) {
			boolean isBomb = false;
			char c = str.charAt(i);
			stack.push(c);
			if(c==rm.charAt(0) && stack.size()>=rm.length()) {
				isBomb = true;
				for(int j=0; j<rm.length(); j++) {
					if(rm.charAt(j)!=stack.get(stack.size()-j-1)) {
						isBomb = false;
						break;
					}
				}
				if(isBomb) {
					for(int k=0; k<rm.length(); k++) {
						stack.pop();
					}
				}
			}
		}
		StringBuilder sb = new StringBuilder();
		if(stack.isEmpty()) sb.append("FRULA");
		else {
			for(int i=stack.size()-1; i>=0; i--) {
				sb.append(stack.pop());
			}
		}
		System.out.println(sb);
	}
}
