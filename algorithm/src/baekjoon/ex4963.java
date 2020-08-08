package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ex4963 {
	
	static int[][] graph;
	static boolean[][] visit;
	static int w;
	static int h;
	static int [] dx = {0,0,-1,1,-1,-1,1,1};
	static int [] dy = {1,-1,0,0,1,-1,1,-1};
	
	public static void main(String[] args) throws IOException {
	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			String s [] = br.readLine().split(" ");
			w= Integer.parseInt(s[0]);
			h= Integer.parseInt(s[1]);
			if(w==0 && h==0) break;
			int cnt=0;
			graph = new int [h+1][w+1];
			visit = new boolean [h+1][w+1];
			
			for(int i=1; i<=h;i++) {
				s=br.readLine().split(" ");
				for(int j=1; j<=w;j++) {
					graph[i][j]=Integer.parseInt(s[j-1]);
				}
			}
			for(int i=1; i<=h; i++) {
				for(int j=1; j<=w;j++) {
					if(graph[i][j]==1 && visit[i][j]==false) {
						cnt+=dfs(i,j);
					}
				}
			}
			System.out.println(cnt);
		}
	}
	static int dfs(int x, int y) {
		visit[x][y]=true;
		for(int i=0; i<8; i++) {
			int xx = x+dx[i];
			int yy = y+dy[i];
			if(xx>0 && xx<=h && yy>0 && yy<=w) {
				if(graph[xx][yy]==1 && !visit[xx][yy]) {
					dfs(xx,yy);
				}
			} 
		}
		return 1;
	}

}
