package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex1012 {
	static int [] dx = {0,0,-1,1};
	static int [] dy = {1,-1,0,0};
	static int N,M;
	static boolean visit[][];
	static int graph[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int ans [] = new int [T];
		
		for(int t=0; t<T; t++) {
			st = new StringTokenizer(br.readLine());
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			int K = Integer.parseInt(st.nextToken());
			graph = new int [N][M];
			visit = new boolean [N][M];
			for(int k =0; k<K; k++) {
				st = new StringTokenizer(br.readLine());
				int i=Integer.parseInt(st.nextToken());
				int j=Integer.parseInt(st.nextToken());
				graph[j][i]=1;
			}
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(graph[i][j]==1 && !visit[i][j]) {
						bfs(i,j);
						ans[t]++;
					}
				}
			}
		}
		for(int t: ans) {
			System.out.println(t);
		}
	}
	static void bfs(int x, int y) {
		Queue<int []> q = new LinkedList<int[]>();
		q.add(new int[] {x,y});
		while(!q.isEmpty()) {
			int [] idx= q.poll();
			for(int i=0; i<4; i++) {
				int xx = idx[0]+dx[i];
				int yy = idx[1]+dy[i];
				if(xx>=0 && xx<N && yy>=0 && yy<M) {
					if(!visit[xx][yy] && graph[xx][yy]==1) {
						visit[xx][yy]=true;
						q.add(new int [] {xx,yy});
					}
				}
				
			}
		}
	}

}
