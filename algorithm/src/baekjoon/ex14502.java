package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class ex14502 {
	static int N,M,safe;
	static int [][] graph;
	static int [][] copy;
	static List<int[]> virusList = new ArrayList<int[]>();
	static int [] dy = {0,0,-1,1};
	static int [] dx = {1,-1,0,0};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		graph = new int [N][M];
		copy = new int [N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				int temp =Integer.parseInt(st.nextToken());
				graph[i][j]= temp;
				if(temp==2) {
					virusList.add(new int [] {i,j});
				}
			}
		}
		dfs(0);
		System.out.println(safe);
		
		
	}
	static void copyMap() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				copy[i][j]=graph[i][j];
			}
		}
	}
	static void dfs(int cnt) {
		if(cnt==3) {
			copyMap();
			bfs();
			return;
		}
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(graph[i][j]==0) {
					graph[i][j]=1;
					dfs(cnt+1);
					graph[i][j]=0;
				}
			}
		}
	}
	static void bfs() {
		Queue<int[]> q = new LinkedList<int[]>();
		q.addAll(virusList);
		while(!q.isEmpty()) {
			int [] idx = q.poll();
			for(int i=0; i<4; i++) {
				int a = idx[0] + dx[i];
				int b = idx[1] + dy[i];
				
				if(a>=0 && a<N && b>=0 && b<M) {
					if(copy[a][b]==0) {
						copy[a][b]=2;
						q.add(new int[] {a,b});
					}
				}
			}
		}
		int temp=0;
		for(int i=0; i<N;i++) {
			for(int j: copy[i]) {
				if(j==0) {
					temp++;
				}
			}
		}
		safe = Math.max(safe, temp);
		
	}

}
