import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj1167 {
	static int V;
	static List<Node>[] list;
	static boolean[] visit;
	static Node maxNode;
	static int max = 0;
	public static void main(String[] args) throws IOException  {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		V = Integer.parseInt(st.nextToken());
		list = new ArrayList[V+1];
		visit = new boolean[V+1];
		for(int i=0;i<=V; i++) list[i]= new ArrayList<Node>();
		for(int i=1; i<=V; i++) {
			st = new StringTokenizer(br.readLine()," ");
			int a = Integer.parseInt(st.nextToken());
			while(true) {
				int node = Integer.parseInt(st.nextToken());
				if(node==-1) break;
				int dist = Integer.parseInt(st.nextToken());
				list[a].add(new Node(node,dist));
				list[node].add(new Node(a,dist));
			}
		}
		dfs(1,0);
		max=0;
		visit= new boolean[V+1];
		dfs(maxNode.node, 0);
		System.out.println(max);
		
	}
	static void dfs(int v, int dist) {
		if(visit[v]) return;
		visit[v]=true;
		for(Node n: list[v]) {
			if(!visit[n.node]) {
				if(max <n.dist+dist) {
					max= n.dist+dist;
					maxNode = n;
				}
				dfs(n.node, n.dist+dist);
			}
		}
	}

}
class Node{
	int node, dist;
	public Node(int node, int dist) {
		this.node=node;
		this.dist=dist;
	}
}
