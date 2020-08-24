

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class boj1260 {
	static boolean visit [];
	static ArrayList<Integer>[] list; 
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s [] = br.readLine().split(" ");
		int N = Integer.parseInt(s[0]);
		int M = Integer.parseInt(s[1]);
		int V = Integer.parseInt(s[2]);
		
		list = new ArrayList[N+1];
		
		for(int i=0; i<N+1; i++) {
			list[i]= new ArrayList<Integer>();
		}
		
		for(int i=0; i<M; i++) {
			s= br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			list[a].add(b);
			list[b].add(a);
		}
		
		for(int i=1; i<N+1; i++) {
			Collections.sort(list[i]);
		}
		
		visit = new boolean [N+1];
		dfs(V);
		visit = new boolean [N+1];
		System.out.println();
		bfs(V);
		
		
	}
	static void dfs(int v) {
		if(visit[v]) return;
		visit[v]=true;
		System.out.print(v + " ");
		for(int i: list[v]) {
			if(!visit[i]) dfs(i);
		}
	}
	
	static void bfs(int v) {
		Queue<Integer> queue= new LinkedList<Integer>();
		queue.add(v);
		visit[v]=true;
		
		while(!queue.isEmpty()) {
			int x = queue.poll();
			System.out.print(x + " ");
			for(int i: list[x]) {
				if(!visit[i]) {
					visit[i]=true;
					queue.add(i);
				}
			}
		}
		
	}
	

}
