package baekjoon;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex2178 {
	static int [][] maze;
	static int [] my = {0,0,-1,1};
	static int [] mx = {1,-1,0,0};
	static boolean [][] visit;
	static int n;
	static int m;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		maze =new int [n][m];
		visit = new boolean[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			String line = st.nextToken();
			for(int j=0; j<m; j++) {
				maze[i][j]= line.charAt(j)-'0';
			}
		}
		
		find(0,0);
		System.out.println(maze[n-1][m-1]);
		
		
	}
	static void find(int i, int j) {
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int [] {i,j});
		
		while(!queue.isEmpty()) {
			int location[]=queue.poll();
			visit[i][j]=true;
			
			for(int k = 0; k<4; k++) {
				int xx= location[0]+ mx[k];
				int yy= location[1] +my[k];
				
				if(xx>=0 && xx<n && yy>=0 && yy<m) {
					if(maze[xx][yy]!=0 && !visit[xx][yy]) {
						queue.add(new int [] {xx,yy});
						visit[xx][yy]=true;
						maze[xx][yy]= maze[location[0]][location[1]]+1;
					}
				}
				
			}
 		}
		
		
	}

}
