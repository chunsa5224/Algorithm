import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14501 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int [] p = new int [n];
		int [] t = new int [n];
		int [] dp = new int [n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			t[i] = i + Integer.parseInt(st.nextToken()) -1;
			p[i] =Integer.parseInt(st.nextToken()); 
		}
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<=i; j++) {
				if(t[j]<=i && t[j]<n) {
					if(j==0) dp[i] = p[j];
					else dp[i] = Math.max(dp[i], dp[j-1]+p[j]);
				}
			}
		}
		
		System.out.println(dp[n-1]);
		
		
	}

}
