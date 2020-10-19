import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj1937 {
	static int [][] map;
	static int [][] day;
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,-1,0,1};
	static int n;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine());
		n = Integer.parseInt(st.nextToken());
		map  = new int [n][n];
		day = new int [n][n];
		for(int i=0; i<n; i++) {
			st = new StringTokenizer (br.readLine()," ");
			for(int j=0; j<n; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int ans=0;
		for(int i=0; i<n; i++) {
			for(int j=0; j<n; j++) {
				if(day[i][j]==0) {
					ans = Math.max(ans, mov(i,j));
				}
			}
		}
		System.out.println(ans);
		
		
		
	}
	static int mov(int x, int y) {
		if(day[x][y]!=0) return day[x][y];
		int cnt=1;
		for(int i=0; i<4; i++) {
			int xx= x +dx[i];
			int yy= y+dy[i];
			if(xx>=0 && xx<n && yy>=0 && yy<n) {
				if(map[xx][yy]>map[x][y]) {
					cnt=Math.max(mov(xx,yy)+1 ,cnt);
					day[x][y]=cnt;
				}
			}
		}
		return cnt;
	}

}


