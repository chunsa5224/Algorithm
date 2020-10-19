import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj5557 {
	static int [] num;
	static long [][] ans;
	static int N;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		num = new int [N];
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		for(int i=0; i<N; i++) {
			num[i] = Integer.parseInt(st.nextToken());
		}
		ans = new long [N][21];
		ans[0][num[0]]=1;
		for(int i=1; i<N-1; i++) {
			int k = num[i];
			for(int j=0; j<21; j++) {
				if(ans[i-1][j]==0) continue;
				else {
					if(j+k>=0 && j+k<=20) {
						ans[i][j+k] += ans[i-1][j];
					}
					if(j-k>=0 && j-k<=20) {
						ans[i][j-k] += ans[i-1][j];
					}
				}
			}
		}
		
		System.out.println(ans[N-2][num[N-1]]);
	}
}
