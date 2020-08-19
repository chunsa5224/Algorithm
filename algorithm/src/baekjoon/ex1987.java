package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ex1987 {
	static int N,M, cnt, ans;
	static char graph[][];
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};

	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new char[N+1][M+1];
		
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			String s= st.nextToken();
			for(int j=1; j<=M; j++) {
				graph[i][j] = s.charAt(j-1);
			}
		}
		boolean visit[]= new boolean[26];
		cnt =1;
		ans =1;
		dfs(1,1,visit);
		
		System.out.println(ans);
	}
	static void dfs(int x, int y, boolean [] visit) {
		int alpha = (int) graph[x][y]-65;
		visit[alpha]= true;
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(xx>=1 && xx<=N && yy>=1 && yy<=M) {
				int next = graph[xx][yy]-65;
				if(!visit[next]) {
					ans = Math.max(++cnt, ans);
					dfs(xx,yy,visit);
				}
			}
		}
		--cnt;
		visit[alpha]=false;
	}

}
