import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2096 {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		StringTokenizer st;
		int [][] num = new int [n][3];
		int [][] maxDP = new int [n][3];
		int [][] minDP = new int [n][3];
		int [] dy = {-1,0,1};
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<3; j++) {
				num[i][j]=Integer.parseInt(st.nextToken());
			}
		}
		for(int i=0; i<n; i++) {
			Arrays.fill(minDP[i], Integer.MAX_VALUE);
		}
		
		for(int i=0; i<3; i++) {
			maxDP[0][i] = num[0][i];
			minDP[0][i] = num[0][i];
		}
		
		for(int i=1; i<n; i++) {
			for(int j=0; j<3; j++) {
				for(int k=0; k<3; k++) {
					int mj =j+dy[k]; 
					if(mj>=0 && mj<3) {
						maxDP[i][j] = Math.max(maxDP[i-1][mj]+num[i][j], maxDP[i][j]);
						minDP[i][j] = Math.min(minDP[i-1][mj]+num[i][j], minDP[i][j]);
					}
				}
			}
		}
		
		int max = Math.max(maxDP[n-1][0], Math.max(maxDP[n-1][1], maxDP[n-1][2]));
		int min = Math.min(minDP[n-1][0], Math.min(minDP[n-1][1], minDP[n-1][2]));
		System.out.println(max +" " + min);
	}
	
	

}
