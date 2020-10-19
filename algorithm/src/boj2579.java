
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

<<<<<<< HEAD
public class boj2579 {
=======
public class ex2579 {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int c = Integer.parseInt(br.readLine());
		
		int dp [] = new int [c];
		int stair [] = new int [c];
		
		for(int i=0; i<c;i++) {
			stair[i]= Integer.parseInt(br.readLine());
		}
		dp[0]=stair[0];
		if(c>1) {
			dp[1]=stair[0]+stair[1];
		}
		for(int i=2; i<c;i++) {
			if(i==2) {
				if(stair[i-2]>stair[i-1]) {
					dp[i]=stair[i-2]+stair[i];
					//System.out.println("i : "+ i + "dp : " + dp[i]);
				}else {
					dp[i]=stair[i-1]+stair[i];
					//System.out.println("i : "+ i + "dp : " + dp[i]);
				}
			}else {
				if(dp[i-2]>dp[i-3]+stair[i-1]) {
					dp[i]=dp[i-2]+stair[i];
					//System.out.println("i : "+ i + "dp : " + dp[i]);
				}else {
					dp[i]=dp[i-3]+stair[i-1]+stair[i];
					//System.out.println("i : "+ i + "dp : " + dp[i]);
				}
			}
		}
		System.out.println(dp[c-1]);
		
	}
	

}
