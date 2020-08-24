

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s = br.readLine();
		int n = Integer.parseInt(s.split(" ")[0]);
		int total = Integer.parseInt(s.split(" ")[1]);
		
		int [] value = new int[n];
		int [] cnt = new int[total+1];
		for(int i=0; i<n; i++) {
			value[i] = Integer.parseInt(br.readLine());
		}
		for(int i=1; i<=total;i++) {
			cnt[i]=1000000000;
		}
		for(int i=0; i<n; i++) {
			for(int k=1; k<=total; k++) {
				if(k>=value[i]) {
					cnt[k] = Math.min(cnt[k], 1+cnt[k-value[i]]);	
				}
			}
		}
		if(cnt[total]==1000000000) {
			cnt[total]=-1;
		}
		System.out.println(cnt[total]);
	}

}
