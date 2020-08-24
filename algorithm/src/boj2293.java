

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex2293 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s.split(" ")[0]);
		int total = Integer.parseInt(s.split(" ")[1]);
		
		int [] value = new int[n];
		int [] cnt = new int[total+1];
		for(int i=0; i<n; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		cnt[0]=1;
		for(int i=0; i<n; i++) {
			for(int j=1; j<=total; j++) {
				if(value[i]<=j) {
					cnt[j]+= cnt[j-value[i]];
				}
			}
		}
		System.out.println(cnt[total]);
		
	}

}
