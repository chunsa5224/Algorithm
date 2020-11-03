
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2156 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int [] amt = new int [n];
		int [] sol = new int [n];
		
		for(int i=0; i<n; i++) {
			amt[i] = Integer.parseInt(br.readLine());
		}
		sol[0]=amt[0];
		if(n>=2) {
			sol[1]=amt[1]+amt[0];
		}
		
		for(int i=2; i<n; i++) {
			if(i==2) {
				sol[i]=Math.max(sol[1], Math.max(amt[0], amt[1])+amt[2]);
			}else {
				sol[i]=Math.max(sol[i-1], Math.max(sol[i-2], sol[i-3]+amt[i-1])+amt[i]);
			}
		}
		System.out.println(sol[n-1]);
	}

}
