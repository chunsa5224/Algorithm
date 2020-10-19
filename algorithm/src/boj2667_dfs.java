

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

<<<<<<< HEAD
public class boj2667_dfs {
=======
public class ex2667_dfs {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git

	static int N,apt;
	static int [][] graph;
	static boolean [][] visit;
	static int [] ans ;
	static int [] dx = {0,0,-1,1};
	static int [] dy = {-1,1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N=Integer.parseInt(st.nextToken());
		graph = new int [N][N];
		visit = new boolean[N][N];
		apt = 0;
		ans = new int[25*25];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0; j<N; j++) {
				graph[i][j] = line.charAt(j)-'0';
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(graph[i][j]==1 && !visit[i][j]) {
					apt++;
					ans[apt]=1;
					dfs(i,j);
				}
			}
		}
		System.out.println(apt);
		
		Arrays.sort(ans);
		for(int i: ans) {
			if(i==0) continue;
			System.out.println(i);
		}
		
	}
	static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			visit[x][y]=true;
			int xx = x+ dx[i];
			int yy = y+ dy[i];
			if(xx>=0 && yy>=0 && xx<N && yy<N) {
				if(graph[xx][yy]==1 && !visit[xx][yy]) {
					ans[apt]++;
                    dfs(xx,yy);
				}
			}
		}
	}

}
