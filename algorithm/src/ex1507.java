

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex1507 {
	static int n;
	static int [][] graph;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		graph = new int [n+1][n+1];
		for(int i=1; i<=n; i++) {
			String s [] = br.readLine().split(" ");
			for(int j=1; j<=n; j++) {
				graph[i][j]=Integer.parseInt(s[j-1]);
			}
		}
		int total =0;
		int result [][] = new int [n+1][n+1];
		for(int k=1; k<=n;k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					if(i!=k && j!=k && graph[i][j]==graph[i][k]+graph[k][j]) {
						result[i][j]=1;
					}
					else if(graph[i][j]>graph[i][k]+graph[k][j]) {
						System.out.println(-1);
						return;
					}
				}
			}
		}
		for(int i=1; i<=n; i++) {
			for(int j=i; j<=n; j++) {
				if(result[i][j]==0) total+= graph[i][j];
			}
		}
		System.out.println(total);			
		
		
	}

}
