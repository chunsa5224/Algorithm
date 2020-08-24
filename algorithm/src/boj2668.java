import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj2668 {
	static int graph[];
	static boolean visit[];
	static boolean finish[];
	static boolean isCycle[];
	static int cycle;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		cycle=0;
		graph = new int [N+1];
		visit= new boolean[N+1];
		finish= new boolean[N+1];
		isCycle= new boolean[N+1];
		for(int i=1; i<=N;i++) {
			graph[i]=Integer.parseInt(br.readLine());
		}
		for(int i=1; i<=N;i++) {
			dfs(i);
		}
		System.out.println(cycle);
		for(int i=1; i<=N; i++) {
			if(isCycle[i]) System.out.println(i);
		}
	}
	static void dfs(int i) {
		if(visit[i]) return;
		visit[i]=true;
		int next = graph[i];
		if(!visit[next]) {
			dfs(next);
		}else { //재방문
			if(!finish[next]) { //재방문이면서 finish 안된거면 사이클
				cycle++;
				isCycle[next]=true;
				isCycle[i]=true;
				for(int j=next; j!=i;j=graph[j]) {
					cycle++;
					isCycle[j]=true;
				}
			}
		}
		finish[i]=true;
	}

}
