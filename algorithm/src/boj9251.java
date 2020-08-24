

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex9251 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String a = br.readLine();
		String b = br.readLine();
		int m = a.length();
		int n = b.length();
		int dp[][] = new int [m+1][n+1];
		dp[0][0]=0;
		for(int i=0; i<=m; i++) {
			dp[i][0]=0;
			for(int j=0; j<=n; j++) {
				if(i==0){
					dp[0][j]=0;
				}else if(j==0){
					dp[i][0]=0;
				}else{
					if(a.charAt(i-1)==b.charAt(j-1)) {
						dp[i][j]=dp[i-1][j-1]+1;
					}else {
						dp[i][j]= Math.max(dp[i-1][j], dp[i][j-1]);
					}	
				}
			}
		}
		System.out.println(dp[m][n]);
	}

}
