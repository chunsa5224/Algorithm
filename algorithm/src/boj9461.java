

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9461 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		long dp [] = new long [101];
		dp[1]=1;
		dp[2]=1;
		dp[3]=1;
		dp[4]=2;
		dp[5]=2;
		dp[6]=3;
		dp[7]=4;
		dp[8]=5;
		long answer[] = new long[c];
		for(int i=0; i<c; i++) {
			int a = Integer.parseInt(br.readLine());
			for(int j=9; j<=a; j++) {
				if(dp[j]==0) {
					dp[j]=dp[j-5]+dp[j-1];
				}
			}
			answer[i] = dp[a];
		}
		for(int i=0; i<c; i++) {
			System.out.println(answer[i]);
		}
	}

}
