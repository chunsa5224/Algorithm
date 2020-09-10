import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14499 {	
	static int dx [] = {0,0,-1,1};
	static int dy [] = {1,-1,0,0};
	static int N, M, top, right, front, x, y;
	static int map[][];
	static int [] dice;
	static int [] command;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		map = new int [N][M];
		dice = new int [6];
		top = 0;
		right = 2;
		front = 4;
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine(), " ");
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		command= new int [K];
		st = new StringTokenizer(br.readLine(), " ");
		for(int i=0; i<K; i++) {
			command[i] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=0; i<K; i++) {
			rolling(i);
		}
		
		
		
	}
	static void rolling(int d) {
		int dir = command[d]-1;
		int nx = x + dx[dir];
		int ny = y + dy[dir];
		
		if(nx>=0 && nx<N && ny>=0 && ny<M) {
			int ptop = top;
			int pright= right;
			int pfront =front;
			
			if(dir==0) {
				top = 5-pright;
				right=ptop;
				front = pfront;
			}else if(dir==1) {
				top = pright;
				right = 5-ptop;
				front = pfront;
			}else if(dir==2) {
				top = pfront;
				front = 5-ptop;
				right= pright;
			}else if(dir==3) {
				top = 5-pfront;
				front =ptop;
				right= pright;
			}
			
			if(map[nx][ny]==0) {
				map[nx][ny] = dice[5-top];
			}else {
				dice[5-top]=map[nx][ny];
				map[nx][ny]=0;
			}
			x=nx;
			y=ny;
			System.out.println(dice[top]);
			
		}else {
			return;
		}
	}
}
