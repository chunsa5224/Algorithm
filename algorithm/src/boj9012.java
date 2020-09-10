import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9012 {

	public static void main (String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		for(int i=0; i<n; i++) {
			String [] str= br.readLine().split("");
			int open=0;
			int close=0;
			for(String s : str) {
				if(s.equals("(")) open++;
				else close++;
				if(close>open) {
					break;
				}
			}
			if(close==open) System.out.println("YES");
			else System.out.println("NO");
		}
	}

}
