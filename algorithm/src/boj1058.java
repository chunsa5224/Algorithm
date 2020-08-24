

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj1058 {

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int [][] graph = new int [n][n];
		
		for(int i=0; i<n; i++) {
			String s[] = br.readLine().split("");
			for(int j=0; j<n; j++) {
				if(s[j].equals("Y")) {
					graph[i][j]=1;
				}
			}
		}
		int [] friends = new int [n];
		for(int i=0; i<n; i++) {
			boolean [] check = new boolean [n];
			for(int j=0; j<n;j++) {
				if(graph[i][j]==1) {
					check[j]=true;
					friends[i]++;
					for(int k=0; k<n;k++) {
						if(!check[k] && graph[j][k]==1 && graph[i][k]==0 && k!=i) {
							friends[i]++;
							check[k]=true;
						}
					}
				}
			}
		}
		int max=0;
		for(int i: friends) {
			max = Math.max(i, max);
		}
		System.out.println(max);

	}

}