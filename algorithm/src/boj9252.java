import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj9252 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		String s1 = br.readLine();
		String s2 = br.readLine();
		
		int [][] dp = new int [s1.length()+1][s2.length()+1];
		for(int i=1; i<=s1.length(); i++) {
			for(int j=1; j<=s2.length(); j++) {
				if(s1.charAt(i-1)==s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		int len = dp[s1.length()][s2.length()];
		sb.append(len);
		char [] ans = new char[len];
		int idx = len;
		sb.append("\n");
		int i= s1.length();
		int j= s2.length();
		while(idx>0 && i>0 && j>0) {
			if(dp[i][j]>dp[i-1][j] && dp[i][j]>dp[i][j-1]) {
				ans[--idx] = s2.charAt(j-1);
				i--;
				j--;
			}else if(dp[i][j]==dp[i][j-1]) {
				j--;
			}else if(dp[i][j]==dp[i-1][j]) {
				i--;
			}
		}
		for(char c: ans) {
			sb.append(c);
		}
		System.out.println(sb);
	}
}
