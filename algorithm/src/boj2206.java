

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

<<<<<<< HEAD
public class boj2206 {
=======
public class ex2206 {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git
	static int N,M,total; 
	static int [][] graph;
	static boolean possible;
	static int [][] visit;
	static int [] dx = {-1,1,0,0};
	static int [] dy = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int [N+1][M+1];
		visit = new int [N+1][M+1];
		total = 10000000;
		for(int i=0; i<=N ; i++) {
			Arrays.fill(graph[i], 1);
			Arrays.fill(visit[i], 10000000);
		}
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine());
			String s= st.nextToken();
			for(int j=1; j<=M; j++) {
				graph[i][j] = s.charAt(j-1)-'0';
			}
		}
		bfs(1,1);
		if(total>=10000000) total = -1;
		System.out.println(total);
		
	}
	static void bfs(int x, int y) {
		Queue<Place> q = new LinkedList<Place>();
		q.add(new Place(x,y,1,0));
		visit[x][y]=0;
		while(!q.isEmpty()) {
			Place p = q.poll();
			if(p.x==N && p.y==M) {
				total = p.dist;
				break;
			}
			for(int i=0; i<4; i++) {
				int xx = p.x+dx[i];
				int yy = p.y+dy[i];
				if(xx>=1 && xx<=N && yy>=1 && yy<=M) {
					if(visit[xx][yy]<=p.drill) continue;
					if(graph[xx][yy]==0) {
						visit[xx][yy]=p.drill;
						q.add(new Place(xx,yy,p.dist+1,p.drill));
					}else if(graph[xx][yy]==1 && p.drill==0) {
						visit[xx][yy]=p.drill+1;
						q.add(new Place(xx,yy,p.dist+1,p.drill+1));
					}
				}
			}
		}
	}
}
class Place{
	int x;
	int y;
	int dist;
	int drill;
	Place(int x, int y, int dist, int drill) {
		this.x=x;
		this.y=y;
		this.dist=dist;
		this.drill=drill;
	}
}
