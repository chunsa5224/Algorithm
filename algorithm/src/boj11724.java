

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ex11724 {
	static ArrayList<Integer>[] graph;
	static boolean visit [];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		visit = new boolean [N+1];
		graph = new ArrayList[N+1];
		
		for(int i=0; i<=N; i++) {
			graph[i]= new ArrayList<Integer>();
		}
		
 		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
 		int group =0;
  		for(int i=1; i<=N; i++) {
  			if(!visit[i]) {
  				dfs(i);
  				group++;
  			}
 		}
  		System.out.println(group);
		
	}
	static void dfs(int i) {
		visit[i]=true;
		for(int j : graph[i]) {
			if(!visit[j]) {
				dfs(j);
			}
		}
	}

}
