package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ex11404 {
	static int n;
	static int m;
	static int graph [][];
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		graph = new int [n+1][n+1];
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				if(i==j) continue;
				graph[i][j]= 1000000000;
			}
		}
		for(int i=0; i<m;i++) {
			String s [] = br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			int c = Integer.parseInt(s[2]);
			graph[a][b]=Math.min(c, graph[a][b]);
		}
		for(int k=1; k<=n; k++) {
			for(int i=1; i<=n; i++) {
				for(int j=1; j<=n; j++) {
					graph[i][j]=Math.min(graph[i][j], graph[i][k]+graph[k][j]);	
				}
			}
		}
		for(int i=1; i<=n;i++) {
			for(int j=1; j<=n; j++) {
				if(graph[i][j]>=1000000000) {
					System.out.print(0+" ");
				}else {
					System.out.print(graph[i][j]+" ");					
				}
			}
			System.out.println();
		}
	}
	
}
