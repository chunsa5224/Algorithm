package programmers;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class kakao2020intern04 {

	public static void main(String[] args) {
		int [][] d = {{0,0,1,0},{0,0,0,0},{0,1,0,1},{1,0,0,0}};
		System.out.println(solution(d));
	}
	static int [] dx = {-1,0,1,0};
	static int [] dy = {0,1,0,-1};
	static int N,d, answer;
	static int [][] map;
	static boolean [][] visit;
	static int [][] cost;
	
	public static int solution(int[][] board) {
		answer=Integer.MAX_VALUE;
		N=board.length;
		map = board;
		visit  = new boolean [N][N];
		cost = new int [N][N];
		for(int i=0; i<N; i++) {
			Arrays.fill(cost[i], Integer.MAX_VALUE);
		}
		cost[0][0]=0;
		visit[0][0]=true;
		bfs(new Node(0,0,-1));
		return answer;
	}
	
	static void bfs(Node node) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(node);
		int c=0;
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.x==N-1 && n.y==N-1) {
				answer = Math.min(answer, cost[N-1][N-1]);
				continue;
			}
			for(int i=0; i<4; i++) {
				int idx = (i+n.dir)%4;
				if(n.dir==-1) idx=i;
				int xx = n.x+dx[idx];
				int yy = n.y+dy[idx];
				
				if(xx>=0 && xx<N && yy>=0 && yy<N && map[xx][yy]!=1) {
					if(n.dir==idx || n.dir==-1) {
						c = 100;
					}else if(n.dir != idx){
						c = 600;
					}
					if(!visit[xx][yy] || cost[xx][yy]>=cost[n.x][n.y]+c) {
						visit[xx][yy]=true;
						q.add(new Node(xx,yy,idx));
						cost[xx][yy]=cost[n.x][n.y]+c;
						System.out.println(xx +", "+ yy +", "+ idx + " : "+ cost[xx][yy]);
					}
				}				
			}
		}
		
	}

}
class Node{
	int x;
	int y;
	int dir;
	
	Node(int x, int y, int dir){
		this.x = x;
		this.y = y;
		this.dir= dir;
		
	}
}