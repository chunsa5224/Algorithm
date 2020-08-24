

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj2468 {
	static int graph [][] ;
	static boolean visit[][];
	static int dx [] = {-1,1,0,0};
	static int dy [] = {0,0,-1,1};
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		graph = new int [N][N];
		visit = new boolean [N][N];
		int min =0; 
		int max=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				graph [i][j]= Integer.parseInt(st.nextToken());
				min = Math.min(graph[i][j], min);
				max = Math.max(graph[i][j], max);
			}
		}
		int cnt =0;
		for(int h=min; h<max; h++) {
			 for(int i=0; i<N; i++) {
				 for(int j=0; j<N; j++) {
					 visit[i][j]=false;
					 if(graph[i][j]==h) {
						 graph[i][j]=0;
					 }
				 }
			 }
			 int temp =0;
			 for(int i=0; i<N; i++) {
				 for(int j=0; j<N; j++) {
					 if(!visit[i][j] && graph[i][j]>0) {
						 visit[i][j]=true;
						 dfs(i,j);
						 temp ++;
					 }
				 }
			 }
			 cnt = Math.max(cnt, temp);
		}
		System.out.println(cnt);
		
	}
	
	static void dfs(int x, int y) {
		for(int i=0; i<4; i++) {
			int xx = x + dx[i];
			int yy = y + dy[i];
			if(xx>=0 && yy>=0 && xx<N && yy<N) {
				if(!visit[xx][yy] && graph[xx][yy]>0) {
					visit[xx][yy] =true;
					dfs(xx,yy);
				}
				
			}
		}
	}

}
