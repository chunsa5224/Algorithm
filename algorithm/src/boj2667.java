

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj2667 {
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
		ans = new int[1000000];
		apt = 0;
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
					ans[apt]++;
					graph[i][j]=apt;
					bfs(i,j);
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
	static void bfs(int x, int y) {
		Queue<int []> queue = new LinkedList<>();
		queue.add(new int [] {x,y});
		while(!queue.isEmpty()) {
			int [] index = queue.poll();
			visit[x][y]=true;
			
			for(int i=0; i<4; i++) {
				int xx = index[0]+dx[i];
				int yy = index[1]+dy[i];
				
				if(xx>=0 && yy>=0 && xx<N && yy<N) {
					if(graph[xx][yy]!=0 && !visit[xx][yy]) {
						ans[apt]++;
						graph[xx][yy]=apt;
						visit[xx][yy]=true;
						queue.add(new int [] {xx,yy});
					}
				}
			}
		}
		
	}
	

}
