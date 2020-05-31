package codingTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class hyundaicard1 {

	static int [] combi;
	static int n;
	static int [] p;
	static int a;
	public static void main(String[] args) throws NumberFormatException, IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		String [] arr = br.readLine().split(" ");
		int m = Integer.parseInt(br.readLine());
		p = new int[n];
		for(int i=0; i<n; i++) {
			p[i]= Integer.parseInt(arr[i]);
		}
		
		
	}
	static int cal(int i, int sum) {
		if(sum<=0) {
			return 0;
		}
		if(sum==p[i]) {
			combi[a] = i;
			return sum;
		}
		for(int j=i+1; j<n;j++) {
			if(sum == p[j] + cal(j,sum-p[j])) {
				
				combi[a] = j;
				
			}
		}
		return 0;
	} 
}
