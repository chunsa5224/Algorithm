import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj3190 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int k = Integer.parseInt(br.readLine());
		int [][] map = new int[n][n];
		boolean [][] visit = new boolean[n][n];
		
		int [] dx = {0,1,0,-1};
		int [] dy= {1,0,-1,0};
		
		StringTokenizer st;
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine()," ");
			map[Integer.parseInt(st.nextToken())-1][Integer.parseInt(st.nextToken())-1]=1;
		}
		int l = Integer.parseInt(br.readLine());
		int [] rotate = new int [10000];
		for(int i=0; i<l;i++) {
			st = new StringTokenizer(br.readLine()," ");
			rotate[Integer.parseInt(st.nextToken())]= st.nextToken().equals("D")?1:-1;
		}
		
		Queue<body> snake = new LinkedList<body>();
		body head = new body(0,0);
		visit[0][0]=true;
		snake.add(head);
		int i = 0;
		int time =0;
		while(true) {
			if(time<10000 && rotate[time]!=0) {
				i=i+rotate[time];
				if(i<0) i=3;
				if(i>3) i=0;
			}
			time=time+1;
			body temp = new body(head.x+dx[i], head.y+dy[i]);
			
			if(temp.x>=0 && temp.x<n && temp.y>=0 && temp.y<n) {
				if(visit[temp.x][temp.y]) {
					break;
				}
				if(map[temp.x][temp.y]!=1) {
					snake.add(temp);
					visit[temp.x][temp.y]=true;
					body rem = snake.poll();
					visit[rem.x][rem.y]=false;
					head = temp;
				}else {
					map[temp.x][temp.y]=0;
					snake.add(temp);
					visit[temp.x][temp.y]=true;
					head = temp;
				}
			}else {
				break;
			}
		}
		System.out.println(time);

	}
	static class body{
		int x;
		int y;
		body(int x, int y){
			this.x = x;
			this.y = y;
		}
		
	}
}


