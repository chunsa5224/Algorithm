package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1932 {

	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in)); 
		int n  = Integer.parseInt(br.readLine());
		int num [][] = new int [n][n];
		int dp[][] = new int [n][n];
		
		for(int i=0; i<n; i++) {
			String s []= br.readLine().split(" ");
			for(int j=0; j<s.length;j++) {
				num[i][j]= Integer.parseInt(s[j]);
			}
		}
		for(int i=n-1;i>=0;i--) {
			for(int j=0; j<i+1; j++) {
				if(i==n-1) {
					dp[i][j]=num[i][j];
				}else {
					dp[i][j]=Math.max(dp[i+1][j], dp[i+1][j+1])+num[i][j];
				}
			}
		}
		System.out.println(dp[0][0]);
	}

}
