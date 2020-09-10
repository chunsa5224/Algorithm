import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj15686 {
	static int N,M,city,dist,chicken, ans;
	static int map [][];
	static int copy [][];
	static boolean visit [][];
	static int dx [] = {-1,0,1,0};
	static int dy [] = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int [N][N];
		visit = new boolean[N][N];
		copy = new int [N][N];
		chicken=0;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				visit[i][j]=false;
				if(map[i][j]==2) chicken++;
			}
		}
		closeChicken(0,0);
		System.out.println(ans);
		
	}
	
	static void findDist(int x, int y) {
		Queue<House> q = new LinkedList<House>();
		q.add(new House(x,y,0));
		while(!q.isEmpty()) {
			House n = q.poll();
			for(int i=0; i<4; i++) {
				int xx = n.x + dx[i];
				int yy = n.y + dy[i];
				if(xx>=0 && xx<N && yy>=0 && yy<N && !visit[xx][yy]) {
					if(copy[xx][yy]!=2) {
						visit[xx][yy]=true;
						q.add(new House(xx,yy,n.dist+1));
					}else if(copy[xx][yy]==2) {
						city = city + n.dist + 1 ;
						return;
					}
				}
			}
			
		}
	}
	static void copyMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				copy[i][j]=map[i][j];
			}
		}
	}
	static void closeChicken(int close, int next) {
		if(close==chicken-M) {
			copyMap();
			for(int i=0; i<N; i++) {
				for(int j=0; j<N;j++) {
					if(copy[i][j]==1) {
						visit[i][j]=true;
						findDist(i,j);
						visit = new boolean[N][N];
					}
				}
			}
			if(ans==0) ans = city;
			ans = Math.min(ans, city);
			city=0;
			return;
		}
		for(int i=next; i<N*N;i++) {
			if(map[i/N][i%N]==2) {
				map[i/N][i%N]=0;
				closeChicken(close+1,i);
				map[i/N][i%N]=2;
			}
		}
		
	}

}
class House {
	int x;
	int y;
	int dist; 
	public House(int x, int y, int dist) {
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
}
