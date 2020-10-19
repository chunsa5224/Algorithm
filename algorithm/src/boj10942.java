import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj10942 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [] num = new int [n];
		int [][] dp = new int [n][n];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringBuilder sb =new StringBuilder();
		
		for(int i=0; i<n; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		for(int i=0; i<n-1; i++) {
			dp[i][i]=1;
			if(num[i]==num[i+1]) dp[i][i+1]=1;
		}
		dp[n-1][n-1]=1;
		
		for(int j=2; j<n; j++) {
			for(int i=0; i<n-j; i++) {
				if(num[i]==num[i+j] && dp[i+1][i+j-1]==1) dp[i][i+j]=1;
			}
		}
		System.out.println();
		for(int i=0; i<n; i++) {
			for(int j: dp[i]) System.out.print(j);
			System.out.println();
		}
		
		int m = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<m; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int start = Integer.parseInt(st.nextToken())-1;
			int end = Integer.parseInt(st.nextToken())-1;
			sb.append(dp[start][end]+"\n"); 
		}
		System.out.println(sb);
		
	}
	

}
