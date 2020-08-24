

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex5567 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());
		int graph [][] = new int [n+1][n+1];
		
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				graph[i][j]=1000000000;
			}
		}
		for(int i=1; i<=m;i++) {
			String s [] = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			graph[a][b]=1;
			graph[b][a]=1;
		}
		int cnt =0; 
		for(int i=2; i<=n; i++) {
			if(graph[1][i]==1) {
				for(int j=2;j<=n;j++) {
					if(graph[1][j]!=1 && graph[i][j]==1) {
						graph[1][j]=2;
					}
				}
			}
		}
		for(int i=2; i<=n; i++) {
			if(graph[1][i]<=2) cnt++;
		}
		System.out.println(cnt);
		

	}

}
