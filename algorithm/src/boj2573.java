

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj2573 {
	static int N,M,total;
	static int height [][];
	static int zero [][];
	static boolean visit[][];
	static int dx [] = {-1,1,0,0};
	static int dy [] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		height = new int [N][M];
		zero = new int [N][M];
		visit = new boolean[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<M; j++) { 
				height[i][j]= Integer.parseInt(st.nextToken());
			}
		}

		int year=0;
		while(true) {
			total=0;
			for(int i=0; i<N; i++) {
				Arrays.fill(zero[i], 0);
				Arrays.fill(visit[i],false);
			}
			//대륙 갯수 확인 
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					if(!visit[i][j] && height[i][j]>0) {
						total++;
						visit[i][j]=true;
						dfs(i,j);
					}
				}
			}
			if(total>=2) {
				break;
			}
			// 1년 지남
			int ice =0;
			for(int i=0; i<N; i++) {
				for(int j=0; j<M; j++) {
					height[i][j]= height[i][j] - zero[i][j];
					if(height[i][j]<=0) {
						height[i][j]=0;
						ice++;
					}
				}
			}
			if(ice==N*M) {
				year=0;
				break;
			}
			year++;
		}
		System.out.println(year);
		
	}
	static void dfs(int x , int y) {
		for(int i=0; i<4; i++) {
			int xx= x+ dx[i];
			int yy= y+ dy[i];
			if(xx>=0 && xx<N && yy>=0 && yy<M) {
				if(height[xx][yy]<=0) {
					zero[x][y]++;
				}
				if(height[xx][yy]>0 && !visit[xx][yy]) {
					visit[xx][yy]=true;
					dfs(xx,yy);
				}
			}
		}
	}

}
