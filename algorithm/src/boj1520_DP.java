

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1520_DP {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s= br.readLine();
		int m = Integer.parseInt(s.split(" ")[0]);
		int n = Integer.parseInt(s.split(" ")[1]);
		int [][] height = new int [m][n];
		for(int i=0; i<m; i++) {
			String arr [] = br.readLine().split(" ");
			for(int j=0; j<n; j++) {
				height[i][j]=Integer.parseInt(arr[j]);
			}
		}
		System.out.println(dp(height,0,0,0));
	}
	static int dp(int [][] height, int m, int n, int cnt) {
		int sum=0;
		if(m==height.length-1 && n==height[0].length-1) {
			return 1;
		}
		if(n!=height[m].length-1) {
			if(height[m][n]>height[m][n+1]) {
				sum += dp(height,m,n+1,cnt);
			}						
		}
		if(m!=height.length-1) {
			if(height[m][n]>height[m+1][n]) {
				sum += dp(height,m+1,n,cnt);
			}
		}
		if(n!=0) {
			if(height[m][n]>height[m][n-1]) {
				sum += dp(height,m,n-1,cnt);
			}			
		}
		if(m!=0) {
			if(height[m][n]>height[m-1][n]) {
				sum += dp(height,m-1,n,cnt);
			}			
		}
		return sum;
	}

}
