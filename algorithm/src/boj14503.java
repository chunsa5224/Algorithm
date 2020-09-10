import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj14503 {
	static int R,C,count;
	static int graph [][];
	static boolean visit[][];
	static int lx [] = {0,-1,0,1};
	static int ly [] = {-1,0,1,0};
	static int by [] = {0,-1,0,1};
	static int bx [] = {1,0,-1,0};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer (br.readLine()," ");
		R= Integer.parseInt(st.nextToken());
		C= Integer.parseInt(st.nextToken());
		st = new StringTokenizer (br.readLine()," ");
		int x = Integer.parseInt(st.nextToken());
		int y = Integer.parseInt(st.nextToken());
		int d = Integer.parseInt(st.nextToken());
		graph = new int [R][C];
		visit = new boolean [R][C];
		
		for(int i=0; i<R; i++) {
			st = new StringTokenizer(br.readLine()," ");
			for(int j=0; j<C; j++) {
				graph[i][j]= Integer.parseInt(st.nextToken());
			}
		}
		clean(x,y,d);
		System.out.println(count);
		
		
		
	}
	static void clean(int x, int y, int d) {
		if(!visit[x][y]) {
			visit[x][y]=true;
			count++;
		}
		int i=d+4;
		for(;i>d; i--) {
			int xx= x +lx[i%4];
			int yy= y +ly[i%4];
			if(graph[xx][yy]!=1 && !visit[xx][yy]) {
				clean(xx,yy,(i-1)%4); 
				return;
			}
		}
		if(i==d) {
			int xx= x+bx[d];
			int yy= y+by[d];
			if(graph[xx][yy]!=1) {
				clean(xx,yy,d);
			}else {
				return;
			}
		}
		
	}

}
