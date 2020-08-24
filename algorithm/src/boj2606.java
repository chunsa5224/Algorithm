import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj2606 {
	static int N;
	static ArrayList<Integer> graph [];
	static boolean visit[];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken());
		graph = new ArrayList[N+1];
		visit = new boolean [N+1];
		for(int i=0; i<N+1; i++) {
			graph[i] = new ArrayList<Integer>();
		}
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			graph[a].add(b);
			graph[b].add(a);
		}
		dfs(1);
		int virus=0;
		for(int i=1; i<=N;i++) {
			if(visit[i]) virus++;
		}
		System.out.println(virus-1);
		
	}
	static void dfs(int i) {
		if(visit[i]) return;
		visit[i]=true;
		for(int j:graph[i]) {
			dfs(j);
		}
	}
	

}
