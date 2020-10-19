
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

<<<<<<< HEAD
public class boj2193 {
=======
public class ex2193 {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		long [] dp = new long[n+1];
		dp[1]=1;
		if(n>=2) {
			dp[2]=1;
		}
		for(int i=3; i<n+1; i++) {
			dp[i] = dp[i-1] + dp[i-2];
		}
		System.out.println(dp[n]);
		
	}

}
