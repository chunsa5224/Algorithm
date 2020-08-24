
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1463 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		int sol [] = new int [n+1];
		for(int i=1; i<=n; i++) {
			dp(i,sol);
		}
		System.out.println(sol[n]);
	}
	
	static void dp(int n, int [] sol) {
		if(n==1) {
			sol[0]=0;
			sol[1]=0;
			return;
		}
		int c = sol[n-1];
		if(n%3==0) {
			int a = sol[n/3];
			if(n%2==0) {
				int b = sol[n/2];
				if(a<=b && a<=c) {
					sol[n]=a+1;
				}else if(b<=a && b<=c) {
					sol[n]=b+1;
				}else if(c<=a && c<=b) {
					sol[n]=c+1;
				}
				return;
			}
			if(a<c) {
				sol[n]=a+1;
			}else {
				sol[n]=c+1;
			}
			return;
		}
		if(n%2==0) {
			int b = sol[n/2];
			if(b<c) {
				sol[n]=b+1;
			}else {
				sol[n]=c+1;
			}
			return;
		}
		sol[n]=c+1;
		return;
	}

}
