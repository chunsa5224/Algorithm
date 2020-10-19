import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj11049 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int [][] arr = new int [N][2];
		StringTokenizer st ;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			arr[i][0]= Integer.parseInt(st.nextToken());
			arr[i][1]= Integer.parseInt(st.nextToken());
		}
		
		int [][] dp = new int [N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		for(int i=0; i<N; i++) {
			dp[i][i] = 0;			
		}
		for(int l=1; l<N; l++) {
			for(int i=0; i<N-l; i++) {
				for(int k=i; k<i+l;k++) {
					dp[i][i+l] = Math.min(dp[i][k] + dp[k+1][i+l] + arr[i][0]*arr[k][1]*arr[i+l][1], dp[i][i+l]);					
				}
			}
			
		}
		System.out.println(dp[0][N-1]);
	}

}
