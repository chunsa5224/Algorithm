
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj11726 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int i = Integer.parseInt(br.readLine());
		
		int [] dp = new int[i];
		
		dp[0]=1;
		
		if(i>1) {
			dp[1]=2;
		}
		
		for(int j=2; j<i;j++) {
			dp[j]=(dp[j-1]+dp[j-2]) % 10007;
		}
		System.out.println(dp[i-1]);
	}

}
