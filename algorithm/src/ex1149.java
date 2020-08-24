

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1149 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] price = new int [n][3];
		for(int i=0; i<n; i++) {
			String [] s = br.readLine().split(" ");
			for(int j=0; j<3; j++) {
				price[i][j]=Integer.parseInt(s[j]);
			}
		}
		int [][] dp = new int [n][3];
		dp[0][0]= price [0][0];
		dp[0][1]= price [0][1];
		dp[0][2]= price [0][2];
		
		for(int i=1; i<n; i++) {
			dp[i][0]= Math.min(dp[i-1][1], dp[i-1][2])+price[i][0];
			dp[i][1]= Math.min(dp[i-1][0], dp[i-1][2])+price[i][1];
			dp[i][2]= Math.min(dp[i-1][1], dp[i-1][0])+price[i][2];
		}
		System.out.println(Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2])));
		
	}

}
