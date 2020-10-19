

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

<<<<<<< HEAD
public class boj6118 {
=======
public class ex6118 {
>>>>>>> branch 'master' of https://github.com/chunsa5224/Algorithm.git
	static int n;
	static int m;
	static int dist [];
	static boolean visit[];
	static ArrayList<Integer>[] road ;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String s [] = br.readLine().split(" ");
		n = Integer.parseInt(s[0]);
		m = Integer.parseInt(s[1]);
		dist = new int [n+1];
		visit = new boolean[n+1];
		
		for(int i=2;i<=n;i++) {
			dist[i]=Integer.MAX_VALUE;
		}
		road = new ArrayList[n+1];
		
		for(int i=0; i<n+1;i++) {
			road[i]= new ArrayList<Integer>();
		}
		
		for(int i=0; i<m; i++) {
			s=br.readLine().split(" ");
			int a = Integer.parseInt(s[0]);
			int b = Integer.parseInt(s[1]);
			road[a].add(b);
			road[b].add(a);
		}
		for(int i=1; i<n+1; i++) {
			Collections.sort(road[i]);
		}
		
		bfs(1);
		
		int max=0;
		int cnt=0;
		int idx=2;
		
		for(int i=n;i>=2;i--) {
			if(dist[i]>=max) {
				max=dist[i];
				idx=i;
			}
		}
		for(int i=n;i>=2;i--) {
			if(dist[i]==max) {
				cnt++;
			}
		}
		System.out.println(idx+" "+max+" "+cnt);
	}
	
	static void bfs(int s) {
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(s);
		visit[s] =true;
		while(!queue.isEmpty()) {
			int x = queue.poll();
			for(int i: road[x]) {
				if(!visit[i]) {
					if(x==s) {
						dist[i]=1;
					}else {
						dist[i]= Math.min(dist[x]+1, dist[i]);
					}
					visit[i]=true;
					queue.add(i);
				}
			}
		}
	}

}
