package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex10026 {
	static int N,blind,normal;
	static int graph[][];
	static boolean visit[][];
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	
	public static void main(String [] args)throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph= new int [N][N];
		visit= new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			String s= st.nextToken();
			for(int j=0; j<N; j++) {
				if(s.charAt(j)=='R') {
					graph[i][j]=1;
				}else if(s.charAt(j)=='B') {
					graph[i][j]=2;
				}else {
					graph[i][j]=3;
				}
				visit[i][j]=false;
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					visit[i][j]=true;
					bfs(i,j,graph[i][j]);
					normal++;
				}
			}
		}
		for(int i=0; i<N; i++) {
			Arrays.fill(visit[i], false);
			for(int j=0; j<N; j++) {
				if(graph[i][j]==3) graph[i][j]=1;
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(!visit[i][j]) {
					visit[i][j]=true;
					bfs(i,j,graph[i][j]);
					blind++;
				}
			}
		}
		System.out.println(normal + " " + blind);
		
	}
	static void bfs(int x, int y, int c) {
		Queue<int []>q = new LinkedList<int []>();
		q.add(new int [] {x,y});
		while(!q.isEmpty()){
			int [] idx= q.poll();
			for(int i=0; i<4; i++) {
				int xx = idx[0]+dx[i];
				int yy = idx[1]+dy[i];
				
				if(xx>=0 && xx<N && yy>=0 && yy<N) {
					if(!visit[xx][yy] && graph[xx][yy]==c) {
						visit[xx][yy]=true;
						q.add(new int [] {xx,yy});
					}
				}
				
			}
		}
	}
}
