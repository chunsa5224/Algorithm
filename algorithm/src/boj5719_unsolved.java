

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class boj5719_unsolved {
	static ArrayList<Integer>[] adj;
	static int [][] weight;
	static boolean [] visit;
	static int [] prev;
	public static void main(String[] args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		String s []= br.readLine().split(" ");
		int n = Integer.parseInt(s[0]);
		int m = Integer.parseInt(s[1]);
		while(n!=0 && m!=0) {
			s=br.readLine().split(" ");
			int start = Integer.parseInt(s[0]);
			int dest = Integer.parseInt(s[1]); 
			visit = new boolean [n];
			weight = new int [n][n];
			prev = new int[n];
			adj = new ArrayList[n];
			for(int i=0; i<n;i++) {
				adj[i]= new ArrayList<Integer>();
			}
			
			for(int i=0; i<m; i++) {
				s=br.readLine().split(" ");
				int a = Integer.parseInt(s[0]);
				int b = Integer.parseInt(s[1]);
				weight[a][b] = Integer.parseInt(s[2]);
				adj[a].add(b);
			}
			
			
		}
	}
	static void shortPath(int s, int d) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visit[s] =true;
		while(!queue.isEmpty()) {
			int x= queue.poll();
			for(int y: adj[x]) {
				if(!visit[y]) {
					queue.add(y);
					visit[y]=true;
					prev[y]=x;
					//weight[x][y]==
				}
			}
		}
		
	}
}
