

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj7576 {
	
	static int N,M;
	static int [][] tomato;
	static int [][] dist;
	static int [] dy = {0,0,-1,1};
	static int [] dx = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		tomato = new int [N][M];
		dist = new int [N][M];
		Queue<Dot> q = new LinkedList<Dot>();
		int day=0;
		
		for(int i=0; i<N;i++) {
			Arrays.fill(tomato[i], -1);
		}
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				tomato[i][j]=Integer.parseInt(st.nextToken());
				if(tomato[i][j]==1) {
					q.offer(new Dot(i,j));
				}
			}
		}
		while(!q.isEmpty()) {
			Dot d = q.poll();
			int today = dist[d.x][d.y];
			for(int i=0; i<4; i++) {
				int a = d.x + dx[i];
				int b = d.y + dy[i];
				if(0<=a && 0<=b && a<N && b<M) {
					if(tomato[a][b]==0) {
						tomato[a][b]=1;
						dist[a][b]= today+1;
						q.offer(new Dot(a,b));
					} 
				}
			}
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				day = Math.max(dist[i][j], day);				
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(tomato[i][j]==0) {
					day = -1; 
				}
			}
		}
		System.out.println(day);
		
	}

}
class Dot{
	int x;
	int y;
	Dot(int x, int y){
		this.x = x;
		this.y = y;
	}
}
