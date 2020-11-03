

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11057 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int dp [] = new int [10];
		for(int i=0; i<10;i++) {
			dp[i]=1;
		}
		for(int i=1; i<n;i++) {
			for(int j=1; j<10; j++) {
				dp[j] = (dp[j-1] + dp[j]) % 10007;
			}
		}
		int sum=0;
		for(int i=0; i<10;i++) {
			sum = (sum + dp[i]) % 10007;
		}
		System.out.println(sum);
	}

}
