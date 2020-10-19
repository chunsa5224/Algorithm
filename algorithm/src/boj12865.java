import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj12865 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int [] value = new int [n];
		int [] weight = new int [n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer (br.readLine()," ");
			weight[i] = Integer.parseInt(st.nextToken());
			value[i] = Integer.parseInt(st.nextToken());
		}
		int [][] dp = new int [n+1][k+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=k ;j++) {
				dp[i][j]=dp[i-1][j];
				if(weight[i-1]<=j) {
					dp[i][j]= Math.max(dp[i-1][j], value[i-1]+dp[i-1][j-weight[i-1]]);					
				}
			}
		}
		System.out.println(dp[n][k]);
		
		
	}

}
