import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class boj14500 {
	static int N,M, count, max;
	static int map [][];
	static boolean visit [][];
	static int dx [] = {-1,0,1,0}; 
	static int dy [] = {0,1,0,-1};
	
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine()," ");
		N= Integer.parseInt(st.nextToken());
		M= Integer.parseInt(st.nextToken());
		
		map = new int [N+6][M+6];
		visit = new boolean [N+6][M+6];
		
		for(int i=0; i<N+6; i++) {
			Arrays.fill(visit[i], true);
		}
		for(int i=3; i<N+3; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=3; j<M+3; j++) {
				map[i][j]= Integer.parseInt(st.nextToken());
				visit[i][j]= false;
			}
		}
		for(int i=3; i<N+3; i++) {
			for(int j=3; j<M+3; j++) {
				visit[i][j]=true;
				tetromino(i,j,1,map[i][j]);
				specialBlock(i,j);
				visit[i][j] = false;
			}
		}
		System.out.println(max);
		
	}
	static void tetromino(int r, int c, int count, int sum) {
		if(count==4) {
			max= Math.max(sum, max);
			return;
		}
		for(int i=0 ;i<4; i++) {
			int x = r + dx[i];
			int y = c + dy[i];
			
			if(!visit[x][y]) {
				visit[x][y]=true;
				tetromino(x,y, count+1, sum + map[x][y]);
				visit[x][y]=false;
			}
		}
		
	}
	static void specialBlock(int r, int c) {
		int total = map[r][c];
		int cnt=0;
		for(int i=0; i<4; i++) {
			boolean flag = true;
			cnt = map[r][c];
			int x = r + dx[i];
			int y = c + dy[i];
			if(visit[x][y]) {
				continue;
			}
			cnt+=map[x][y];
			for(int j=1; j<3; j++) {
				int xx = r + dx[(i+j)%4];
				int yy = c + dy[(i+j)%4];
				if(!visit[xx][yy]) cnt += map[xx][yy];
				else {
					flag=false;
					break;
				}
			}
			if(flag) total=Math.max(total, cnt);
		}
		if(total>map[r][c]) max= Math.max(total, max);
	}

}
