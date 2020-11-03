

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int p [] = new int [n+1];
		String s[] = br.readLine().split(" ");
		for(int i=0; i<n; i++) {
			p[i+1]=Integer.parseInt(s[i]);
		}
		int dp[] = new int[n+1];
		dp[0]=p[0];
		for(int i=1; i<=n; i++) {
			dp[i]=p[i];
			for(int j=1; j<i; j++) {
				dp[i]=Math.max(dp[i], dp[i-j]+p[j]); 
			}
		}
		System.out.println(dp[n]);
		
	}

}
