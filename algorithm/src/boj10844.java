

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj10844 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int a= Integer.parseInt(br.readLine());
		long [][] dp = new long [100][10];
		
		if(a>=1) {
			dp[0][0]=0;
			for(int i=1; i<10;i++) {
				dp[0][i]=1;
			}
		}
		for(int i=1; i<a; i++) {
			dp[i][0]=dp[i-1][1];
			dp[i][9]=dp[i-1][8];
			for(int j=1; j<9; j++) {
				dp[i][j]= (dp[i-1][j-1]+dp[i-1][j+1]) % 1000000000;
			}
		}
		long answer =0;
		for(int i=0; i<10; i++) {
			answer = (answer + dp[a-1][i]) % 1000000000 ;
		}
		System.out.println(answer%1000000000);
		
	}

}
