

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9465 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		int [] ans = new int [t];
		for(int i=0; i<t; i++) {
			int n = Integer.parseInt(br.readLine());
			int [][] value = new int [n][2];
			int [][] dp = new int [n][2];
			for(int k=0; k<2; k++) {
				String s []= br.readLine().split(" ");
				for(int j=0;j<n;j++) {
					value[j][k]= Integer.parseInt(s[j]);
				}				
			}
			if(n>=1) {
				dp[0][0]=value[0][0];
				dp[0][1]=value[0][1];
			}
			if(n>=2) {
				dp[1][0]=value[1][0] + dp[0][1];
				dp[1][1]=value[1][1] + dp[0][0];
			}
			for(int j=2; j< n; j++) {
				dp[j][0] = Math.max(dp[j-1][1], dp[j-2][1])+ value[j][0];
				dp[j][1] = Math.max(dp[j-1][0], dp[j-2][0])+ value[j][1];
			}
			ans[i] = Math.max(dp[n-1][0], dp[n-1][1]);
		}
		for(int i=0; i<t; i++) {
			System.out.println(ans[i]);
		}
	}

}
