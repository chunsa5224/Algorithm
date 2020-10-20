import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj7579 {

	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int [] mem = new int[n];
		int [] cost = new int [n];
		
		int [][] dp = new int [n][10001];
		
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			mem[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<n; i++) {
			cost[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<10001; i++) {
			if(i>=cost[0]) dp[0][i]=mem[0];
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<10001; j++) {
				if(j>=cost[i]) dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-cost[i]] + mem[i]);
				else dp[i][j] = dp[i-1][j];
			}
		}
		
		out: for(int j=0; j<10001; j++) {
			for(int i=0; i<n;i++) {
				if(dp[i][j]>=m) {
					System.out.println(j);
					break out;
				}
			}
		}
		
		
		
	}

}
