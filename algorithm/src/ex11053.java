

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex11053 {

	public static void main(String[] args) throws NumberFormatException, IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int l = Integer.parseInt(br.readLine());
		int [] num = new int[l];
		String []  s = br.readLine().split(" "); 
		for(int i=0; i<l; i++) {
			num[i] = Integer.parseInt(s[i]);
		}
		
		int [] dp = new int[l];
		int max=0;
		for(int i=0; i<l; i++) {
			int temp = num[i];
			dp[i]=1;
			for(int j=0; j<i;j++) {
				if(dp[i]<=dp[j] && num[j]<num[i]) {
					dp[i] = dp[j]+1;
				}
			}
			if(max<dp[i]) {
				max=dp[i];
			}
		}
		System.out.println(max);
	}

}
