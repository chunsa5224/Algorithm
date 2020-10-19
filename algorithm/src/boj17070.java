import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj17070 {
	static int N;
	static int [][] map ;
	static int [] dx = {0,1,1};
	static int [] dy = {1,1,0};
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st;
		map = new int [N+1][N+1];
		for(int i=1; i<=N; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=1; j<=N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans = dp(1,2,0);
		System.out.println(ans);
		
	}
	static int dp(int x, int y, int dir) {
		int sum=0;
		if(x==N && y==N) return 1;
		if(dir==0) {
			for(int i=0; i<2; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(xx<=N && yy<=N && checkWall(xx,yy,i)) {
					sum += dp(xx,yy,i);
				}
			}
		}else if(dir==2) {
			for(int i=1; i<3; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(xx<=N && yy<=N && checkWall(xx,yy,i)) {
					sum += dp(xx,yy,i);
				}
			}
		}else {
			for(int i=0; i<3; i++) {
				int xx = x + dx[i];
				int yy = y + dy[i];
				if(xx<=N && yy<=N && checkWall(xx,yy,i)) {
					sum += dp(xx,yy,i);
				}
			}
		}
		return sum;
	}
	static boolean checkWall(int x, int y, int dir) {
		if(dir==1) {
			if(map[x][y-1]!=1 && map[x-1][y]!=1 && map[x][y]!=1) return true;
		}else if(map[x][y]!=1) return true;
		
		return false;
	}

}
