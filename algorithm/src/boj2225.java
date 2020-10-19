import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2225 {
	public static void main(String[] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine()," ");
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		long [][] dp = new long [K][N+1];
		for(int k=0; k<K; k++) {
			for(int i=0; i<=N; i++) {
				if(k==0) {
					dp[0][i]=1;
				}else if(k==1) {
					dp[1][i]= i+1;
				}else {
					for(int j=0; j<=i; j++) {
						dp[k][i] += dp[k-1][j]%1000000000;
					}
				}
			}
		}
		System.out.println(dp[K-1][N]%1000000000);
		
	}

}
