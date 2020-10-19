

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

<<<<<<< HEAD
public class boj1520 {
=======
public class ex1520 {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git

	static int [][] graph;
	static int [][] dp;
	static int m,n;
	static int[] x= {0,1,0,-1};
	static int[] y= {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		String s= br.readLine();
		m = Integer.parseInt(s.split(" ")[0]);
		n = Integer.parseInt(s.split(" ")[1]);
		graph = new int [m+1][n+1];
		dp= new int [m+1][n+1];
		for(int i=1; i<=m; i++) {
			String arr [] = br.readLine().split(" ");
			for(int j=1; j<=n; j++) {
				graph[i][j]=Integer.parseInt(arr[j-1]);
				dp[i][j]=-1;
			}
		}
		int res = dfs(1,1);
		bw.write(res+"\n");
		bw.flush();

	}
	public static int dfs(int sm, int sn) {
		
		dp[sm][sn]=0;
		for(int i=0; i<4; i++) {
			int a = sm + y[i];
			int b = sn + x[i];
			if((1<=a && a<=m) && (1<=b && b<=n)) {
				if(graph[a][b]<graph[sm][sn]) {
					if(m==a && n==b) {
						dp[sm][sn]+=1;
					}
					if(dp[a][b]>=0) {
						dp[sm][sn]+=dp[a][b];
					}else {
						dp[sm][sn]+=dfs(a,b);
					}
				}
			}
		}
		return dp[sm][sn];
	}

}
