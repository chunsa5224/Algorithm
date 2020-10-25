import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj15988 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		int [] dp = new int [1000001];
		int [] N = new int [T];
		dp[0] = 0;
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		int max= 0;
		for(int i=0; i<T; i++) {
			N[i] = Integer.parseInt(br.readLine());
			max = Math.max(max, N[i]);
		}
		for(int j=4; j<=max; j++) {
			dp[j]= ((dp[j-3] + dp[j-2])%1000000009 + dp[j-1])%1000000009;
		}
		for(int i=0; i<T; i++) {
			System.out.println(dp[N[i]]);
		}
	}

}
