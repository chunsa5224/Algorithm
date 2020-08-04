package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex11054 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		String s [] = br.readLine().split(" ");
		int num[]=new int[n];
		for(int i=0; i<n; i++) {
			num[i]=Integer.parseInt(s[i]);
		}
		int max=0;
		for(int i=0;i<n;i++) {
			max = Math.max(max, asc(i,num)+dsc(i,num)+1);
		}
		
		System.out.println(max);

	}
	static int asc(int a, int[] num) {
		int [] dp = new int [a];
		int max =0;
		for(int i=0; i<a; i++) {
			if(num[i]<num[a]) {
				dp[i]=1;
				for(int j=0; j<i; j++) {
					if(num[j]<num[i]) {
						dp[i]=Math.max(dp[i], dp[j]+1);						
					}
				}
			}
			max= Math.max(dp[i], max);
		}
		return max;
	}
	static int dsc(int a, int[] num) {
		int [] dp = new int [num.length-a-1];
		int max =0;
		for(int i=a+1; i<num.length; i++) {
			if(num[i]<num[a]) {
				dp[i-a-1]=1;
				for(int j=a+1; j<i; j++) {
					if(num[j]>num[i]) {
						dp[i-a-1]=Math.max(dp[i-a-1], dp[j-a-1]+1);						
					}
				}
			}
			max= Math.max(dp[i-a-1], max);
		}
		return max;
	}

}
