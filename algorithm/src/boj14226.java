import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class boj14226 {
	static int S;
	public static void main(String[] args) throws IOException{
		BufferedReader br= new  BufferedReader(new InputStreamReader(System.in));
		S = Integer.parseInt(br.readLine());
		int answer = 0;
		
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(1,0,0));
		boolean [][] visited =new boolean[2002][2002];
		visited[1][0]= true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(n.len==S) {
				answer = n.cnt;
				break;
			}
			//copy
			q.add(new Node(n.len, n.len, n.cnt+1));
			//paste
			if(n.buf != 0 && !visited[n.len+n.buf][n.buf]&& n.len+n.buf<=1000) {
				visited[n.len + n.buf][n.buf]=true;
				q.add(new Node(n.len + n.buf, n.buf, n.cnt+1));
			}
			//delete
			if(n.len>0 && !visited[n.len-1][n.buf]&& n.len-1 <=1000) {
				visited[n.len-1][n.buf]=true;
				q.add(new Node(n.len-1, n.buf, n.cnt+1));
			}
		}
		
		
		System.out.println(answer);
		
	}
	
	static class Node{
		int len;
		int buf;
		int cnt;
		Node(int len, int buf, int cnt){
			this.len = len;
			this.buf = buf;
			this.cnt = cnt;
		}
	}
	
}

