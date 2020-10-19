

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

<<<<<<< HEAD
public class boj9084 {
=======
public class ex9084 {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine());
		int [] ans = new int [test];
		for(int i=0; i<test; i++) {
			int n = Integer.parseInt(br.readLine());
			int [] value = new int [n];
			String [] s = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				value[j]=Integer.parseInt(s[j]);
			}
			int total = Integer.parseInt(br.readLine());
			int [] dp = new int [total+1];
			dp[0]=1;
			for(int j=0; j<n;j++) {
				for(int k=1; k<=total;k++) {
					if(k>=value[j]) {
						dp[k]+=dp[k-value[j]];						
					}
				}
			}
			ans[i]=dp[total];
		}
		for(int i=0; i<test; i++) {
			System.out.println(ans[i]);
		}

	}

}
